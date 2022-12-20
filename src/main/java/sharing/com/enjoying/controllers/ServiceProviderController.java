package sharing.com.enjoying.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sharing.com.enjoying.dtos.ServiceProviderDto;
import sharing.com.enjoying.services.ServiceProviderService;

import java.util.List;

@RestController
public class ServiceProviderController {
    //Connexion with service class
    public final ServiceProviderService serviceProviderService;

    @Autowired
    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @GetMapping("/serviceProvider/")
    public List<ServiceProviderDto> getAllServiceProviderDto() {
        var dtos = serviceProviderService.getAllServicesPriveder();
        return dtos;
    }

    @GetMapping("/serviceProvider/{id}")
    public ServiceProviderDto getServiceProviderDto(@PathVariable("id") Long id) {
        ServiceProviderDto dto1 = serviceProviderService.getServiceModel(id);
        return dto1;
    }

    @PostMapping("/serviceProvider/{id}")
    public ServiceProviderDto addServiceProviderDto(@RequestBody ServiceProviderDto dto) {
        ServiceProviderDto dto1 = serviceProviderService.addServiceProviderModel(dto);
        return dto1;
    }

    @DeleteMapping("/serviceProvider/{id}")
    public void deleteServiceProviderDto(@PathVariable("id") Long id) {
        serviceProviderService.deleteServiceProvider(id);
    }

    @PutMapping("/updateServiceProvider/")
    public ServiceProviderDto updateServiceProviderDto(@PathVariable("id") Long id, ServiceProviderDto dto) {
        serviceProviderService.updateServiceProvider(id, dto);

        return dto;
    }
}

