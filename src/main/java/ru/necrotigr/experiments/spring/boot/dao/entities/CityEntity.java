package ru.necrotigr.experiments.spring.boot.dao.entities;

import ru.necrotigr.experiments.spring.boot.api.City;
import ru.necrotigr.experiments.spring.boot.api.Country;

import javax.persistence.*;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
@Entity
public class CityEntity implements City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private CountryEntity country;

    public CityEntity() {
    }

    public CityEntity(City city) {
        this.name = city.getName();
        this.country = new CountryEntity(city.getCountry());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Country getCountry() {
        return country;
    }
}
