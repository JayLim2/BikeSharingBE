package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.Tariff;
import ru.sergei.komarov.bikesharingsupport.services.TariffsService;

@RestController
@RequestMapping("/api/tariffs")
public class TariffsController extends BasicRestController<Tariff, String> {

    public TariffsController(TariffsService service) {
        super(service);
    }

}
