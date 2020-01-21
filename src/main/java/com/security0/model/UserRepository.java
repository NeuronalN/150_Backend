package com.security0.model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   // User findByFirstName(String firstName);
}
