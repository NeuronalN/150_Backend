package com.security0.model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByFirstName(String firstName);
}
