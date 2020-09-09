package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.bikesharingsupport.models.TimeUnit;
import ru.sergei.komarov.bikesharingsupport.services.TimeUnitsService;

@RestController
@RequestMapping("/api/timeUnits")
public class TimeUnitsController {

    private final TimeUnitsService timeUnitsService;

    public TimeUnitsController(TimeUnitsService timeUnitsService) {
        this.timeUnitsService = timeUnitsService;
    }

    @GetMapping("/get/all")
    public Iterable<TimeUnit> getAll() {
        return timeUnitsService.getAll();
    }

    @PutMapping("/put")
    public void add(@RequestParam String name) {
        TimeUnit timeUnit = new TimeUnit();
        timeUnit.setName(name == null ? "NaN" : name);
        timeUnitsService.save(timeUnit);
    }
}
