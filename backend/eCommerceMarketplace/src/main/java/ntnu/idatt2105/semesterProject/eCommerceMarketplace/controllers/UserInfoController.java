package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.UserInfoResponse;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@EnableAutoConfiguration
@CrossOrigin
public class UserInfoController {



    @GetMapping("/{userId}")
    public UserInfoResponse getUser(@PathVariable("userId") String userId){
        System.out.println("yey");
        return new UserInfoResponse(userId, "nei");
        //return new MockDao().getUser(userId);
    }

}
