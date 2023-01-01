//package Final_assignment.Sharing.controllers;
//
//import Final_assignment.Sharing.Dtos.UserDto;
//import Final_assignment.Sharing.models.RoleModel;
//import Final_assignment.Sharing.models.UserModel;
//import Final_assignment.Sharing.repositories.RoleRepository;
//import Final_assignment.Sharing.repositories.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class UserController {
//
//
//    private final UserRepository userRepos;
//    private final RoleRepository roleRepos;
//    private final PasswordEncoder encoder;
//
//    public UserController(UserRepository userRepos, RoleRepository roleRepos, PasswordEncoder encoder) {
//        this.userRepos = userRepos;
//        this.roleRepos = roleRepos;
//        this.encoder = encoder;
//    }
//
//    @PostMapping("/users")
//    public String createUser(@RequestBody UserDto userDto) {
//        UserModel newUser = new UserModel();
//        newUser.setUsername(userDto.username);
//        newUser.setPassword(encoder.encode(userDto.password));
//
//        List<RoleModel> userRoles = new ArrayList<>();
//        for (String rolename : userDto.roleModel) {
//            Optional<RoleRepository> or = roleRepos.findById(rolename);
//
//            userRoles.add((RoleModel) or.get());
//        }
//        newUser.setRoleModels(userRoles);
//
//        userRepos.save(newUser);
//
//        return "Done";
//    }
//}

