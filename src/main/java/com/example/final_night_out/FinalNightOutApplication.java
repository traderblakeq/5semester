package com.example.final_night_out;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.io.FileNotFoundException;


@Log
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class FinalNightOutApplication {

    public static void main(String[] args) throws FileNotFoundException {

        SpringApplication.run(FinalNightOutApplication.class, args);
    }
}
