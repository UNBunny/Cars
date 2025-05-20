package com.unbunny.carweb.repositories;

import com.unbunny.carweb.models.cars.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM Car c JOIN c.categories cat WHERE cat.slug = :categorySlug")
    List<Car> findByCategorySlug(String categorySlug);

    @Query("SELECT c FROM Car c JOIN c.manufacturer m WHERE m.slug = :manufacturerSlug")
    List<Car> findByManufacturerSlug(String manufacturerSlug);

    @Query("SELECT c FROM Car c JOIN c.categories cat WHERE cat.slug = :categorySlug AND c.year BETWEEN :yearFrom AND :yearTo")
    List<Car> findByCategoryAndYearRange(String categorySlug, Integer yearFrom, Integer yearTo);

    @Modifying
    @Query("UPDATE Car c SET c.views = c.views + 1 WHERE c.id = :carId")
    void incrementViews(Integer carId);
}
