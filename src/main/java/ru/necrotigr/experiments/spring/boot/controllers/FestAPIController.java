package ru.necrotigr.experiments.spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.necrotigr.experiments.spring.boot.api.Festival;
import ru.necrotigr.experiments.spring.boot.dao.entities.FestivalEntity;
import ru.necrotigr.experiments.spring.boot.dao.repositories.FestivalRepository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Сергей on 28.06.2015.
 *
 * Соединяет EventAPI и маппинги контроллеров
 */
@RestController
@RequestMapping("api")
public class FestAPIController {

    @Autowired
    private FestivalRepository festivalRepository;

    @RequestMapping("festivals")
    Iterable<Festival> getFestivals() {
        Collection<Festival> festivals = new ArrayList<>();
        for (FestivalEntity festivalEntity : festivalRepository.findAll()) {
            festivals.add(festivalEntity);
        }

        return festivals;
    }
}
