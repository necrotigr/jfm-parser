package net.jazzfestmap.app.parser.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.jazzfestmap.app.parser.api.City;
import net.jazzfestmap.app.parser.api.DateType;
import net.jazzfestmap.app.parser.api.Festival;
import net.jazzfestmap.app.parser.parser.data.FestCity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "url", "startDate", "endDate"}))
public class SimpleFestivalEntity implements Festival {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String name;

    @Basic
    private String url;

    @Basic
    private Timestamp startDate;

    @Basic
    private Timestamp endDate;

    @Basic
    private DateType dateType;

    @Basic
    private String city;

    @Basic
    private String country;

    @Basic
    private Double lat;

    @Basic
    private Double lon;

    public SimpleFestivalEntity() {
    }

    public SimpleFestivalEntity(String name, String url, Timestamp startDate, Timestamp endDate, String city, String country, DateType dateType) {
        this.name = name;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateType = dateType;
        this.city = city;
        this.country = country;
    }

    public static SimpleFestivalEntity of(Festival festival) {
        Collection<CityEntity> citiesList = new ArrayList<>();
        for (City city : festival.getCities()) {
            citiesList.add(new CityEntity(city));
        }
        City city = festival.getCities().iterator().next();
        return new SimpleFestivalEntity(festival.getName(), festival.getUrl(),
                new Timestamp(festival.getStartDate().getTime()), new Timestamp(festival.getEndDate().getTime()),
                city.getName(), city.getCountry().getName(), festival.getDateType());
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getUrl() {
        return url;
    }

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

    @JsonIgnore
    @Transient
    @Override
    public Collection<City> getCities() {
        FestCity festCity = new FestCity();
        festCity.setName(city);
        return Collections.singletonList(festCity);
    }

    @JsonIgnore
    @Override
    public DateType getDateType() {
        return dateType;
    }
}
