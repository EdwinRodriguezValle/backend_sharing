package sharing.com.enjoying.services;


import org.springframework.beans.factory.annotation.Autowired;
import sharing.com.enjoying.dtos.ServiceProviderDto;
import sharing.com.enjoying.exceptions.RecordNotFoundException;
import sharing.com.enjoying.models.ServiceProviderModel;
import sharing.com.enjoying.repositories.ServiceProviderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceProviderService {
    //connexion with database
    @Autowired
    private ServiceProviderRepository serviceProviderRepository;


        public List<ServiceProviderDto> getAllServicesPriveder() {
        List<ServiceProviderModel> serviceProviderModels = serviceProviderRepository.findAll();
        List<ServiceProviderDto> dtos = new ArrayList<>();
        for (ServiceProviderModel sm : serviceProviderModels) {
            dtos.add( transferToServiceProviderToDto(sm));
        }
        return dtos;
    }


        public ServiceProviderDto getServiceModel(long id) {
        Optional<ServiceProviderModel> spm = serviceProviderRepository.findById(id);
        if(spm.isPresent()) {
            ServiceProviderDto sp = transferToServiceProviderToDto(spm.get());
            return sp;
        } else {
            throw new RecordNotFoundException("Not ");
        }
    }

    public void deleteServiceProvider(Long id){
            serviceProviderRepository.deleteById(id);
    }

    public ServiceProviderDto addServiceProviderModel(ServiceProviderDto serviceProviderDto){
            serviceProviderRepository.save(transferToServiceProviderModel(serviceProviderDto));
            return serviceProviderDto;
    }

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

    //Transferring from controller to Dto
    public ServiceProviderDto transferToServiceProviderToDto(ServiceProviderModel serviceProviderModel) {
        var dto = new ServiceProviderDto();

        dto.id = serviceProviderModel.getId();
        dto.rentFamiliarHouse = serviceProviderModel.getRentFamiliarHouse();
        dto.rentRoomAtFamiliarHouse = serviceProviderModel.getRentRoomAtFamiliarHouse();
        dto.rentHostel = serviceProviderModel.getRentHostel();
        dto.rentHotel = serviceProviderModel.getRentHotel();
        dto.rentPrivateHouse = serviceProviderModel.getRentPrivateHouse();
        dto.rentFamiliarHouse = serviceProviderModel.getRentFamiliarHouse();
        dto.price = serviceProviderModel.getPrice();

        return dto;
    }

    // Transferring from Dto to service user model

    public ServiceProviderModel transferToServiceProviderModel(ServiceProviderDto serviceProviderDto) {
        var serviceProviderModel = new ServiceProviderModel();

        serviceProviderModel.setId(serviceProviderDto.id);
        serviceProviderModel.setRentFamiliarHouse(serviceProviderDto.rentFamiliarHouse);
        serviceProviderModel.setRentRoomAtFamiliarHouse(serviceProviderDto.rentRoomAtFamiliarHouse);
        serviceProviderModel.setRentHostel(serviceProviderDto.getRentHostel());
        serviceProviderModel.setRentHotel(serviceProviderDto.rentHotel);
        serviceProviderModel.setRentPrivateHouse(serviceProviderDto.getRentPrivateHouse());
        serviceProviderModel.setPrice(serviceProviderDto.getPrice());

        return serviceProviderModel;

    }
}
