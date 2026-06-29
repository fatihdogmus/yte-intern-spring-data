package yte.intern.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springdata.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByName(String name);
}
