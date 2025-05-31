package com.unbunny.carweb.services;


import com.unbunny.carweb.dto.ManufacturerResponse;
import com.unbunny.carweb.mappers.CarMapper;
import com.unbunny.carweb.models.cars.Manufacturer;
import com.unbunny.carweb.repositories.ManufacturerRepository;
import com.unbunny.carweb.services.interfaces.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final CarMapper carMapper;

    @Override
    public List<ManufacturerResponse> getAllManufacturers() {
        return manufacturerRepository.findAll()
                .stream()
                .map(carMapper::toManufacturerResponse)
                .toList();
    }
}
