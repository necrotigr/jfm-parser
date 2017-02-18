package net.jazzfestmap.app.parser.controllers;

import net.jazzfestmap.app.parser.dao.entities.FestivalEntity;
import net.jazzfestmap.app.parser.dao.entities.SimpleFestivalEntity;
import net.jazzfestmap.app.parser.dao.repositories.FestivalRepository;
import net.jazzfestmap.app.parser.dao.repositories.SimpleFestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private SimpleFestivalRepository festivalRepository;

    /**
     *
     * @return все содержимое БД
     */
    @RequestMapping("get/all")
    Iterable<Festival> getAll() {
        Collection<Festival> festivals = new ArrayList<>();
        for (SimpleFestivalEntity festivalEntity : festivalRepository.findAll()) {
            festivals.add(festivalEntity);
        }

        return festivals;
    }

    @RequestMapping("get/actual")
    Iterable<Festival> getActual() {
        return getAll();
    }

    @RequestMapping("get/date")
    Iterable<Festival> getFestivalsByDate(@RequestParam String from, @RequestParam String to) {
        return getAll();
    }
}
