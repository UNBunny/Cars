package com.unbunny.carweb.controllers;


import com.unbunny.carweb.dto.CarRequest;
import com.unbunny.carweb.dto.CarResponse;
import com.unbunny.carweb.dto.filters.CarFilterRequest;
import com.unbunny.carweb.services.interfaces.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarResponse>> getCars(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) Integer yearFrom,
            @RequestParam(required = false) Integer yearTo,
            @RequestParam(required = false, defaultValue = "newest") String sort
    ) {
        CarFilterRequest carFilterRequest = CarFilterRequest.builder()
                .categorySlug(category)
                .manufacturerSlug(manufacturer)
                .yearFrom(yearFrom)
                .yearTo(yearTo)
                .sort(sort)
                .build();
        List<CarResponse> cars = carService.getCarsByFilter(carFilterRequest);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PostMapping
    public ResponseEntity<CarResponse> createNewCar(@Valid @RequestBody CarRequest carRequest) {
        return new ResponseEntity<>(carService.createCar(carRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponse> updateCar(@PathVariable Long id, @Valid @RequestBody CarRequest carRequest) {
        CarResponse updatedCar = carService.updateCar(id, carRequest);
        return ResponseEntity.ok(updatedCar);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CarResponse> partialUpdateCar(@PathVariable Long id, @Valid @RequestBody CarRequest carRequest) {
        CarResponse updatedCar = carService.partialUpdateCar(id, carRequest);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
