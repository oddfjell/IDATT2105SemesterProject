package ntnu.idatt2105.semesterProject.eCommerceMarketplace.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.ECommerceMarketplaceApplication;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.security.service.TokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@SpringBootTest(webEnvironment = MOCK, classes = ECommerceMarketplaceApplication.class)
@AutoConfigureMockMvc(addFilters = false)
public class TokenServiceTest {

    public void TokenService(){

    }



    private TokenService tokenService;

    @BeforeEach
    public void setup() {
        tokenService = new TokenService();
    }

    @Test
    public void testGenerateToken() {
        // Generate token for test user ID
        String userId = "testuser";
        String token = tokenService.generateToken(userId);

        Assertions.assertTrue(token.indexOf('.') == 2);

        // Verify token with expected values
       /* final Algorithm hmac512 = Algorithm.HMAC512(TokenService.keyStr);
        final JWTVerifier verifier = JWT.require(hmac512).build();
        Instant now = Instant.now();
        Instant expiration = now.plusMillis(100);
        String expectedIssuer = "idatt2105_token_issuer_app";
        Assertions.assertEquals(userId, verifier.verify(token).getSubject());
        Assertions.assertEquals(expectedIssuer, JWT.decode(token).getIssuer());
        Assertions.assertTrue(now.isBefore(JWT.decode(token).getIssuedAt().toInstant()));
        Assertions.assertEquals(expiration, (JWT.decode(token).getExpiresAt().toInstant()));*/
    }
}
