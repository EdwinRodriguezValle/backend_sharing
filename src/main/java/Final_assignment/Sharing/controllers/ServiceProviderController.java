package Final_assignment.Sharing.controllers;

import Final_assignment.Sharing.Dtos.ServiceProviderDto;
import Final_assignment.Sharing.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;

    @Autowired

    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @GetMapping("/getAllServiceProvider")
    public List<ServiceProviderDto> getAllServiceProvider() {
        var dtos = serviceProviderService.getAllServicesProvider();
        return dtos;
    }

    @GetMapping("/serviceProvideByIdr/{id}")
    public ServiceProviderDto getServiceProviderById(@PathVariable("id") Long id) {
        ServiceProviderDto dto1 = serviceProviderService.getServiceProviderModel(id);
        return dto1;
    }

    @PostMapping("/addServiceProvider/{id}")
    public ServiceProviderDto addServiceProvider(@RequestBody ServiceProviderDto dto) {
        ServiceProviderDto dto1 = serviceProviderService.addServiceProviderModel(dto);
        return dto1;
    }

    @DeleteMapping("/deleteServiceProvider/{id}")
    public void deleteServiceProvider(@PathVariable("id") Long id) {
        serviceProviderService.deleteServiceProvider(id);
    }

    @PutMapping("/updateServiceProvider/")
    public ServiceProviderDto updateServiceProvider(@PathVariable("id") Long id, ServiceProviderDto dto) {
        serviceProviderService.updateServiceProvider(id, dto);

        return dto;
    }

}
