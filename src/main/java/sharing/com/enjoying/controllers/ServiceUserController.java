package sharing.com.enjoying.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sharing.com.enjoying.dtos.ServiceUserDto;
import sharing.com.enjoying.services.ServiceUserService;

import java.util.List;

@RestController
public class ServiceUserController {
    private final ServiceUserService serviceUserService;

    @Autowired
    public ServiceUserController(ServiceUserService serviceUserService) {
        this.serviceUserService = serviceUserService;
    }

    @GetMapping("/serviceUse/")
    public List<ServiceUserDto> getAllServiceUserDto(){
        var dtos = serviceUserService.getAllServiceUserDto();
        return dtos;
    }

    @GetMapping ("/serviceUser/{id}")
    public ServiceUserDto getServiceUserDto(@PathVariable("id") Long id){
        ServiceUserDto dto1 = serviceUserService.getServiceUser(id);
        return dto1;
    }

    @PostMapping("/servicesUser")
    public ServiceUserDto AddServiceUserDto(@RequestBody ServiceUserDto dto){
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


