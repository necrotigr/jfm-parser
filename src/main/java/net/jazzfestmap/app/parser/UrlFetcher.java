package net.jazzfestmap.app.parser;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by Сергей on 28.06.2015.
 *
 *  Получает html-документ (inputStream) по урлу
 */
@Component
public class UrlFetcher {

    // TODO сделать более интеллектуальную задержку
    public static final int DELAY = 500;

    public InputStream fetchUrl(String url) throws IOException, InterruptedException, HttpException {
        Thread.sleep(DELAY);
        HttpClient httpClient = HttpClientBuilder.create()
                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0")
                .build();
        HttpUriRequest uriRequest = new HttpGet(url);
        HttpResponse response = httpClient.execute(uriRequest);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            return response.getEntity().getContent();
        else
            throw new HttpException(IOUtils.toString(response.getEntity().getContent(), Charset.defaultCharset()));
    }


}
