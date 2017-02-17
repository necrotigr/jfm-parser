package net.jazzfestmap.app.parser.parser.impl.apassion4jazz;

import net.jazzfestmap.app.parser.api.Festival;
import net.jazzfestmap.app.parser.parser.FestivalAdaptor;
import net.jazzfestmap.app.parser.parser.HtmlFestival;
import net.jazzfestmap.app.parser.parser.HtmlParser;
import net.jazzfestmap.app.parser.parser.InvalidFestivalFormatException;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Сергей on 16.02.2017.
 *
 * Парсер для событий apassion4jazz.net
 */
@Component
public class APassion4JazzParser  implements HtmlParser {

    private Queue<Festival> festivals;

    public APassion4JazzParser() {
    }

    @Override
    public Collection<Festival> parse(InputStream inputStream) {
        // читаем сразу всё из файла
        try {
            String html = IOUtils.toString(inputStream, Charset.forName("windows-1252"));
            Document doc = Jsoup.parse(html);

            // определяем дату страницы - она может НЕ соответствовать текущему году
            //  <div class="bop festMonths">January 2017</div>
            Element dateEl = doc.select("div.festMonths").first();
            String heldMonth = dateEl.text().split(" ")[0];
            String heldYear = dateEl.text().split(" ")[1];

            // находим основной список событий
            Elements festList = doc.select("ul.fest");
            Elements festListItems = festList.select("li");
            FestivalAdaptor adaptor = new APassion4JazzFestAdaptor();
            this.festivals = new ConcurrentLinkedQueue<>();
            int errorCount = 1;
            for (Element p : festListItems) {
                try {
                    HtmlFestival htmlFestival = readEventItem(p);
                    htmlFestival.setHeldMonth(heldMonth);
                    htmlFestival.setHeldYear(heldYear);
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
            return Collections.emptyList();
        }
    }

    public HtmlFestival readEventItem(Element li) throws InvalidFestivalFormatException {
        HtmlFestival result = new HtmlFestival();
        Element link = li.select("a").first();
        String festUrl = link.attr("href");
        result.setSiteUrl(festUrl);

        String festName = link.text();
        result.setName(festName);

        String liText = li.html();
        String[] parts = liText.split("<br>");
        String dateHtml = parts[0].trim();
        String[] dateHtmlParts = dateHtml.split(">");
        String dateStr = dateHtmlParts[dateHtmlParts.length-1].replace("-", "").trim();
        result.setDates(dateStr);

        String locationStr = parts[1].trim().split("<")[0].split("&")[0].trim();
        result.setLocation(locationStr);

        return result;
    }
}
