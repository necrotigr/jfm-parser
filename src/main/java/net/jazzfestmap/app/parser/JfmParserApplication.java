package net.jazzfestmap.app.parser;

import net.jazzfestmap.app.parser.dao.services.SaverService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.inject.Inject;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
@SpringBootApplication
@EnableScheduling
public class JfmParserApplication implements CommandLineRunner {

    @Inject
    private SaverService saverService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(JfmParserApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        //saverService.fetchAndSave(SaverService.APASSION4JAZZ_URL, 0);
    }
}
