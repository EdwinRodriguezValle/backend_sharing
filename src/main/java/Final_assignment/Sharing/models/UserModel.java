//package Final_assignment.Sharing.models;
//
////import jakarta.persistence.*;
////
//
//import javax.persistence.*;
//import java.util.Collection;
//
//@Entity
//@Table(name="users")
//public class UserModel {
//
//
//        @Id
//        private String username;
//
//        private String password;
//
//        @ManyToMany(fetch = FetchType.EAGER)
//        private Collection<RoleModel> roleModels;
//
//        public String getUsername() {
//                return username;
//        }
//
//        public void setUsername(String username) {
//                this.username = username;
//        }
//
//        public String getPassword() {
//                return password;
//        }
//
//        public void setPassword(String password) {
//                this.password = password;
//        }
//
//        public Collection<RoleModel> getRoleModels() {
//                return roleModels;
//        }
//
//        public void setRoleModels(Collection<RoleModel> roleModels) {
//                this.roleModels = roleModels;
//        }
//}
