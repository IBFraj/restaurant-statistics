package com.tekup.restaurant.repository;

import com.tekup.restaurant.domain.TableUse;
import com.tekup.restaurant.model.Tablee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TableeRepository extends JpaRepository<Tablee,Long> {
    @Query("Select new com.tekup.restaurant.domain.TableUse( te.tablee,COUNT(te.tablee))" +
            " from Ticket te  GROUP BY te.tablee")
    public List<TableUse> findTopTable();
}
