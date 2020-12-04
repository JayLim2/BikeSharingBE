package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.TimeUnit;
import ru.sergei.komarov.bikesharingsupport.services.TimeUnitsService;

@RestController
@RequestMapping("/api/timeUnits")
public class TimeUnitsController extends BasicRestController<TimeUnit, String> {

    public TimeUnitsController(TimeUnitsService timeUnitsService) {
        super(timeUnitsService);
    }

}
