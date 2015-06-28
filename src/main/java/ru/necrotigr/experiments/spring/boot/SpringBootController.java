package ru.necrotigr.experiments.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.necrotigr.experiments.spring.boot.api.Festival;
import ru.necrotigr.experiments.spring.boot.dao.entities.FestivalEntity;
import ru.necrotigr.experiments.spring.boot.dao.repositories.FestivalRepository;
import ru.necrotigr.experiments.spring.boot.parser.HtmlParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
@SpringBootApplication
public class SpringBootController {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootController.class, args);
    }
}
