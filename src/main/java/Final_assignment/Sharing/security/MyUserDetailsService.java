//package Final_assignment.Sharing.security;
//
//import Final_assignment.Sharing.exceptions.UsernameNotFoundException;
//import Final_assignment.Sharing.models.UserModel;
//import Final_assignment.Sharing.repositories.UserRepository;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Optional;
//
//public class MyUserDetailsService   implements UserDetailsService {
//
//        private final UserRepository userRepos;
//
//        public MyUserDetailsService(UserRepository repos) {
//            this.userRepos = repos;
//        }
//        @Override
//        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//            Optional<UserModel> ou = userRepos.findById(username);
//            if (ou.isPresent()) {
//                UserModel userModel = ou.get();
//                return new MyUserDetails(userModel);
//            }
//            else {
//                throw new UsernameNotFoundException(username);
//            }
//        }
//
//}
