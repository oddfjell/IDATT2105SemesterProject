package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controller;

//import no.ntnu.idatt2105.tokenauth.demo.dao.MockDao;
//import no.ntnu.idatt2105.tokenauth.demo.model.UserInfoResponse;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import spring.calculator.task4.restfulbackendtask4.model.UserInfoResponse;

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
