package ntnu.idatt2105.semesterProject.eCommerceMarketplace.service;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.LoginResponse;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.UserRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    /**
     * Returns all the users
     * @return Iterable<User>
     */
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
        //return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    /**
     * login
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
     * Creates new user and adds it to database
     * Proposed solution for return values:
     *  0: username ALREADY EXIST
     *  1: phoneNumber ALREADY EXIST
     *  2: email ALREADY EXIST
     *  3: CREATED
     *  4: ERROR
     * @param user User
     * @return int
     */
    public int createUser(User user) { //TODO or register??
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

            // Since username, phoneNumber and email were not already taken, user is created
            userRepository.save(user);
            return 3;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 4;
        }
    }


    /**
     * Get user
     * @param username
     * @return
     */
    public User getUsername(String username){

        return userRepository.findByUsername(username);
        /*if(user != null){
            return user;
        } else return null;*/
        //throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Access denied, wrong credentials....");
    }

    /**
     * Returns s user with given id
     * @param id int
     * @return Optional<User>
     */
    public User getUser(int id) {
        return userRepository.findById(id);
    }//TODO username

    /**
     * Update user (id must be present in payload, or new user will be created)
     * Proposed solution for return values:
     *  0: username ALREADY EXIST
     *  1: phoneNumber ALREADY EXIST
     *  2: email ALREADY EXIST
     *  3: CREATED
     *  4: ERROR
     * @param user User
     * @return int
     */
    public int updateUser(User user) { //TODO sende string??
        try {

            System.out.println(user.getPhoneNumber());
            System.out.println(userRepository.findByPhoneNumber(user.getPhoneNumber()));

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

            // Update here
            userRepository.save(user);
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
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String isAdmin(User user){
        String role = userRepository.findByUsername(user.getUsername()).getRole();
        if (role == null){
            role = "ROLE_USER";
        }
        return role;
    }
}
