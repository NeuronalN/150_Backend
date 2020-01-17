package com.security0;

import com.security0.model.User;
import com.security0.model.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;
@Component
public class Initializer implements CommandLineRunner {
    private final UserRepository userRepository;

    public Initializer( UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Manu", "Stefan", "Elio").forEach(firstName ->
                userRepository.save(new User(firstName))
        );
        userRepository.findAll().forEach(System.out::println);
    }
}
