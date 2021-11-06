package engine.controllers;

import engine.model.User;
import engine.repos.UserDBRepo;
import engine.repos.UserRepo;
import engine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/api/register")
    public ResponseEntity register( @Valid @RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        int status = userService.save(user);
        return ResponseEntity.status(status)
                .headers(responseHeaders)
                .body(null);

    }
}
