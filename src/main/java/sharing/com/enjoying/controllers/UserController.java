package sharing.com.enjoying.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sharing.com.enjoying.dtos.UserDto;
import sharing.com.enjoying.exceptions.BadRequestException;
import sharing.com.enjoying.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping (value = "")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> userDtos = userService.getAllUsers();
        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable("username") String username) {
        UserDto optionalUser = userService.getUser(username);
        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping(value =" ")
    public ResponseEntity<UserDto>createCustomer(@RequestBody UserDto dto){
        String newUserName = userService.createUser(dto);
        userService.addAuthority(newUserName, "ROLE USER");
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUserName).toUri();

        return ResponseEntity.created(location).build();

    }
    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDto> updateCustomer(@PathVariable("username") String username, @RequestBody UserDto dto){
        userService.updateUserModel(username, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value ="/{username}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("username") String username){
        userService.deleteUserModel(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "{username}/authority")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object>addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields){
        try{
            String authorityName = (String)fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        } catch (Exception ex){
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/ authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username")String username, @PathVariable("authority") String authority){
        userService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }
}
