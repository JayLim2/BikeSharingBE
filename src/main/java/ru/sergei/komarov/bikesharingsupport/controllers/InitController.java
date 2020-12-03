package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.models.Role;
import ru.sergei.komarov.bikesharingsupport.models.User;
import ru.sergei.komarov.bikesharingsupport.services.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/init")
public class InitController {

    private UsersService usersService;
    private BCryptPasswordEncoder passwordEncoder;

    public InitController(UsersService usersService,
                          BCryptPasswordEncoder passwordEncoder) {

        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/all")
    public void initialize() {
        initUsers();
    }

    @GetMapping("/users")
    public void initUsers() {
        List<User> users = new ArrayList<>();

        Random random = new Random();

        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setPhone("user" + i);
            user.setPassword(passwordEncoder.encode("root"));
            user.setFirstName("Имя");
            user.setLastName("(Client) Фамилия");
            user.setMiddleName("Отчество " + i);
            user.setPassportSeries(random.nextInt(10_000));
            user.setPassportNumber(random.nextInt(1_000_000));
            user.setRole(Role.CLIENT);
            users.add(user);
        }

        for (int i = 1; i <= 3; i++) {
            User user = new User();
            user.setPhone("support" + i);
            user.setPassword(passwordEncoder.encode("root"));
            user.setFirstName("Имя");
            user.setLastName("(Support) Фамилия");
            user.setMiddleName("Отчество " + i);
            user.setPassportSeries(random.nextInt(10_000));
            user.setPassportNumber(random.nextInt(1_000_000));
            user.setRole(Role.SUPPORT);
            users.add(user);
        }

        for (int i = 1; i <= 1; i++) {
            User user = new User();
            user.setPhone("admin" + i);
            user.setPassword(passwordEncoder.encode("root"));
            user.setFirstName("Имя");
            user.setLastName("(Admin) Фамилия");
            user.setMiddleName("Отчество " + i);
            user.setPassportSeries(random.nextInt(10_000));
            user.setPassportNumber(random.nextInt(1_000_000));
            user.setRole(Role.ADMIN);
            users.add(user);
        }

        usersService.saveAll(users);
    }
}
