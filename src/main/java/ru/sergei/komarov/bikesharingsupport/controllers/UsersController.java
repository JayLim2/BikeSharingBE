package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.User;
import ru.sergei.komarov.bikesharingsupport.services.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController extends BasicRestController<User, String> {

    private final BCryptPasswordEncoder passwordEncoder;

    public UsersController(UsersService usersService,
                           BCryptPasswordEncoder passwordEncoder) {

        super(usersService);
        this.passwordEncoder = passwordEncoder;
    }

}
