package net.jazzfestmap.app.parser.controllers;

import net.jazzfestmap.app.parser.dao.entities.FestivalEntity;
import net.jazzfestmap.app.parser.dao.repositories.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.jazzfestmap.app.parser.api.Festival;

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
