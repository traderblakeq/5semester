package com.example.final_night_out;

import com.example.final_night_out.Models.Features;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.FileNotFoundException;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class FinalNightOutApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(FinalNightOutApplication.class, args);
    }

}
