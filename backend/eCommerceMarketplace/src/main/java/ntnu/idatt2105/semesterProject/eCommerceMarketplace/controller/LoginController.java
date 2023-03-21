package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controller;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /*
    @Autowired
    Database repo
    */

    @PostMapping("/login")
    public String loginRequest(@RequestBody User user){//@RequestBody LoginRequest loginRequest
        //TODO databaseskjekk
        logger.info("The user: {} logged in", user.getUsername());
        return user.getUsername();
    }
}
