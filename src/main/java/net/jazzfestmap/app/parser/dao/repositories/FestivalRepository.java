package net.jazzfestmap.app.parser.dao.repositories;

import net.jazzfestmap.app.parser.dao.entities.FestivalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Сергей on 28.06.2015.
 *
 * Spring Data интерфейс - реализации не требует
 *
 */
@Repository
public interface FestivalRepository extends CrudRepository<FestivalEntity, Long>{


}
