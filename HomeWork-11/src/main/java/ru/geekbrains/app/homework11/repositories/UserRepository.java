package ru.geekbrains.app.homework11.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.app.homework11.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserById(Long id);
}
