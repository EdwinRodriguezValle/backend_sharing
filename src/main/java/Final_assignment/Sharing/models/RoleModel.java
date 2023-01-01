package Final_assignment.Sharing.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "roles")
public class RoleModel {

    @Id
    private String rolename;

    @ManyToMany(mappedBy = "roleModels")
    private Collection<UserModel> users;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Collection<UserModel> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserModel> users) {
        this.users = users;
    }
}
