package com.security0.web;


import com.security0.model.User;
import com.security0.model.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    Collection<User> users() {
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user")
    ResponseEntity<User> createGroup(@Valid @RequestBody User user) throws URISyntaxException {
        log.info("Request to create group: {}", user);
        User result = userRepository.save(user);
        return ResponseEntity.created(new URI("/api/group/" + result.getId()))
                .body(result);
    }
    @PutMapping("/user/{id}")
    ResponseEntity<User> updateGroup(@Valid @RequestBody User user) {
        log.info("Request to update group: {}", user);
        User result = userRepository.save(user);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete group: {}", id);
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
