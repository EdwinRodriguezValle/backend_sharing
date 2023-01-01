package Final_assignment.Sharing.security;

import Final_assignment.Sharing.exceptions.UsernameNotFoundException;
import Final_assignment.Sharing.models.UserModel;
import Final_assignment.Sharing.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class MyUserDetailsService  implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<UserModel> ou = userRepository.findById(username);
            if (ou.isPresent()) {
                UserModel userModel = ou.get();
                return new MyUserDetails(userModel);
            }
            else {
                throw new UsernameNotFoundException(username);
            }
        }

}
