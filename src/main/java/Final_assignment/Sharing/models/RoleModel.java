package Final_assignment.Sharing.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class RoleModel {
    //Auto generated id
    @Id
    @GeneratedValue
    private String rolename;

    //OneToMany relation with UserProfile
    @OneToMany(mappedBy = "roleModel")
    @JsonIgnore
    List<UserProfileModel> userProfileModels;

    //Default constructor
    public RoleModel(){}

    //Constructors
    public RoleModel(String rolename, List<UserProfileModel> userProfileModels) {
        this.rolename = rolename;
        this.userProfileModels = userProfileModels;
    }

    //Getters
    public String getRolename() {
        return rolename;
    }

    public List<UserProfileModel> getUserProfileModels() {
        return userProfileModels;
    }

    //Setters
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public void setUserProfileModels(List<UserProfileModel> userProfileModels) {
        this.userProfileModels = userProfileModels;
    }
}
