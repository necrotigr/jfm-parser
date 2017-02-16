package net.jazzfestmap.app.parser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.jazzfestmap.app.parser.UrlFetcher;
import net.jazzfestmap.app.parser.api.Festival;
import net.jazzfestmap.app.parser.dao.entities.FestivalEntity;
import net.jazzfestmap.app.parser.dao.repositories.FestivalRepository;
import net.jazzfestmap.app.parser.parser.HtmlParser;

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
