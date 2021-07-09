package com.tekup.restaurant.repository;

import com.tekup.restaurant.domain.TableUse;
import com.tekup.restaurant.model.Dessert;
import com.tekup.restaurant.model.Entree;
import com.tekup.restaurant.model.Met;
import com.tekup.restaurant.model.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MetRepository extends JpaRepository<Met,Long> {
    @Query("Select p from Plat p")
    public List<Plat> findAllPlat();
    @Query("Select e from Entree e")
    public List<Entree> findAllEntree();
    @Query("Select d from Dessert d")
    public List<Dessert> findAllDessert();

}
