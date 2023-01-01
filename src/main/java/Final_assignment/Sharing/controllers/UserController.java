package Final_assignment.Sharing.controllers;

import Final_assignment.Sharing.Dtos.UserDto;
import Final_assignment.Sharing.models.RoleModel;
import Final_assignment.Sharing.models.UserModel;
import Final_assignment.Sharing.repositories.RoleRepository;
import Final_assignment.Sharing.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserController {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/users")
    public String createUser(@RequestBody UserDto userDto) {
        UserModel newUser = new UserModel();
        newUser.setUsername(userDto.username);
        newUser.setPassword(passwordEncoder.encode(userDto.password));

        List<RoleModel> userRoles = new ArrayList<>();
        for (String rolename : userDto.roleModel) {
            Optional<RoleModel> or = roleRepository.findById(rolename);

            userRoles.add((RoleModel) or.get());
        }
        newUser.setRoleModels(userRoles);

        userRepository.save(newUser);

        return "Done";
    }
}

