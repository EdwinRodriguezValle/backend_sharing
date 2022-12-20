package sharing.com.enjoying.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sharing.com.enjoying.dtos.UserProfileDto;
import sharing.com.enjoying.services.UserProfileService;

import java.util.List;

@RestController
public class UserProfileController {
    //connexion with service

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    //End points
    @PutMapping("/userProfile/")
    public List<UserProfileDto> getAllUserProfileDto(){
        var x = userProfileService.getAllUserProfiles();
        return x;
    }

    @PutMapping("/userProfile/{id}")
    public UserProfileDto getUserProfileDto(@PathVariable("id") Long id){
        UserProfileDto dto = userProfileService.getUserProfile(id);
        return dto;
    }

    @PostMapping("/addUserPofile/")
    public UserProfileDto AddUserProfileDto(@RequestBody UserProfileDto dto){
        UserProfileDto dto1 = userProfileService.addUserProfile(dto);
        return dto1;
    }

    @DeleteMapping("/userProfile/{id}")
    public void deleteUserProfile(@PathVariable("id") Long id){
        userProfileService.deleteUserProfile(id);
    }

    @PutMapping("/userProfile/{id}")
    public UserProfileDto updateUserProfileDto(@PathVariable("id") Long id, UserProfileDto dto){
        userProfileService.updateUserProfile(id, dto);
        return dto;
    }
}
