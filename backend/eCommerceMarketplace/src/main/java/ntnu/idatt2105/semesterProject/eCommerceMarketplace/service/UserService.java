package ntnu.idatt2105.semesterProject.eCommerceMarketplace.service;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.LoginResponse;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.UserRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;


    // Logic for creating a new user with given user data
    public int createUser(User user) {
        int returnedValue = checkIfFieldsAreAlreadyInUse(user);

        // If returnedValue is 3, neither username, phoneNumber nor email has been taken
        if (returnedValue == 3) {
            userRepository.save(user);
        }
        return returnedValue;
    }


    // Logic for returning all users
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }


    // Logic for returning user with given username
    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }


    // Logic for returning user with given id
    public User getUserById(int id) {
        return userRepository.findById(id);
    }


    // Logic for updating a existing user with given user data (NOT FINISHED!!!)
    public int updateUser(User user) {

        int returnedValue = checkIfFieldsAreAlreadyInUse(user);

        // If returnedValue is 3, neither username, phoneNumber nor email has been taken
        if (returnedValue == 3) {
            // UPDATE USER
            // userRepository.save(user);
        }
        return returnedValue;
    }


    // Logic for deleting a user with given user data
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


    // ?
    public String isAdmin(User user){
        String role = userRepository.findByUsername(user.getUsername()).getRole();
        if (role == null){
            role = "ROLE_USER";
        }
        return role;
    }


    // ?
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
}
