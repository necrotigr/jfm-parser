package ru.necrotigr.experiments.spring.boot.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.necrotigr.experiments.spring.boot.api.Festival;
import ru.necrotigr.experiments.spring.boot.dao.entities.FestivalEntity;

/**
 * Created by Сергей on 28.06.2015.
 *
 * Spring Data интерфейс - реализации не требует
 *
 */
@Repository
public interface FestivalRepository extends CrudRepository<FestivalEntity, Long>{


}
