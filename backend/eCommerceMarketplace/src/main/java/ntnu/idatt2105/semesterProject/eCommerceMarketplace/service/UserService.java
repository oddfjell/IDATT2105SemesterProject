package ntnu.idatt2105.semesterProject.eCommerceMarketplace.service;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Address;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.LoginResponse;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.UserRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * Service for UserController
 */
@Service
public class UserService {

    /**
     * UserRepository field injection
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * TokenService field injection
     */
    @Autowired
    private TokenService tokenService;

    /**
     * CREATE user
     * Creates an user with given user data if the unique fields does not already exist
     * @param user User
     * @return int
     */
    public int createUser(User user) {
        int returnedValue = checkIfFieldsAreAlreadyInUse(user);

        // If returnedValue is 3, neither username, phoneNumber nor email has been taken
        if (returnedValue == 3) {
            userRepository.save(user);
        }
        return returnedValue;
    }

    /**
     * GET users
     * Returns all the users
     * @return Iterable<User>
     */
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * GET user
     * Returns a user with given username
     * @param username String
     * @return User
     */
    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    /**
     * GET user
     * Returns a user with given id
     * @param id int
     * @return User
     */
    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    /**
     * UPDATE user
     * Updates a existing user with given user data //TODO (NOT FINISHED!!!)
     * @param user User
     * @return int
     */
    public int updateUser(User user) {

        int returnedValue = checkIfFieldsAreAlreadyInUse(user);

        // If returnedValue is 3, neither username, phoneNumber nor email has been taken
        if (returnedValue == 3) {
            // UPDATE USER
            // userRepository.save(user);
        }
        return returnedValue;
    }

    /**
     * LOGIN
     * Checks if the user exists and returns a jwt-token, id and role
     * @param payload Map<String, Object>
     * @return LoginResponse
     */
    public LoginResponse loginUser(Map<String, Object> payload) {//boolean
        String username = payload.get("username").toString();
        String password = payload.get("password").toString();

        for (User user : userRepository.findAll()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                String jwt = tokenService.generateToken(username);
                int id = userRepository.findByUsername(username).getId();
                String role = userRepository.findByUsername(username).getRole();
                if(role == null){
                    role = "ROLE_USER";
                }
                return new LoginResponse(jwt, id, role);
            }
        }
        return null;
    }

    /**
     * Checks if the name, email or phone already exists
     * @param user User
     * @return int
     */
    public int checkIfFieldsAreAlreadyInUse(User user) {
        try {
            // Checks if user with given username already exist in database
            if (userRepository.findByUsername(user.getUsername()) != null) {
                return 0;
            }

            // Checks if user with given phone_number already exist in database
            if (userRepository.findByPhoneNumber(user.getPhoneNumber()) != null) {
                return 1;
            }

            // Checks if user with given phone_number already exist in database
            if (userRepository.findByEmail(user.getEmail()) != null) {
                return 2;
            }

            return 3;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 4;
        }
    }

    /**
     * Delete user (id must be present in payload, or new user will be created)
     * @param user User
     * @return boolean
     */
    public boolean deleteUser(User user) {
        try {

            // Check if user actually exist in database before deletion:
            if (!userRepository.existsById(user.getId())) {
                System.out.println("User with given id does not exist in database");
                return false;
            }

            // Delete user from data by its id
            userRepository.deleteById(user.getId());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Checks if the user is an admin. If the user does to have a role it will be set as a ROLE_USER
     * @param user User
     * @return String
     */
    public String isAdmin(User user){
        String role = userRepository.findByUsername(user.getUsername()).getRole();
        if (role == null){
            role = "ROLE_USER";
        }
        return role;
    }

    /**
     * GET address
     * Gets the address of a user
     * @param id int
     * @return Address
     */
    public Address getAddress(int id){
        try {
            Address address = userRepository.findById(id).getAddress();
            return address;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
