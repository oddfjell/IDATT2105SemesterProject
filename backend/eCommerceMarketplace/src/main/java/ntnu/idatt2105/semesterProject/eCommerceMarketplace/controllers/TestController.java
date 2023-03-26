package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/test")
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class TestController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/{username}")
    public String isAdmin(@PathVariable String username){

        String role = userRepository.findByUsername(username).getRole();

        return role;

        //MyUserDetails springUserDetails = new MyUserDetails(userRepository.findByUsername(username));
        //String role = String.valueOf(springUserDetails.getAuthorities().iterator().next());

        /*if(Objects.equals(role, "ROLE_ADMIN")){
            return "ROLE_ADMIN";
        }
        else return "ROLE_USER";

        return "222" + username;*/
    }
}

/*else if(Objects.equals(role, null)){
        return true;

        System.out.println("-------------");
        System.out.println(role);
        System.out.println("-------------");
        }*/

//userRepository.findByUsername(username).setRole("ROLE_ADMIN");