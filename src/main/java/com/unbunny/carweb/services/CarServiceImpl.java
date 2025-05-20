package com.unbunny.carweb.services;


import com.unbunny.carweb.dto.CarResponse;
import com.unbunny.carweb.mappers.CarMapper;
import com.unbunny.carweb.models.cars.Car;
import com.unbunny.carweb.repositories.CarRepository;
import com.unbunny.carweb.services.interfaces.CarService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private static final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public List<CarResponse> getCarsByCategory(String categorySlug, String sort) {
        // Получаем список автомобилей по slug категории
        List<Car> cars = carRepository.findByCategorySlug(categorySlug);

        // Преобразуем каждый Car в CarResponse
        List<CarResponse> responses = cars.stream()
                .map(carMapper::toCarResponse)
                .collect(Collectors.toList());

        // Сортируем если нужно (предполагая что sortCars принимает List<CarResponse>)
        return responses;
    }

    @Override
    public List<Car> getCarsByManufacturer(String manufacturerSlug, String sort) {
        return List.of();
    }

    @Override
    public List<Car> getCarsByFilters(String categorySlug, String manufacturerSlug, Integer yearFrom, Integer yearTo, String sort) {
        return List.of();
    }

    @Override
    public Car getCarById(Long id) {
        return null;
    }

    @Override
    public void incrementCarViews(Long carId) {

    }

    public List<Car> sortCars(List<Car> cars, String sort) {
        log.info("Sorting cars: " + cars);
        return cars;
    }
}
