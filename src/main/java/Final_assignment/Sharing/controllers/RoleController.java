package Final_assignment.Sharing.controllers;

import Final_assignment.Sharing.Dtos.RoleDto;
import Final_assignment.Sharing.models.RoleModel;
import Final_assignment.Sharing.repositories.RoleRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostMapping("/roles")
    public String createRole(@RequestBody RoleDto role) {
        RoleModel newRole = new RoleModel();
        newRole.setRolename(role.rolename);
        roleRepository.save(newRole);

        return "Done";
    }
}
