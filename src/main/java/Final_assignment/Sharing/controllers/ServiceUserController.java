package Final_assignment.Sharing.controllers;

import Final_assignment.Sharing.Dtos.ServiceUserDto;
import Final_assignment.Sharing.service.ServiceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceUserController {
    //Connexion with service
    private final ServiceUserService serviceUserService;

    @Autowired

    public ServiceUserController(ServiceUserService serviceUserService) {
        this.serviceUserService = serviceUserService;
    }


    @GetMapping("/GetAllServiceUse")
    public List<ServiceUserDto> getAllServiceUser(){
        var dtos = serviceUserService.getAllServiceUser();
        return dtos;
    }

    @GetMapping ("/getServiceUser/{id}")
    public ServiceUserDto getServiceUse(@PathVariable("id") Long id){
        ServiceUserDto dto1 = serviceUserService.getServiceUserById(id);
        return dto1;
    }

    @PostMapping("/addServicesUser")
    public ServiceUserDto AddServiceUser(@RequestBody ServiceUserDto dto){
        ServiceUserDto dto1 = serviceUserService.addServiceUserModel(dto);
        return dto1;
    }

    @DeleteMapping("/deleteServiceUser/{id}")
    public void deleteServiceUser(@PathVariable("id") Long id){
        serviceUserService.deleteServiceUSer(id);
    }

    @PutMapping("/updateServiceUser")
    public ServiceUserDto updateServiceUserDto (@PathVariable("id") Long id,  ServiceUserDto dto){
        serviceUserService.updateServiceUser(id, dto );
        return dto;
    }
}
