package sharing.com.enjoying.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import sharing.com.enjoying.dtos.UserDto;
import sharing.com.enjoying.models.AuthorityKeyModel;
import sharing.com.enjoying.models.AuthorityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDto userDto = userService.getUser(username);
        String password = userDto.getPassword();

        Set<AuthorityModel> authorityModels = userDto.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (AuthorityModel authorityModel : authorityModels) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authorityModel.getAuthority()));
        }
        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }
}
