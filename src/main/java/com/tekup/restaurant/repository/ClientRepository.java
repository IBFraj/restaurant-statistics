package com.tekup.restaurant.repository;

import com.tekup.restaurant.domain.ClientUse;
import com.tekup.restaurant.domain.DayClient;
import com.tekup.restaurant.domain.TableUse;
import com.tekup.restaurant.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository <Client,Long> {
    @Query("Select new com.tekup.restaurant.domain.ClientUse( te.client,COUNT(te.client))" +
            " from Ticket te  GROUP BY te.client")
    public List<ClientUse> findTopClient();
    /*@Query("Select new com.tekup.restaurant.domain.DayClient( te.date,count (te.date))" +
            " from Ticket te where te.client.id = :clientId  GROUP BY te.date")
    public List<DayClient> findTopDayByClient(@Param("clientId") Long clientId);*/
    @Query("Select te.date as date,count (te.date) as cnt" +
            " from Ticket te where te.client.id = :clientId  GROUP BY te.date order by cnt desc")
    public List findTopDayByClientSql(@Param("clientId") Long clientId);
}
