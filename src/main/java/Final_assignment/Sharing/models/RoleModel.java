//package Final_assignment.Sharing.models;
//
////import jakarta.persistence.Entity;
////import jakarta.persistence.Id;
////import jakarta.persistence.ManyToMany;
////import jakarta.persistence.Table;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import java.util.Collection;
//
//@Entity
//@Table(name ="roles")
//public class RoleModel {
//    @Id
//    private String rolename;
//
//    @ManyToMany(mappedBy = "roleModels")
//    private Collection<UserModel> userModels;
//
//    public String getRolename() {
//        return rolename;
//    }
//
//    public void setRolename(String rolename) {
//        this.rolename = rolename;
//    }
//
//    public Collection<UserModel> getUserModels() {
//        return userModels;
//    }
//
//    public void setUserModels(Collection<UserModel> userModels) {
//        this.userModels = userModels;
//    }
//}
