package Final_assignment.Sharing.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

//    private final AuthenticationManager authManager;
//    private final JwtService jwtService;
//
//    public AuthController(AuthenticationManager man, JwtService service) {
//        this.authManager = man;
//        this.jwtService = service;
//    }
//
//    @PostMapping("/auth")
//    public ResponseEntity<Object> signIn(@RequestBody AuthDto authDto) {
//        UsernamePasswordAuthenticationToken up =
//                new UsernamePasswordAuthenticationToken(authDto.username, authDto.password);
//
//        try {
//            Authentication auth = authManager.authenticate(up);
//
//            UserDetails ud = (UserDetails) auth.getPrincipal();
//            String token = jwtService.generateToken(ud);
//
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
//                    .body("Token generated");
//        }
//        catch (AuthenticationException ex) {
//            return new ResponseEntity(ex.getMessage(), HttpStatus.UNAUTHORIZED);
//        }
//    }
//
}
