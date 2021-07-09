package com.tekup.restaurant.repository;

import com.tekup.restaurant.domain.MetUse;
import com.tekup.restaurant.domain.TableUse;
import com.tekup.restaurant.model.Client;
import com.tekup.restaurant.model.MetTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MetTicketRepository extends JpaRepository<MetTicket,Long> {
    @Query("Select new com.tekup.restaurant.domain.MetUse(te.met,COUNT(te.met))" +
            " from MetTicket te where (te.metDate <= :dateN and te.metDate >= :dateP) GROUP BY te.met")
    public List<MetUse> findTopPlat(@Param("dateP") LocalDate dateP,@Param("dateN") LocalDate dateN);
    @Query(value ="Select te.met_id as me,COUNT(te.met_id) as cnt" +
            " from met_ticket te JOIN met mett on mett.id = te.met_id where (te.met_date <= :dateN and te.met_date >= :dateP and mett.dtype = 'plat') GROUP BY te.met_id order by cnt desc", nativeQuery = true)
    public List findTopPlatSql(@Param("dateP") LocalDate dateP,@Param("dateN") LocalDate dateN);
}
