package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.Message;
import ru.sergei.komarov.bikesharingsupport.services.MessagesService;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessagesController extends BasicRestController<Message, Integer> {

    public MessagesController(MessagesService service) {
        super(service);
    }

    @GetMapping("/get/user/{userId}")
    public List<Message> getByUser(@PathVariable String userId) {
        return ((MessagesService) service).getByUser(userId);
    }

}
