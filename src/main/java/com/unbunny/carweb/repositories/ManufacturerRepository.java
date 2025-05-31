package com.unbunny.carweb.repositories;

import com.unbunny.carweb.models.cars.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Optional<Manufacturer> findBySlug(String slug);
}
