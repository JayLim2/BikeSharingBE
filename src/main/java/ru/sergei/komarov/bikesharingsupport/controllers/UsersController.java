package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.Role;
import ru.sergei.komarov.bikesharingsupport.models.User;
import ru.sergei.komarov.bikesharingsupport.services.UsersService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController extends BasicRestController<User, String> {

    private final BCryptPasswordEncoder passwordEncoder;

    public UsersController(UsersService usersService,
                           BCryptPasswordEncoder passwordEncoder) {

        super(usersService);
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/get/all/support")
    public List<User> getAllSupport() {
        return ((UsersService) service).getByRole(Arrays.asList(
                Role.SUPPORT,
                Role.ADMIN
        ));
    }

}
