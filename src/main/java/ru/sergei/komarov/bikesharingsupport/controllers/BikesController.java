package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.Bike;
import ru.sergei.komarov.bikesharingsupport.services.BikesService;

@RestController
@RequestMapping("/api/bikes")
public class BikesController extends BasicRestController<Bike, Integer> {

    public BikesController(BikesService service) {
        super(service);
    }

}
