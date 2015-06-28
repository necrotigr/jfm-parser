package ru.necrotigr.experiments.spring.boot.dao.entities;

import ru.necrotigr.experiments.spring.boot.api.City;
import ru.necrotigr.experiments.spring.boot.api.Country;

import javax.persistence.*;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
@Entity
public class CountryEntity implements Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String name;

    public CountryEntity() {
    }

    public CountryEntity(Country country) {
        this.name = country.getName();
    }

    @Override
    public String getName() {
        return name;
    }
}
