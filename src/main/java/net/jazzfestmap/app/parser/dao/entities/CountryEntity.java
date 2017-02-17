package net.jazzfestmap.app.parser.dao.entities;

import net.jazzfestmap.app.parser.api.Country;

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
    @Column(unique = true)
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
