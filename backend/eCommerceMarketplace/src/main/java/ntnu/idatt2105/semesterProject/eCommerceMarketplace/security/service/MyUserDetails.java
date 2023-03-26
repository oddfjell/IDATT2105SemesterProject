package ntnu.idatt2105.semesterProject.eCommerceMarketplace.security.service;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private User user;
    public MyUserDetails(User user){
        System.out.println(user.getRole());
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = user.getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (role == null){
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
