package com.unbunny.carweb.services.interfaces;


import com.unbunny.carweb.dto.CarResponse;
import com.unbunny.carweb.models.cars.Car;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface CarService {
    public List<CarResponse> getCarsByCategory(String categorySlug, String sort);

    public List<Car> getCarsByManufacturer(String manufacturerSlug, String sort);

    public List<Car> getCarsByFilters(String categorySlug, String manufacturerSlug,
                                      Integer yearFrom, Integer yearTo, String sort);

    public Car getCarById(Long id);

    public void incrementCarViews(Long carId);

}
