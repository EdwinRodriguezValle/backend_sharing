package Final_assignment.Sharing.service;

import Final_assignment.Sharing.Dtos.RoleDto;
import Final_assignment.Sharing.models.RoleModel;
import Final_assignment.Sharing.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    //Crud methods

    // Getting all the booking from  repository and transferring to Dtos to be user in the end points

    //Get individual booking to be transfer to the client if it exists in de database

    // This method add new booking to the database

    //This method delete by id a specific data from the database

    //This method update the already existing data in the database


    //    Transferring from rating  model  to Dto
    public RoleDto transferFromRoleModelToDto(RoleModel roleModel) {

        var dto = new RoleDto();
        dto.rolename = roleModel.getRolename();
        return dto;

    }

    // Transferring from role Dto to  role model
    public RoleModel transferFromRoleDtoToModel(RoleDto roleDto) {

        var roleModel = new RoleModel();
        roleModel.setRolename(roleDto.getRolename());
        return roleModel;

    }
}
