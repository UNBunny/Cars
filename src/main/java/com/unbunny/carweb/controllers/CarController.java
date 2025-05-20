package com.unbunny.carweb.controllers;


import com.unbunny.carweb.dto.CarResponse;
import com.unbunny.carweb.models.cars.Car;
import com.unbunny.carweb.services.interfaces.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/category/{categorySlug}")
    public ResponseEntity<List<CarResponse>> getCarsByCategory(@PathVariable String categorySlug, @RequestParam(required = false) String sort) {
        return ResponseEntity.ok(carService.getCarsByCategory(categorySlug, sort));
    }

}
