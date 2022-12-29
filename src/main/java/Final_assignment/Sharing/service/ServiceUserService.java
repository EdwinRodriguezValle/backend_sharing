package Final_assignment.Sharing.service;

import Final_assignment.Sharing.Dtos.ServiceUserDto;
import Final_assignment.Sharing.exceptions.RecordNotFoundException;
import Final_assignment.Sharing.models.ServiceUserModel;
import Final_assignment.Sharing.repositories.ServiceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserService {
    @Autowired
    private ServiceUserRepository serviceUserRepository;

    //Crud methods
    // Getting all the service user from  repository and transferring to Dtos to be user in the end points
    public List<ServiceUserDto> getAllServiceUser(){
        List<ServiceUserModel> serviceUserModels = serviceUserRepository.findAll();
        List<ServiceUserDto> dtos = new ArrayList<>();
        for(ServiceUserModel sum :serviceUserModels ){
            dtos.add(transferFromServiceUserModelToDto(sum));
        }
        return dtos;
    }

    //Get individual service user to be transfer to the client if it exists in de database
    public ServiceUserDto getServiceUserById(long id){
        Optional<ServiceUserModel> serviceUserModel = serviceUserRepository.findById(id);
        if(serviceUserModel.isPresent()){
            ServiceUserDto serviceUserDto = transferFromServiceUserModelToDto(serviceUserModel.get());
            return serviceUserDto;
        } else{
            throw new RecordNotFoundException("No found Service user ");
        }
    }

    // This method add new service user to the database
    public ServiceUserDto addServiceUserModel(ServiceUserDto serviceUserDto){
        serviceUserRepository.save(transferFromServiceUserDtoToModel(serviceUserDto));
        return serviceUserDto;
    }

    //This method delete by id a specific data from the database
    public void deleteServiceUSer(Long id){
        serviceUserRepository.deleteById(id);
    }

    //This method update the already existing data in the database
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

    //    Transferring from service user  model  to Dto
    public ServiceUserDto transferFromServiceUserModelToDto(ServiceUserModel serviceUserModel) {

        var dto = new ServiceUserDto();

        dto.id = serviceUserModel.getId();
        dto.typerOfService = serviceUserModel.getTyperOfService();
        dto.particularInterest = serviceUserModel.getParticularInterest();
        dto.placeToTravel = serviceUserModel.getPlaceToTravel();
        dto.period = serviceUserModel.getPeriod();

        return dto;

    }

    // Transferring from service user Dto to  role model
    public ServiceUserModel transferFromServiceUserDtoToModel(ServiceUserDto serviceUserDto) {

        var serviceUserModel = new ServiceUserModel();
        serviceUserModel.setTyperOfService(serviceUserDto.getTyperOfService());
        serviceUserModel.setParticularInterest(serviceUserDto.getParticularInterest());
        serviceUserModel.setPlaceToTravel(serviceUserDto.getPlaceToTravel());
        serviceUserModel.setPeriod(serviceUserDto.getPeriod());

        return serviceUserModel;
    }

}


