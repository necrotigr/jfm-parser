package net.jazzfestmap.app.parser.dao.entities;

import net.jazzfestmap.app.parser.api.City;
import net.jazzfestmap.app.parser.api.DateType;
import net.jazzfestmap.app.parser.api.Festival;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
@Entity
public class FestivalEntity implements Festival {

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

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<CityEntity> cities;

    public FestivalEntity() {
    }

    public FestivalEntity(String name, String url, Timestamp startDate, Timestamp endDate, Collection<CityEntity> cities, DateType dateType) {
        this.name = name;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cities = cities;
        this.dateType = dateType;
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

    @Override
    public Collection<City> getCities() {
        Collection<City> citiesList = cities.stream().collect(Collectors.toList());
        return citiesList;
    }

    @Override
    public DateType getDateType() {
        return dateType;
    }

    public static FestivalEntity of(Festival festival) {
        Collection<CityEntity> citiesList = new ArrayList<>();
        for (City city : festival.getCities()) {
            citiesList.add(new CityEntity(city));
        }

        return new FestivalEntity(festival.getName(), festival.getUrl(),
                new Timestamp(festival.getStartDate().getTime()), new Timestamp(festival.getEndDate().getTime()),
                citiesList, festival.getDateType());
    }
}
