package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.LoginRequest;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping(value = "/token")
@EnableAutoConfiguration
@CrossOrigin
public class TokenController {

    // keyStr is hardcoded here for testing purpose
    // in a real scenario, it should either be stored in a database or injected from the environment
    public static final String keyStr = "testsecrettestsecrettestsecrettestsecrettestsecret";
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(5);


    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String generateToken(@RequestBody LoginRequest loginRequest) throws Exception { //var final@RequestParam("username") String username, @RequestParam("password") String password
        //System.out.println("halla");
        //System.out.println(loginRequest.getUsername() + loginRequest.getPassword());
        // if username and password are valid, issue an access token
        // note that subsequent requests need this token
        /*if (MockDao.checkUserCredentials(loginRequest.getUsername(), loginRequest.getPassword())) {
            return generateToken(loginRequest.getUsername());
        }*/
        /**return generateToken(loginRequest.getUsername());*/

         if (loginRequest.getUsername().equals("heii") && loginRequest.getPassword().equals("nei")) {
            System.out.println("wooop");
            return generateToken(loginRequest.getUsername());
        }

        System.out.println("hi");
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Access denied, wrong credentials....");


    }

    public String generateToken(String userId) {
        final Instant now = Instant.now();
        final Algorithm hmac512 = Algorithm.HMAC512(keyStr);;
        final JWTVerifier verifier = JWT.require(hmac512).build();
        return JWT.create()
                .withSubject(userId)
                .withIssuer("idatt2105_token_issuer_app")
                .withIssuedAt(now)
                .withExpiresAt(now.plusMillis(JWT_TOKEN_VALIDITY.toMillis()))
                .sign(hmac512);
    }
}