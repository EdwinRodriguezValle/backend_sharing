package Final_assignment.Sharing.service;

import Final_assignment.Sharing.Dtos.ServiceProviderDto;
import Final_assignment.Sharing.exceptions.RecordNotFoundException;
import Final_assignment.Sharing.models.ServiceProviderModel;
import Final_assignment.Sharing.repositories.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderService {
    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    //Crud methods

    // Getting all the service provider from  repository and transferring to Dtos to be user in the end points
    public List<ServiceProviderDto> getAllServicesProvider() {
        List<ServiceProviderModel> serviceProviderModels = serviceProviderRepository.findAll();
        List<ServiceProviderDto> dtos = new ArrayList<>();
        for (ServiceProviderModel sm : serviceProviderModels) {
            dtos.add( transferFromServiceProviderModelToDto(sm));
        }
        return dtos;
    }

    //Get individual service provider to be transfer to the client if it exists in de database
    public ServiceProviderDto getServiceProviderModel(long id) {
        Optional<ServiceProviderModel> spm = serviceProviderRepository.findById(id);
        if(spm.isPresent()) {
            ServiceProviderDto sp = transferFromServiceProviderModelToDto(spm.get());
            return sp;
        } else {
            throw new RecordNotFoundException("Not ");
        }
    }

    // This method add new service provider to the database
    public void deleteServiceProvider(Long id){
        serviceProviderRepository.deleteById(id);
    }

    //This method delete by id a specific data from the database
    public ServiceProviderDto addServiceProviderModel(ServiceProviderDto serviceProviderDto){
        serviceProviderRepository.save(transferFromServiceProviderDtoToModel(serviceProviderDto));
        return serviceProviderDto;
    }

    //This method update the already existing data in the database
    public void updateServiceProvider(Long id, ServiceProviderDto serviceProviderDto){
        if(!serviceProviderRepository.existsById(id)){
            throw new RecordNotFoundException("No such as provider found.");
        }else{
            ServiceProviderModel storedServiceProvider = serviceProviderRepository.findById(id).orElse(null);
            storedServiceProvider.setId(serviceProviderDto.getId());
            storedServiceProvider.setRentFamiliarHouse(serviceProviderDto.getRentFamiliarHouse());
            storedServiceProvider.setRentRoomAtFamiliarHouse(serviceProviderDto.getRentRoomAtFamiliarHouse());
            storedServiceProvider.setRentHostel(serviceProviderDto.getRentHostel());
            storedServiceProvider.setRentPrivateHouse(serviceProviderDto.getRentPrivateHouse());
            storedServiceProvider.setPrice(serviceProviderDto.getPrice());

            serviceProviderRepository.save(storedServiceProvider);
        }
    }

     //    Transferring from service provider  model  to Dto
    public ServiceProviderDto transferFromServiceProviderModelToDto(ServiceProviderModel serviceProviderModel) {

        var dto = new ServiceProviderDto();

        dto.id = serviceProviderModel.getId();
        dto.rentFamiliarHouse = serviceProviderModel.getRentFamiliarHouse();
        dto.rentRoomAtFamiliarHouse = serviceProviderModel.getRentRoomAtFamiliarHouse();
        dto.rentHostel = serviceProviderModel.getRentHostel();
        dto.rentHotel = serviceProviderModel.getRentHotel();
        dto.rentPrivateHouse = serviceProviderModel.getRentPrivateHouse();
        dto.price = serviceProviderModel.getPrice();

        return dto;

    }

    // Transferring from service provider Dto to  role model
    public ServiceProviderModel transferFromServiceProviderDtoToModel(ServiceProviderDto serviceProviderDto) {

        var serviceProviderModel = new ServiceProviderModel();

        serviceProviderModel.setRentFamiliarHouse(serviceProviderDto.getRentFamiliarHouse());
        serviceProviderModel.setRentRoomAtFamiliarHouse(serviceProviderDto.getRentRoomAtFamiliarHouse());
        serviceProviderModel.setRentHostel(serviceProviderDto.getRentHostel());
        serviceProviderModel.setRentHotel(serviceProviderDto.getRentHotel());
        serviceProviderModel.setRentPrivateHouse(serviceProviderDto.getRentPrivateHouse());
        serviceProviderModel.setPrice(serviceProviderDto.getPrice());

        return serviceProviderModel;

    }
}




