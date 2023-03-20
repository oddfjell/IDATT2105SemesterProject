package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controller;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.accessingdatamysql.User;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.accessingdatamysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MainController {
    // This means to get the bean called userRepository, which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/register") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String username, @RequestParam String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return "Registered";
    }

    // Returns all users
    @GetMapping(path="/user/{id}")
    public @ResponseBody Optional<User> getUser(@PathVariable int id) {
        return userRepository.findById(id);
    }

    // Returns user with given id
    // If no user exist with given id, it returns null
    @GetMapping(path="/user")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}