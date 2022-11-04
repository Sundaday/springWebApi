package com.example.SpringMVC.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student sundaday = new Student(
                    1L,
                    "Sundaday",
                    "sundaday@gmail.com",
                    LocalDate.of(1988, 8, 12)
            );

            Student sundada1 = new Student(
                    2L,
                    "Sundada1",
                    "sundada@gmail.com",
                    LocalDate.of(1988, 8, 12)
            );

            repository.saveAll(
                    List.of(sundaday, sundada1)
            );
        };
    }
}
