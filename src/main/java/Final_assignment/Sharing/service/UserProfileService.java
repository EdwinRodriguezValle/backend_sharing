package Final_assignment.Sharing.service;

import Final_assignment.Sharing.Dtos.UserProfileDto;
import Final_assignment.Sharing.exceptions.RecordNotFoundException;
import Final_assignment.Sharing.models.UserProfileModel;
import Final_assignment.Sharing.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    //Crud methods

    // Getting all the user profile from  repository and transferring to Dtos to be user in the end points
    public List<UserProfileDto> getAllUserProfiles(){
        List<UserProfileModel> userProfileServices = userProfileRepository.findAll();
        List<UserProfileDto> userProfileDtos = new ArrayList<>();
        for (UserProfileModel upm: userProfileServices) {
            userProfileDtos.add(transferFromUserProfileModelToDto(upm));
        }
        return userProfileDtos;
    }

    //Get individual user profile to be transfer to the client if it exists in de database
    public UserProfileDto getUserProfile(long id) {
        Optional<UserProfileModel> userProfileModel = userProfileRepository.findById(id);
        if(userProfileModel.isPresent()) {
            UserProfileDto userProfileDto = transferFromUserProfileModelToDto(userProfileModel.get());
            return userProfileDto;
        } else {
            throw new RecordNotFoundException("User profile not found ");
        }
    }

    // This method add new user profile to the database
    public UserProfileDto addUserProfile(UserProfileDto userProfileDto) {
        userProfileRepository.save(transferFromServiceProviderDtoToModel(userProfileDto));
        return userProfileDto;
    }

    //This method delete by id a specific data from the database
    public void deleteUserProfile(Long id) {
        userProfileRepository.deleteById(id);
    }

    //This method update the already existing data in the database
    public void updateUserProfile(Long id, UserProfileDto userProfileDto) {
        if (!userProfileRepository.existsById(id)) {
            throw new RecordNotFoundException("No user profile found.");
        }
        UserProfileModel storedUserProfile = userProfileRepository.findById(id).orElse(null);
        storedUserProfile.setId(userProfileDto.getId());
        storedUserProfile.setName(userProfileDto.getName());
        storedUserProfile.setLastName(userProfileDto.getLastName());
        storedUserProfile.setLanguage(userProfileDto.getLanguage());
        storedUserProfile.setBirthday(userProfileDto.getBirthday());
        storedUserProfile.setGender(userProfileDto.getGender());
        storedUserProfile.setEmail(userProfileDto.getEmail());
        storedUserProfile.setAddress(userProfileDto.getAddress());
        storedUserProfile.setTelephone(userProfileDto.getTelephone());

        userProfileRepository.save(storedUserProfile);
    }

    //Transferring from controller to Dto
    public UserProfileDto transferFromUserProfileModelToDto(UserProfileModel userProfileModel) {

        var dto = new UserProfileDto();
        dto.id = userProfileModel.getId();
        dto.name = userProfileModel.getName();
        dto.lastName = userProfileModel.getLastName();
        dto.language = userProfileModel.getLanguage();
        dto.gender = userProfileModel.getGender();
        dto.birthday = userProfileModel.getBirthday();
        dto.address = userProfileModel.getAddress();
        dto.email = userProfileModel.getEmail();
        dto.telephone = userProfileModel.getTelephone();

        return dto;
    }


 // Transferring from Dto to service provider model
    public UserProfileModel transferFromServiceProviderDtoToModel(UserProfileDto userProfileDto){
        var userProfileModel = new UserProfileModel();

        userProfileModel.setId(userProfileDto.getId());
        userProfileModel.setName(userProfileDto.getName());
        userProfileModel.setLanguage((userProfileDto.getLanguage()));
        userProfileModel.setGender(userProfileDto.getLanguage());
        userProfileModel.setGender(userProfileDto.getGender());
        userProfileModel.setBirthday(userProfileDto.getBirthday());
        userProfileModel.setAddress(userProfileDto.getAddress());
        userProfileModel.setEmail(userProfileDto.getEmail());
        userProfileModel.setEmail(userProfileDto.getEmail());
        userProfileModel.setTelephone(userProfileDto.getTelephone());

        return userProfileModel;
    }


}
