package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.User;
import ru.sergei.komarov.bikesharingsupport.repositories.UsersRepository;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.DataService;

import java.util.List;

@Service
public class UsersService extends BasicDataService<User, String> implements UserDetailsService {

    public UsersService(UsersRepository usersRepository) {
        super(usersRepository);
    }

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        return getById(phone);
    }
}
