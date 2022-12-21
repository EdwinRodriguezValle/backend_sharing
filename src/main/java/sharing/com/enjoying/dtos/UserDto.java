package sharing.com.enjoying.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import sharing.com.enjoying.models.AuthorityModel;

import java.util.Set;

public class UserDto {

    public String username;
    public String password;
    public Boolean enabled;
    public String apikey;
    public String email;
    @JsonSerialize
    public Set<AuthorityModel> authorities;

//Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public String getEmail() {
        return email;
    }

    public Set<AuthorityModel> getAuthorities() {
        return authorities;
    }

    //Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthorities(Set<AuthorityModel> authorities) {
        this.authorities = authorities;
    }
}
