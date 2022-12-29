package Final_assignment.Sharing.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            return "Hello " + ((UserDetails) auth.getPrincipal()).getUsername();
        }
        return "Hello stranger!";
    }

    @GetMapping("/secret")
    public String tellSecret() {
        return "this is secret...";
    }
}
