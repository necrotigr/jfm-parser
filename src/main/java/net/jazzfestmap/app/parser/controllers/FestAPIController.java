package net.jazzfestmap.app.parser.controllers;

import net.jazzfestmap.app.parser.api.Festival;
import net.jazzfestmap.app.parser.dao.entities.SimpleFestivalEntity;
import net.jazzfestmap.app.parser.dao.repositories.SimpleFestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
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
            if ( (festivalEntity.getLat() != null) && (festivalEntity.getLon() != null) )
                festivals.add(festivalEntity);
        }

        return festivals;
    }

    /**
     *
     * @return только те фестивали, которые проходят в настоящее время или будут проходить в будущем
     */
    @RequestMapping("get/actual")
    Iterable<Festival> getActual() {
        return festivalRepository.findActual();
    }

    @RequestMapping("get/date")
    Iterable<Festival> getFestivalsByDate(@RequestParam(required = false) Long from,
                                          @RequestParam(required = false) Long to) {
        Timestamp start = (from == null) ? new Timestamp(System.currentTimeMillis()) : new Timestamp(from);
        Timestamp end = (to == null) ? null : new Timestamp(to);
        if (end == null)
            return festivalRepository.findByStartDate(start);
        else
            return festivalRepository.findByStartEndDate(start, end);
    }
}
