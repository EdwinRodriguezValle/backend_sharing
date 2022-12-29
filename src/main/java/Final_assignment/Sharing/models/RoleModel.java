package Final_assignment.Sharing.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Collection;

@Entity
@Table(name="roles")
public class RoleModel {
    //Generated Id
    @Id
    private String rolename;

    //ManyToMany relation

    @ManyToMany(mappedBy = "roleModels")
    private Collection<UserModel> userModels;

    //Default constructor
    public RoleModel(){}

    //Constructor

    public RoleModel(String rolename, Collection<UserModel> userModels) {
        this.rolename = rolename;
        this.userModels = userModels;
    }


    //Getters

    public String getRolename() {
        return rolename;
    }

    public Collection<UserModel> getUserModels() {
        return userModels;
    }

    //Setters

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public void setUserModels(Collection<UserModel> userModels) {
        this.userModels = userModels;
    }
}
