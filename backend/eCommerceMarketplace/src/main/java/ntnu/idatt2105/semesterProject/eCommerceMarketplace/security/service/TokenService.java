package ntnu.idatt2105.semesterProject.eCommerceMarketplace.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.Instant;

/**
 * Service who makes jwt-tokens to valid users
 */
@Service
public class TokenService {

    /**
     * Very secret key
     */
    public static final String keyStr = "testsecrettestsecrettestsecrettestsecrettestsecret";

    /**
     * The token is valid for 30 minutes
     */
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(30);

    /**
     * Generates a jwt-token with the userID (username) and a timestamp
     * @param userId String
     * @return String
     */
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
