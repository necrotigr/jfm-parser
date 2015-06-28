package ru.necrotigr.experiments.spring.boot.api;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Сергей on 28.06.2015.
 *
 * Интерфейс для любого фестиваля - именно фестиваля, а не события, т.к. событие может проходить только в определенную дату
 *
 * Выбран Period - т.к. фестиваль проводится в определенном диапазоне дат
 * Список городов - т.к. фестиваль может проходить в разных городах
 * Когда фестиваль проходит в конкретном городе - неизвестно
 */
public interface Festival {

    String getUrl();
    Date getStartDate();
    Date getEndDate();
    String getName();
    Collection<City> getCities();

}
