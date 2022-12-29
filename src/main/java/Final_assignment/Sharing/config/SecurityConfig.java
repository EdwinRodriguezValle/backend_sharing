package Final_assignment.Sharing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Authentication
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        InMemoryUserDetailsManager man = new InMemoryUserDetailsManager();

        UserDetails u1 = User
                .withUsername("Yeray")
                .password(passwordEncoder.encode("Valle"))
                .roles("USER")
                .build();

        man.createUser(u1);

        UserDetails u2 = User
                .withUsername("ans")
                .password(passwordEncoder.encode("peer"))
                .roles("USER", "ADMIN")
                .build();

        man.createUser(u2);

        return man;

    }

    //Authorization
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .httpBasic()
//                .and()
//                .authorizeHttpRequests()
//                .antMatchers(HttpMethod.GET, "/secret").hasRole("ADMIN")
//                .antMatchers("/**").permitAll()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        return http.build();
//    }



//    @Configuration
//    @EnableWebSecurity
//    public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Autowired
//        public CustomUserDetailsService customUserDetailsService;
//
//        @Autowired
//        private JwtRequestFilter jwtRequestFilter;
//
//        @Autowired
//        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(customUserDetailsService);
//        }
//
//        @Override
//        @Bean
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//        }
//
//        @Bean
//        public PasswordEncoder passwordEncoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//
//            //JWT token authentication
//            http
//                    .csrf().disable()
//                    .authorizeRequests()
//                    .antMatchers(HttpMethod.POST, "/users").permitAll()
//                    .antMatchers(HttpMethod.GET,"/users").hasRole("ADMIN")
//                    .antMatchers(HttpMethod.POST,"/users/**").hasRole("ADMIN")
//                    .antMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
//                    .antMatchers("/authenticated").authenticated()
//                    .antMatchers("/authenticate").permitAll()
//                    .anyRequest().permitAll()
//                    .and()
//                    .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//            http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//
//        }


}
