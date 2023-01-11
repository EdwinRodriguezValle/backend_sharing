package sharing.com.enjoying.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sharing.com.enjoying.dtos.UserProfileDto;
import sharing.com.enjoying.exceptions.RecordNotFoundException;
import sharing.com.enjoying.models.UserProfileModel;
import sharing.com.enjoying.repositories.ServiceUserRepository;
import sharing.com.enjoying.repositories.UserProfileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    //connexion with database
@Autowired
    private UserProfileRepository userProfileRepository;

    //CRUD
     public List<UserProfileDto> getAllUserProfiles(){
         List<UserProfileModel> userProfileServices = userProfileRepository.findAll();
         List<UserProfileDto> userProfileDtos = new ArrayList<>();
         for (UserProfileModel upm: userProfileServices) {
             userProfileDtos.add(transferToUserProfileDto(upm));
         }
         return userProfileDtos;
     }

    public UserProfileDto getUserProfile(long id) {
        Optional<UserProfileModel> userProfileModel = userProfileRepository.findById(id);
        if(userProfileModel.isPresent()) {
            UserProfileDto userProfileDto = transferToUserProfileDto(userProfileModel.get());
            return userProfileDto;
        } else {
            throw new RecordNotFoundException("User profile not found ");
        }
    }

    public UserProfileDto addUserProfile(UserProfileDto userProfileDto) {
        userProfileRepository.save(transferToUserProfileModel(userProfileDto));
        return userProfileDto;
    }

    public void deleteUserProfile(Long id) {
        userProfileRepository.deleteById(id);
    }

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

        userProfileRepository.save(storedUserProfile);
    }

    //Transferring from controller to Dto
    public UserProfileDto transferToUserProfileDto(UserProfileModel userProfileModel) {
        var dto = new UserProfileDto();

        dto.id = userProfileModel.getId();
        dto.name = userProfileModel.getName();
        dto.lastName = userProfileModel.getLastName();
        dto.language = userProfileModel.getLanguage();
        dto.gender = userProfileModel.getGender();
        dto.birthday = userProfileModel.getBirthday();
        dto.Address = userProfileModel.getAddress();
//        dto.email = userProfileModel.getEmail()

        return dto;
    }

    // Transferring from Dto to service user model

    public UserProfileModel transferToUserProfileModel(UserProfileDto userProfileDto) {
        var userProfileModel = new UserProfileModel();

        userProfileModel.setId(userProfileDto.id);
        userProfileModel.setName(userProfileDto.name);
        userProfileModel.setLastName(userProfileDto.lastName);
        userProfileModel.setGender(userProfileModel.getGender());
        userProfileModel.setBirthday(userProfileDto.birthday);
        userProfileModel.setAddress(userProfileModel.getAddress());
        userProfileModel.setEmail(userProfileModel.getEmail());

        return userProfileModel;
    }
}



