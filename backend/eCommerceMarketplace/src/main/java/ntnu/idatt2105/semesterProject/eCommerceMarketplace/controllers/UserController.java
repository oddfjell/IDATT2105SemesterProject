package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.LoginResponse;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/service/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody Map<String, Object> payload) {//var string
        LoginResponse loginResponse = userService.loginUser(payload);
        if(loginResponse==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(loginResponse, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "/service/register", method = RequestMethod.POST) //TODO add ikke sprerra
    public ResponseEntity<Integer> createUser(@RequestBody User user) {
        int createResponse = userService.createUser(user);
        if(createResponse == 4){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else if(createResponse == 3){
            return new ResponseEntity<>(createResponse, HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    // return user with given username
    @CrossOrigin
    @GetMapping("/getusername/{username}")
    public ResponseEntity<User> getUsername(@PathVariable String username){
        User user = userService.getUserByUsername(username);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Return user with given id
    @CrossOrigin
    @GetMapping("/{id}") //TODO username??
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = userService.getUserById(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(user, HttpStatus.OK);
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
    public ResponseEntity<Integer> updateUser(@RequestBody User user) {
        int updateResponse = userService.updateUser(user);
        if(updateResponse == 4){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else if(updateResponse == 3){
            return new ResponseEntity<>(updateResponse, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    // Delete user (id must be present in payload, or new user will be created)
    @CrossOrigin
    @DeleteMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteUser(@RequestBody User user) {
        if(userService.deleteUser(user)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }else return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @PostMapping("/role")
    public ResponseEntity<String> isAdmin(@RequestBody User user){
        String role = userService.isAdmin(user);
        if(role != null){
            return new ResponseEntity<>(role, HttpStatus.OK);
        } return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
