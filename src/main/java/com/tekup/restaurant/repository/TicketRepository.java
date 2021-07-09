package com.tekup.restaurant.repository;

import com.tekup.restaurant.domain.MetUse;
import com.tekup.restaurant.model.Ticket;

import java.awt.geom.Arc2D.Float;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
	@Query("Select SUM(te.addition)" +
            " from Ticket te where (DATE(te.date) = :day)")
    public float findRevenueByDay(@Param("day") LocalDate day);
	@Query("Select SUM(te.addition)" +
            " from Ticket te where (DATE(te.date) <= :dateN and DATE(te.date) >= :dateP  )")
    public float findRevenueByPeroide(@Param("dateP") LocalDate dateP,@Param("dateN") LocalDate dateN);
}
