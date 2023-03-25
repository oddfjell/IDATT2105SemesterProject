package ntnu.idatt2105.semesterProject.eCommerceMarketplace.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Duration;
import java.time.Instant;

public class TokenService {


    public static final String keyStr = "testsecrettestsecrettestsecrettestsecrettestsecret";
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(5);


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
