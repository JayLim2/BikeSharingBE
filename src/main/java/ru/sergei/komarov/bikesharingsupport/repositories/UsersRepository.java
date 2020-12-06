package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.bikesharingsupport.models.Role;
import ru.sergei.komarov.bikesharingsupport.models.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, String> {

    List<User> findAllByRoleIn(List<Role> role);

}
