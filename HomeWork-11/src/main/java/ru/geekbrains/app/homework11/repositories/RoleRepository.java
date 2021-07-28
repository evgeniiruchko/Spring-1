package ru.geekbrains.app.homework11.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.app.homework11.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
