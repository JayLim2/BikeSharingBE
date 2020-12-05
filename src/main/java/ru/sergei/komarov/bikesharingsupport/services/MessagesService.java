package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Message;
import ru.sergei.komarov.bikesharingsupport.repositories.MessagesRepository;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;

import java.util.List;

@Service
public class MessagesService extends BasicDataService<Message, Integer> {

    public MessagesService(MessagesRepository repository) {
        super(repository);
    }

    public List<Message> getByUser(String userId) {
        return ((MessagesRepository) repository).findByUser(userId);
    }

}
