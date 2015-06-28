package ru.necrotigr.experiments.spring.boot.data;

import ru.necrotigr.experiments.spring.boot.api.City;
import ru.necrotigr.experiments.spring.boot.api.Festival;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
public class JazzFestival implements Festival {

    private String url;
    private String name;
    private Date startDate;
    private Date endDate;
    private Collection<City> cities;

    @Override
    public Date getStartDate() {
        return startDate;

    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<City> getCities() {
        return cities;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCities(Collection<City> cities) {
        this.cities = cities;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", cities=" + cities +
                '}';
    }
}
