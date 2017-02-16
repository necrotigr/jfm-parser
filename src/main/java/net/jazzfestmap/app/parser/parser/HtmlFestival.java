package net.jazzfestmap.app.parser.parser;

/**
 * Created by Сергей on 28.06.2015.
 *
 * Данные в raw-виде из парсера
 */
public class HtmlFestival {

    private String siteUrl;
    private String name;
    private String dates;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    @Override
    public String toString() {
        return "HtmlFestival{" +
                "siteUrl='" + siteUrl + '\'' +
                ", name='" + name + '\'' +
                ", dates='" + dates + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
