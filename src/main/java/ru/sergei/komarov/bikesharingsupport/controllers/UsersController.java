package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.models.Role;
import ru.sergei.komarov.bikesharingsupport.models.User;
import ru.sergei.komarov.bikesharingsupport.services.RolesService;
import ru.sergei.komarov.bikesharingsupport.services.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;
    private final RolesService rolesService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsersController(UsersService usersService,
                           RolesService rolesService,
                           BCryptPasswordEncoder passwordEncoder) {

        this.usersService = usersService;
        this.rolesService = rolesService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/get/all")
    public List<User> getAll() {
        return usersService.getAll();
    }

    @PutMapping("/put")
    public void put(String username, String password,
                    String fullName, int passportSeries, int passportNumber) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setFullName(fullName);
        user.setPassportSeries(passportSeries);
        user.setPassportNumber(passportNumber);
        Role role = rolesService.getById("ROLE_USER");
        user.setRole(role);
        usersService.save(user);
    }

}
