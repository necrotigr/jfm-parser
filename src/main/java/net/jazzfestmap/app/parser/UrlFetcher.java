package net.jazzfestmap.app.parser;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Сергей on 28.06.2015.
 *
 *  Получает html-документ (inputStream) по урлу
 */
@Component
public class UrlFetcher {

    public InputStream fetchUrl(String url) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpUriRequest uriRequest = new HttpGet(url);
        HttpResponse response = httpClient.execute(uriRequest);
        return response.getEntity().getContent();
    }


}
