package sharing.com.enjoying.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sharing.com.enjoying.dtos.UserDto;
import sharing.com.enjoying.exceptions.RecordNotFoundException;
import sharing.com.enjoying.models.AuthorityModel;
import sharing.com.enjoying.models.UserModel;
import sharing.com.enjoying.repositories.UserRepository;
import sharing.com.enjoying.utils.RandomStringGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<UserModel> list = userRepository.findAll();
        for (UserModel user : list) {
            collection.add(transferFromUserToDto(user));
        }
        return collection;
    }

    public UserDto getUser(String username){
        UserDto dto = new UserDto();
        Optional<UserModel> userModel = userRepository.findById(username);
        if(userModel.isPresent()){
            dto = transferFromUserToDto(userModel.get());
        }else{
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public boolean userExists(String username){
        return userRepository.existsById(username);
    }

    public String createUser(UserDto userDto){
        String randomString = RandomStringGenerator.generateAlphaNumeric(30);
        userDto.setApikey(randomString);
        UserModel newUserModel = userRepository.save(transferToUserModel(userDto));
        return newUserModel.getUsername();
    }

    public void deleteUserModel(String username){
        userRepository.deleteById(username);
    }

    public void updateUserModel(String username, UserDto userDto){
        if(!userRepository.existsById(username)) throw new RecordNotFoundException( );
        UserModel userModel = userRepository.findById(username).get();
        userModel.setPassword(userDto.getPassword());

        userRepository.save(userModel);

    }

    public Set<AuthorityModel> getAuthorities(String username){
        if(!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        UserModel userModel = userRepository.findById(username).get();
        UserDto userDto = transferFromUserToDto(userModel);

        return userDto.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        UserModel userModel = userRepository.findById(username).get();
        userModel. addAuthority (new AuthorityModel(username, authority));
        userRepository.save(userModel);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        UserModel userModel = userRepository.findById(username).get();
        AuthorityModel authorityToRemove = userModel.getAuthorityModels().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        userModel.removeAuthority(authorityToRemove);
        userRepository.save(userModel);
    }

        public static UserDto transferFromUserToDto(UserModel user){
        var dto = new UserDto();
        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.apikey = user.getApikey();
        dto.email = user.getEmail();
        dto.authorities = user.getAuthorityModels();

        return dto;
    }
    public UserModel transferToUserModel(UserDto userDto) {

        var user = new UserModel();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEnabled(userDto.getEnabled());
        user.setApikey(userDto.getApikey());
        user.setEmail(userDto.getEmail());

        return user;
    }

}

