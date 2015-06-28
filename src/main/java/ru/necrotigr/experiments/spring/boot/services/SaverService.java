package ru.necrotigr.experiments.spring.boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.necrotigr.experiments.spring.boot.UrlFetcher;
import ru.necrotigr.experiments.spring.boot.api.Festival;
import ru.necrotigr.experiments.spring.boot.dao.entities.FestivalEntity;
import ru.necrotigr.experiments.spring.boot.dao.repositories.FestivalRepository;
import ru.necrotigr.experiments.spring.boot.parser.HtmlParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
@Service
public class SaverService {

    @Autowired
    private HtmlParser festsParser;

    @Autowired
    private UrlFetcher urlFetcher;

    @Autowired
    private FestivalRepository festivalRepository;

    public void save(int month, int year) {

        String url = String.format("http://jazzfests.net/dates/?month=%d&year=%d", month, year);
        try (InputStream inputStream = urlFetcher.fetchUrl(url)) {

            Collection<Festival> festivals = festsParser.parse(inputStream);
            // TODO проверяем на совпадение с уже существующими
            // TODO использовать Producer-Consumer

            //FIXME почему-то стал загружать только 8 фестивалей с 1 ошибкой
            for (Festival festival : festivals) {
                FestivalEntity festivalEntity = FestivalEntity.of(festival);
                festivalRepository.save(festivalEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
