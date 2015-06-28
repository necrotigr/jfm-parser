package ru.necrotigr.experiments.spring.boot.dao.entities;

import ru.necrotigr.experiments.spring.boot.api.City;
import ru.necrotigr.experiments.spring.boot.api.Festival;

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

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<CityEntity> cities;

    public FestivalEntity() {
    }

    public FestivalEntity(String name, String url, Timestamp startDate, Timestamp endDate, Collection<CityEntity> cities) {
        this.name = name;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cities = cities;
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

    public static FestivalEntity of(Festival festival) {
        Collection<CityEntity> citiesList = new ArrayList<>();
        for (City city : festival.getCities()) {
            citiesList.add(new CityEntity(city));
        }

        return new FestivalEntity(festival.getName(), festival.getUrl(),
                new Timestamp(festival.getStartDate().getTime()), new Timestamp(festival.getEndDate().getTime()),
                citiesList);
    }
}
