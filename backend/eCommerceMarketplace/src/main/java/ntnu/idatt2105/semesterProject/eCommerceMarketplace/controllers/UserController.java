package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Address;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.LoginResponse;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * Rest controller for all /users endpoints
 */
@RestController
@RequestMapping(value = "/users")
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true")
public class UserController { //TODO login

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    /**
     * UserService field injection
     */
    @Autowired
    private UserService userService;

    /**
     * / will send the getAllUsers request to userservice. Then it will return either an
     * Iterable<Item> with all the users and a 200 http status or a 404 http status
     * @return ResponseEntity<>
     */
    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        LOGGER.info("eloooooooooooooooooooo");//TODO
        //return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        Iterable<User> users = userService.getAllUsers();
        if(users == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * service/login is a "public endpoint"
     * service/login will send the loginUser request to userservice. Then it will return either an
     * LoginResponse with a jwt-token, userid, role and a 201 http status or a 404 http status
     * @param payload Map<String, Object>
     * @return ResponseEntity<>
     */
    @CrossOrigin
    @PostMapping("/service/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody Map<String, Object> payload) {//var string
        LoginResponse loginResponse = userService.loginUser(payload);
        if(loginResponse==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(loginResponse, HttpStatus.CREATED);
    }

    /**
     * service/register is a "public endpoint"
     * service/register will send the createUser request to userservice. Then it will return an
     * Integer and a http status:
     * * 0: username ALREADY EXIST
     * * * * * 409
     * * 1: phoneNumber ALREADY EXIST
     * * * * * 409
     * * 2: email ALREADY EXIST
     * * * * * 409
     * * 3: CREATED
     * * * * * 201
     * * 4: ERROR
     * * * * * 400
     * @param user User
     * @return ResponseEntity<>
     */
    @CrossOrigin
    @RequestMapping(value = "/service/register", method = RequestMethod.POST)
    public ResponseEntity<Integer> createUser(@RequestBody User user) {
        int createResponse = userService.createUser(user);
        if(createResponse == 4){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else if(createResponse == 3){
            return new ResponseEntity<>(createResponse, HttpStatus.CREATED);
        } else return new ResponseEntity<>(createResponse, HttpStatus.CONFLICT);
    }

    // return user with given username

    /**
     * /getusername/{username} will send the getUsername request to userservice and get user with given
     * username. Then it will return either an User and a 200 http status or a 404 http status
     * @param username String
     * @return ResponseEntity<>
     */
    @CrossOrigin
    @GetMapping("/getusername/{username}")
    public ResponseEntity<User> getUsername(@PathVariable String username){
        User user = userService.getUserByUsername(username);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Return user with given id

    /**
     * /service/{id} is a "public endpoint"
     * /service/{id} will send the getUser request to userservice and get user with given id.
     * Then it will return either an User and a 200 http status or a 404 http status
     * @param id int
     * @return ResponseEntity<>
     */
    @CrossOrigin
    @GetMapping("/service/{id}") //TODO username??
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = userService.getUserById(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * /updateUser will send the updateUser request to userservice. Then it will return an
     * Integer and a http status:
     * * 0: username ALREADY EXIST
     * * * * * 409
     * * 1: phoneNumber ALREADY EXIST
     * * * * * 409
     * * 2: email ALREADY EXIST
     * * * * * 409
     * * 3: CREATED
     * * * * * 201
     * * 4: ERROR
     * * * * * 400
     * @param user
     * @return
     */
    @CrossOrigin
    @PutMapping("/updateUser")
    public ResponseEntity<Integer> updateUser(@RequestBody User user) {
        int updateResponse = userService.updateUser(user);
        if(updateResponse == 4){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else if(updateResponse == 3){
            return new ResponseEntity<>(updateResponse, HttpStatus.OK);
        } else return new ResponseEntity<>(updateResponse, HttpStatus.CONFLICT);
    }

    /**
     * /deleteUser will send the deletion request to userservice. Then it will return a ResponseEntity<Boolean>
     * which tells weather the deletion was successful or not with a boolean and a http status, 201 or 400
     * @param user User
     * @return ResponseEntity<Boolean>
     */
    @CrossOrigin
    @DeleteMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteUser(@RequestBody User user) {
        boolean deleted = userService.deleteUser(user);
        System.out.println(userService.deleteUser(user));
        System.out.println(deleted);
        if(deleted){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }else return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    /**
     * /role will send the isAdmin request to userservice and get role for given user.
     * Then it will return either a role and a 200 http status or a 400 http status
     * @param user User
     * @return ResponseEntity<String>
     */
    @CrossOrigin
    @PostMapping("/role")
    public ResponseEntity<String> isAdmin(@RequestBody User user){
        String role = userService.isAdmin(user);
        if(role != null){
            return new ResponseEntity<>(role, HttpStatus.OK);
        } return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //TODO

    /**
     * /service/getAddress/{id} is a "public endpoint"
     * /service/getAddress/{id} will send the getAdress request to userservice and get the address for given user.
     * Then it will return either an Address and a 200 http status or a 404 http status
     * @param id int
     * @return ResponseEntity<Address>
     */
    @GetMapping("/service/getAddress/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable int id){
        Address address = userService.getAddress(id);
        if(address == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
