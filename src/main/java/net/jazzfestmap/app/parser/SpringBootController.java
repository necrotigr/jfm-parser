package net.jazzfestmap.app.parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
@SpringBootApplication
@EnableScheduling
public class SpringBootController {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootController.class, args);
    }
}
