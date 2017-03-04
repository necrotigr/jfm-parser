package net.jazzfestmap.app.parser.dao.repositories;

import net.jazzfestmap.app.parser.api.Festival;
import net.jazzfestmap.app.parser.dao.entities.SimpleFestivalEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

/**
 * Created by Сергей on 28.06.2015.
 *
 * Spring Data интерфейс - реализации не требует
 *
 */
@Repository
public interface SimpleFestivalRepository extends CrudRepository<SimpleFestivalEntity, Long>{

    @Query("SELECT s FROM SimpleFestivalEntity s WHERE s.startDate >= CURRENT_TIMESTAMP()")
    Iterable<Festival> findActual();

    @Query("SELECT s FROM SimpleFestivalEntity s WHERE s.startDate >= :startDate")
    Iterable<Festival> findByStartDate(@Param("startDate")Timestamp startDate);

    @Query("SELECT s FROM SimpleFestivalEntity s WHERE s.startDate >= CURRENT_TIMESTAMP() AND s.endDate <= :endDate")
    Iterable<Festival> findByEndDate(@Param("endDate")Timestamp endDate);

    @Query("SELECT s FROM SimpleFestivalEntity s WHERE s.startDate >= :startDate AND s.endDate <= :endDate")
    Iterable<Festival> findByStartEndDate(@Param("startDate")Timestamp startDate, @Param("endDate")Timestamp endDate);

}
