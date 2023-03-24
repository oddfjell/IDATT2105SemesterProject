package ntnu.idatt2105.semesterProject.eCommerceMarketplace.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // inject SecurityFilterChain and tell that all requests are authenticated
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("sikkerhet" + http.toString());
        http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests()
                .requestMatchers("/token").permitAll() //TODO de andre offentlige
                .requestMatchers("/user").permitAll()
                .requestMatchers("/getitems").permitAll()
                .requestMatchers("/v3/**").permitAll() //TODO http://localhost:8080/v3/api-docs
                .requestMatchers("/swagger-ui/**").permitAll() //TODO http://localhost:8080/swagger-ui/index.html#/user-info-controller/getUser
                .requestMatchers("/swagger-ui.html/**").permitAll()
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}

