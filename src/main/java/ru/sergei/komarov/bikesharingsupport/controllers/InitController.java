package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.models.*;
import ru.sergei.komarov.bikesharingsupport.services.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/init")
public class InitController {

    int series = 10_00;
    int number = 100_000;
    long phone = 79001002030L;

    private TimeUnitsService timeUnitsService;
    private UsersService usersService;
    private TariffsService tariffsService;
    private BikesService bikesService;
    private TicketStatusesService ticketStatusesService;
    private BCryptPasswordEncoder passwordEncoder;

    public InitController(TimeUnitsService timeUnitsService, UsersService usersService,
                          TariffsService tariffsService, BikesService bikesService,
                          TicketStatusesService ticketStatusesService, BCryptPasswordEncoder passwordEncoder) {

        this.timeUnitsService = timeUnitsService;
        this.usersService = usersService;
        this.tariffsService = tariffsService;
        this.bikesService = bikesService;
        this.ticketStatusesService = ticketStatusesService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/all")
    public void initialize() {
        initHandbooks();
        initUsers();
    }

    @RequestMapping("/handbooks")
    public String initHandbooks() {
        List<TimeUnit> timeUnits = Arrays.asList(
                new TimeUnit().setName("мин"),
                new TimeUnit().setName("час"),
                new TimeUnit().setName("день")
        );
        timeUnitsService.saveAll(timeUnits);

        List<Tariff> tariffs = Arrays.asList(
                new Tariff().setName("Эконом").setPricePerTimeUnit(2).setTimeUnit(timeUnits.get(0)),
                new Tariff().setName("Комфорт").setPricePerTimeUnit(199).setTimeUnit(timeUnits.get(1)),
                new Tariff().setName("Travel").setPricePerTimeUnit(2399).setTimeUnit(timeUnits.get(2))
        );
        tariffsService.saveAll(tariffs);

        List<TicketStatus> statuses = Stream.of(
                "Поиск оператора", "В работе", "Вопрос решен", "Вопрос не решен"
        ).map(str -> new TicketStatus().setName(str)).collect(Collectors.toList());
        ticketStatusesService.saveAll(statuses);

        List<Bike> bikes = Arrays.asList(
                new Bike().setBrand("GT").setModel("Team Conway"),
                new Bike().setBrand("GT").setModel("Team Comp Conway"),
                new Bike().setBrand("GT").setModel("Team BK"),
                new Bike().setBrand("Merida").setModel("eSPEEDER"),
                new Bike().setBrand("Merida").setModel("eSILEX+"),
                new Bike().setBrand("Merida").setModel("eONE-FORTY"),
                new Bike().setBrand("Merida").setModel("eBIG.TOUR"),
                new Bike().setBrand("Stels").setModel("Navigator-500 V 26'' V020"),
                new Bike().setBrand("Stels").setModel("Navigator-700 MD 27.5'' F010"),
                new Bike().setBrand("Cube").setModel("Kathmandu Pro"),
                new Bike().setBrand("Nordway").setModel("Cruise"),
                new Bike().setBrand("Nordway").setModel("Active 300 Disc"),
                new Bike().setBrand("Nordway").setModel("Vortex")
        );
        bikesService.saveAll(bikes);

        return "OK";
    }

    @GetMapping("/users")
    public String initUsers() {
        Set<User> users = new HashSet<>();

        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setUsername(nextPhone());
            user.setPassword(getDefaultPasswordHash());
            fillRandom(user);
            user.setRole(Role.CLIENT);
            users.add(user);
        }

        for (int i = 1; i <= 3; i++) {
            User user = new User();
            user.setUsername(nextPhone());
            user.setPassword(getDefaultPasswordHash());
            fillRandom(user);
            user.setRole(Role.SUPPORT);
            users.add(user);
        }

        for (int i = 1; i <= 1; i++) {
            User user = new User();
            user.setUsername(nextPhone());
            user.setPassword(getDefaultPasswordHash());
            fillRandom(user);
            user.setRole(Role.ADMIN);
            users.add(user);
        }

        usersService.saveAll(new ArrayList<>(users));

        return "Data initialized.";
    }

    private User fillRandom(User user) {
        List<String> firstNames = Arrays.asList(
                "Сергей", "Егор", "Михаил", "Дмитрий", "Алексей",
                "Александр", "Евпатий", "Никита"
        );
        List<String> middleNames = Arrays.asList(
                "Сергеевич", "Егорович", "Михайлович", "Дмитриевич", "Алексеевич",
                "Александрович", "Евпатиевич", "Никитич"
        );
        List<String> lastNames = Arrays.asList(
                "Комаров", "Иванов", "Скворцов", "Бубнов", "Знаменский",
                "Левченко", "Цой"
        );

        String firstName = getRandomItem(firstNames);
        String middleName = new Random().nextBoolean() ?
                getRandomItem(middleNames) : null;
        String lastName = getRandomItem(lastNames);

        user.setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setPassportSeries(series++)
                .setPassportNumber(number++);

        return user;
    }

    private <T> T getRandomItem(List<T> items) {
        return items.get(getRandom(0, items.size()));
    }

    private int getRandom(int left, int right) {
        return new Random().nextInt(right - left) + left;
    }

    private String getDefaultPasswordHash() {
        return passwordEncoder.encode("root");
    }

    private String nextPhone() {
        return Long.toString(phone++);
    }
}
