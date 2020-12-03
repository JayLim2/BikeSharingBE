package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.services.UsersService;

@RestController
public class AuthenticationController {

    private BCryptPasswordEncoder passwordEncoder;
    private UsersService usersService;
    private AuthenticationManager authenticationManager;

    public AuthenticationController(BCryptPasswordEncoder passwordEncoder,
                                    UsersService usersService,
                                    AuthenticationManager authenticationManager) {

        this.passwordEncoder = passwordEncoder;
        this.usersService = usersService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    @ResponseBody
    public void authenticate() {

    }
}
