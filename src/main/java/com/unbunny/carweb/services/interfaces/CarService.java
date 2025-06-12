package com.unbunny.carweb.services.interfaces;


import com.unbunny.carweb.dto.CarRequest;
import com.unbunny.carweb.dto.CarResponse;
import com.unbunny.carweb.dto.filters.CarFilterRequest;

import java.util.List;

public interface CarService {
    List<CarResponse> getCarsByFilter(CarFilterRequest filterRequest);
    CarResponse getCarById(Long id);
    CarResponse createCar(CarRequest carRequest);
    CarResponse updateCar(Long id, CarRequest carRequest);
    CarResponse partialUpdateCar(Long id, CarRequest carRequest);
    void deleteCar(Long id);

}
