package com.unbunny.carweb.services.interfaces;


import com.unbunny.carweb.dto.ManufacturerResponse;
import com.unbunny.carweb.models.cars.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<ManufacturerResponse> getAllManufacturers();
}
