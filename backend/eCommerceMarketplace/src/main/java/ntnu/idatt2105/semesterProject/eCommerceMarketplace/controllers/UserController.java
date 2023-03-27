package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.LoginResponse;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true")
public class UserController { //TODO login

    @Autowired
    private UserService userService;

    // Return all users
    @CrossOrigin
    @GetMapping("/")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.getAllUsers();
       // return userRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/service/login")
    public @ResponseBody LoginResponse loginUser(@RequestBody Map<String, Object> payload) {//var string
        System.out.println(payload);
        return userService.loginUser(payload);
    }

    @CrossOrigin
    @RequestMapping(value = "/service/register", method = RequestMethod.POST) //TODO add ikke sprerra
    public @ResponseBody int createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @CrossOrigin
    @GetMapping("/getusername/{username}")
    public User getUsername(@PathVariable String username){
        return userService.getUsername(username);
    }

    // Return user with given id
    @CrossOrigin
    @GetMapping("/{id}") //TODO username??
    public @ResponseBody Optional<User> getUser(@PathVariable int id) {
        return userService.getUser(id);
       // return userRepository.findById(id);
    }



    // Update user (id must be present in payload, or new user will be created)
    // Proposed solution for return values:
    // 0: username ALREADY EXIST
    // 1: phoneNumber ALREADY EXIST
    // 2: email ALREADY EXIST
    // 3: CREATED
    // 4: ERROR
    @CrossOrigin
    @PutMapping("/updateUser")
    public @ResponseBody int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


    // Delete user (id must be present in payload, or new user will be created)
    @CrossOrigin
    @DeleteMapping("/deleteUser")
    public @ResponseBody boolean deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }

    @CrossOrigin
    @PostMapping("/role")
    public String isAdmin(@RequestBody User user){
        return userService.isAdmin(user);
    }
}
