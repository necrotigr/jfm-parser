package ru.necrotigr.experiments.spring.boot.parser;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import ru.necrotigr.experiments.spring.boot.api.Festival;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Сергей on 28.06.2015.
 * Парсер событий на jazzfests.net
 */
@Component
public class FestsParser implements HtmlParser {

    private Queue<Festival> festivals;

    public FestsParser() {
     //   this.festivals = new ConcurrentLinkedQueue<>();
    }

    @Override
    public Collection<Festival> parse(InputStream inputStream) {

        // читаем сразу всё из файла
        try {
            String html = IOUtils.toString(inputStream, Charset.forName("windows-1252"));
            Document doc = Jsoup.parse(html);
            /* идем по структуре из старого PHPшного парсера
            Структура:
            - p
                    - a - ссылка на сайт фестиваля (url)
                    - b - название фестиваля (name)
                    - /a
                    - a - ссылка Добавить в мои фестивали (не нужна) /a
                    - br
                    - Даты: через &#8211 (start_date, end_date
                    - br
                    - Location: city (cities, country) (location)
                    - /p
            */
            // находим все тэги <p>
            Elements paragraphs = doc.select("p");
            RawFestivalAdaptor adaptor = new RawFestivalAdaptor();
            this.festivals = new ConcurrentLinkedQueue<>();
            int errorCount = 1;
            for (Element p : paragraphs) {
                try {
                    HtmlFestival htmlFestival = readParagraph(p);
                    System.out.println(htmlFestival);
                    Festival festival = adaptor.convert(htmlFestival);
                    festivals.add(festival);
                } catch (InvalidFestivalFormatException e) {
                    errorCount++;
                }
            }

            System.out.print(String.format("Parsed %d festivals, errors = %d", festivals.size(), errorCount));

            return festivals;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private HtmlFestival readParagraph(Element p) throws InvalidFestivalFormatException {
        String festUrl = "";
        Element festLink = null;
        String festName = "";
        if (p.select("a").size() == 2) {
             festLink = p.select("a").first();
             festUrl = festLink.attr("href");
             festName = festLink.getAllElements().select("b").html();
        } else {
            festName = p.select("b").first().text();
        }

        // проверяем, есть ли название venue перед Dates:
        String[] datesAndLocation = null;
        if (p.ownText().startsWith("Dates:")) {
            datesAndLocation = p.ownText().substring("Dates:".length()).split("Location:");
        } else if (p.ownText().contains("Dates:")) {
            String[] withVenue = p.ownText().split("Dates:");
            datesAndLocation = withVenue[1].split("Location:");
        } else if (p.ownText().contains("Date:"))  {
            if (p.ownText().startsWith("Date:"))
                datesAndLocation = p.ownText().substring("Date:".length()).split("Location:");
            else {
                String[] withVenue = p.ownText().split("Date:");
                datesAndLocation = withVenue[1].split("Location:");
            }
        } else
            // не парсим другие варианты
            throw new InvalidFestivalFormatException(p.html());


        String dates = datesAndLocation[0].trim();
        if (dates.matches("[a-zA-Z]+, [0-9]+")) {
            throw new InvalidFestivalFormatException(p.html());
        }
        String location = datesAndLocation[1];

        HtmlFestival htmlFestival = new HtmlFestival();
        htmlFestival.setDates(dates.trim());

        htmlFestival.setLocation(location.trim());
        htmlFestival.setName(festName);
        htmlFestival.setSiteUrl(festUrl);

        return htmlFestival;
    }
}
