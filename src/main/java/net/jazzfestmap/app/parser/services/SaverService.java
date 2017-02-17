package net.jazzfestmap.app.parser.services;

import net.jazzfestmap.app.parser.UrlFetcher;
import net.jazzfestmap.app.parser.api.Festival;
import net.jazzfestmap.app.parser.dao.entities.FestivalEntity;
import net.jazzfestmap.app.parser.dao.repositories.FestivalRepository;
import net.jazzfestmap.app.parser.parser.HtmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    @Qualifier("aPassion4JazzParser")
    private HtmlParser festsParser;

    @Autowired
    private UrlFetcher urlFetcher;

    @Autowired
    private FestivalRepository festivalRepository;

    public void fetchAndSave(String urlTemplate, int month, int year) {
        String url = String.format("http://jazzfests.net/dates/?month=%d&year=%d", month, year);
        extractFestsFromUrl(url);
    }

    public void fetchAndSave(String urlTemplate, int month) {
        if (month == 0 ) {
            for (int i = 1; i <= 12 ; i++) {
                String url = String.format(urlTemplate, i);
                extractFestsFromUrl(url);
            }
        } else {
            String url = String.format(urlTemplate, month);
            extractFestsFromUrl(url);
        }
    }


    void extractFestsFromUrl(String url) {
        try (InputStream inputStream = urlFetcher.fetchUrl(url)) {

            Collection<Festival> festivals = festsParser.parse(inputStream);
            // TODO проверяем на совпадение с уже существующими
            // TODO использовать Producer-Consumer

            //FIXME почему-то стал загружать только 8 фестивалей с 1 ошибкой
            for (Festival festival : festivals) {
                try {
                    FestivalEntity festivalEntity = FestivalEntity.of(festival);
                    festivalRepository.save(festivalEntity);
                } catch (Exception e) {
                    System.err.println("Can't save festival: " + festival);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
