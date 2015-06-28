package ru.necrotigr.experiments.spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.necrotigr.experiments.spring.boot.UrlFetcher;
import ru.necrotigr.experiments.spring.boot.api.Festival;
import ru.necrotigr.experiments.spring.boot.dao.entities.FestivalEntity;
import ru.necrotigr.experiments.spring.boot.dao.repositories.FestivalRepository;
import ru.necrotigr.experiments.spring.boot.parser.HtmlParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
@RestController("/")
public class MainController {

    @Autowired
    private HtmlParser festsParser;

    @Autowired
    private UrlFetcher urlFetcher;

    @Autowired
    private FestivalRepository festivalRepository;


    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "index";
    }

    @RequestMapping("/festivals")
    @ResponseBody
    Iterable<Festival> getFestivals() {
        Collection<Festival> festivals = new ArrayList<>();
        for (FestivalEntity festivalEntity : festivalRepository.findAll()) {
            festivals.add(festivalEntity);
        }

        return festivals;
    }

    @RequestMapping("/parse")
    @ResponseBody
    String parse() throws IOException {

        InputStream inputStream = urlFetcher.fetchUrl("http://jazzfests.net/dates/?month=07&year=2015");
        Collection<Festival> festivals = festsParser.parse(inputStream);
        for (Festival festival : festivals) {
            FestivalEntity festivalEntity = FestivalEntity.of(festival);

            festivalRepository.save(festivalEntity);
        }
        return String.valueOf(festivals.size());
    }}
