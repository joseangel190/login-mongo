package com.vallegrande.login;

import com.vallegrande.login.model.User;
import com.vallegrande.login.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootApplication
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {
            User user = new User("jose", passwordEncoder.encode("123456"));
            userRepository.save(user).subscribe();

            userRepository.findAll().log().subscribe(user1 -> log.info("User:", user1));
        };
    }

}
