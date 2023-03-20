package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /*
    @Autowired
    Database repo
    */

    @GetMapping("/test")
    public String test(){
        return "fungerer";
    }
}
