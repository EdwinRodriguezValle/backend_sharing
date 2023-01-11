package sharing.com.enjoying.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(AuthorityKeyModel.class)
@Table(name = "authorities")
public class AuthorityModel implements Serializable{

    @Id
    @Column(nullable = false)
    private String username;

    @Id
    @Column(nullable = false)
    private String Authority;

    //Default constructor
    public AuthorityModel (){}

    //Constructor
    public AuthorityModel(String username, String authority) {
        this.username = username;
        Authority = authority;
    }

    //Getters and setters


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }
}