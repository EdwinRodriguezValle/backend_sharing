package sharing.com.enjoying.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sharing.com.enjoying.dtos.ServiceUserDto;
import sharing.com.enjoying.exceptions.RecordNotFoundException;
import sharing.com.enjoying.models.ServiceUserModel;
import sharing.com.enjoying.repositories.ServiceUserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserService {


    //Connexion with the  repository

@Autowired
private ServiceUserRepository serviceUserRepository;

    public  List<ServiceUserDto> getAllServiceUserDto(){
        List<ServiceUserModel> serviceUserModels = serviceUserRepository.findAll();
        List<ServiceUserDto> dtos = new ArrayList<>();
        for(ServiceUserModel sum :serviceUserModels ){
            dtos.add(transferServiceUserToDto(sum));
        }
        return dtos;
    }

    public ServiceUserDto getServiceUser(long id){
        Optional<ServiceUserModel> serviceUserModel = serviceUserRepository.findById(id);
        if(serviceUserModel.isPresent()){
            ServiceUserDto serviceUserDto = transferServiceUserToDto(serviceUserModel.get());
            return serviceUserDto;
        } else{
            throw new RecordNotFoundException("No found Service user ");
        }
    }

    public ServiceUserDto addServiceUserModel(ServiceUserDto serviceUserDto){
        serviceUserRepository.save(transferToServiceUserModel(serviceUserDto));
        return serviceUserDto;
    }

    public void deleteServiceUSer(Long id){
        serviceUserRepository.deleteById(id);
    }

    public void updateServiceUser(Long id, ServiceUserDto serviceUserDto){
        if(!serviceUserRepository.existsById(id)){
            throw new RecordNotFoundException("No service user found.");
        }else{
            ServiceUserModel storedServiceUser = serviceUserRepository.findById(id).orElse(null);
            storedServiceUser.setId(serviceUserDto.getId());
            storedServiceUser.setTyperOfService(serviceUserDto.getTyperOfService());
            storedServiceUser.setParticularInterest(serviceUserDto.getParticularInterest());
            storedServiceUser.setPlaceToTravel(serviceUserDto.getPlaceToTravel());
            storedServiceUser.setPeriod(serviceUserDto.getPeriod());

            serviceUserRepository.save(storedServiceUser);
        }
    }

    //Transferring from controller to Dto

    public ServiceUserDto transferServiceUserToDto (ServiceUserModel serviceUserModel){
        var dto = new ServiceUserDto();

        dto.id = serviceUserModel.getId();
        dto.typerOfService = serviceUserModel.getTyperOfService();
        dto.particularInterest = serviceUserModel.getParticularInterest();
        dto.placeToTravel = serviceUserModel.getPlaceToTravel();
        dto.period = serviceUserModel.getPeriod();

        return dto;
    }

    // Transferring from Dto to service user model

    public ServiceUserModel transferToServiceUserModel(ServiceUserDto serviceUserDto){
        var serviceUserModel = new ServiceUserModel();

        serviceUserModel.setId(serviceUserDto.getId());
        serviceUserModel.setTyperOfService(serviceUserDto.getTyperOfService());
        serviceUserModel.setParticularInterest(serviceUserDto.getParticularInterest());
        serviceUserModel.setPlaceToTravel(serviceUserDto.getPlaceToTravel());
        serviceUserModel.setPeriod(serviceUserDto.getPeriod());

           return serviceUserModel;
    }

}
