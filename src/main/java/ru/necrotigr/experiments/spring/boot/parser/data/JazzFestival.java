package ru.necrotigr.experiments.spring.boot.parser.data;

import ru.necrotigr.experiments.spring.boot.api.City;
import ru.necrotigr.experiments.spring.boot.api.Festival;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JazzFestival festival = (JazzFestival) o;

        if (url != null ? !url.equals(festival.url) : festival.url != null) return false;
        if (name != null ? !name.equals(festival.name) : festival.name != null) return false;
        if (startDate != null ? !startDate.equals(festival.startDate) : festival.startDate != null) return false;
        if (endDate != null ? !endDate.equals(festival.endDate) : festival.endDate != null) return false;
        return !(cities != null ? !cities.equals(festival.cities) : festival.cities != null);

    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (cities != null ? cities.hashCode() : 0);
        return result;
    }
}
