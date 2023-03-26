package ntnu.idatt2105.semesterProject.eCommerceMarketplace.security;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.security.service.JWTAuthorizationFilter;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.security.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig{// extends WebSecurityConfiguration

    /*@Bean
    public UserDetailsService userDetailsService() {

        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        //authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService());

        return authenticationProvider;
    }*/



    //private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
    // inject SecurityFilterChain and tell that all requests are authenticated
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("sikkerhet" + http.toString());
        http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests()
                    .requestMatchers("/item/service/**").permitAll() //TODO de andre offentlige
                    .requestMatchers("/users/service/**").permitAll()
                    .requestMatchers("/test/**").permitAll()
                    .requestMatchers("/v3/**").permitAll() //TODO http://localhost:8080/v3/api-docs
                    .requestMatchers("/swagger-ui/**").permitAll() //TODO http://localhost:8080/swagger-ui/index.html#/user-info-controller/getUser
                    .requestMatchers("/swagger-ui.html/**").permitAll()
                    //.requestMatchers("/test").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                //.authenticationEntryPoint(authenticationEntryPoint)
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
                //.authenticationProvider(authenticationProvider());
        return http.build();
    }

}

