package Final_assignment.Sharing.controllers;

import Final_assignment.Sharing.Dtos.UserProfileDto;
import Final_assignment.Sharing.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userProfielController {

    private final UserProfileService userProfileService;

    @Autowired

    public userProfielController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    //End points
    @PutMapping("/getAllUserProfile")
    public List<UserProfileDto> getAllUserProfile(){
        var x = userProfileService.getAllUserProfiles();
        return x;
    }

    @PutMapping("/userProfileById/{id}")
    public UserProfileDto getUserProfileDto(@PathVariable("id") Long id){
        UserProfileDto dto = userProfileService.getUserProfile(id);
        return dto;
    }

    @PostMapping("/addUserPofile")
    public UserProfileDto AddUserProfileDto(@RequestBody UserProfileDto dto){
        UserProfileDto dto1 = userProfileService.addUserProfile(dto);
        return dto1;
    }

    @DeleteMapping("/deleteUserProfile/{id}")
    public void deleteUserProfile(@PathVariable("id") Long id){
        userProfileService.deleteUserProfile(id);
    }

    @PutMapping("/updateUserProfile/{id}")
    public UserProfileDto updateUserProfileDto(@PathVariable("id") Long id, UserProfileDto dto){
        userProfileService.updateUserProfile(id, dto);
        return dto;
    }
}
