package yte.intern.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springdata.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
