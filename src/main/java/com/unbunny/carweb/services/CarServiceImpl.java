package com.unbunny.carweb.services;


import com.unbunny.carweb.dto.CarRequest;
import com.unbunny.carweb.dto.CarResponse;
import com.unbunny.carweb.dto.filters.CarFilterRequest;
import com.unbunny.carweb.mappers.CarImageMapper;
import com.unbunny.carweb.mappers.CarMapper;
import com.unbunny.carweb.models.cars.Car;
import com.unbunny.carweb.repositories.CarRepository;
import com.unbunny.carweb.repositories.specifications.CarSpecifications;
import com.unbunny.carweb.services.interfaces.CarService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final CarImageMapper imageMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper, CarImageMapper imageMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
        this.imageMapper = imageMapper;
    }

    @Override
    public List<CarResponse> getCarsByFilter(CarFilterRequest filterRequest) {
        Specification<Car> spec = Specification.where(null);
        if (filterRequest.getCategorySlug() != null) {
            spec = spec.and(CarSpecifications.hasCategorySlug(filterRequest.getCategorySlug()));
        }
        if (filterRequest.getManufacturerSlug() != null) {
            spec = spec.and(CarSpecifications.hasManufacturerSlug(filterRequest.getManufacturerSlug()));
        }
        if (filterRequest.getYearFrom() != null) {
            spec = spec.and(CarSpecifications.yearGreaterThanOrEqualTo(filterRequest.getYearFrom()));
        }
        if (filterRequest.getYearTo() != null) {
            spec = spec.and(CarSpecifications.yearLessThanOrEqualTo(filterRequest.getYearTo()));
        }
        Sort sort = getSort(filterRequest.getSort());
        Pageable pageable = PageRequest.of(filterRequest.getPage(), filterRequest.getSize(), sort);

        return carRepository.findAll(spec, pageable)
                .stream()
                .map(carMapper::toCarResponse)
                .toList();
    }

    @Override
    public CarResponse getCarById(Long id) {
        if (carRepository.findById(Math.toIntExact(id)).isEmpty()) {
            return null;
        }
        return carMapper.toCarResponse(carRepository.findById(Math.toIntExact(id)).get());
    }

    @Override
    public CarResponse createCar(CarRequest carRequest) {
        Car car = carMapper.toCar(carRequest);
        Car savedCar = carRepository.save(car);
        return carMapper.toCarResponse(savedCar);
    }

    @Override
    public CarResponse updateCar(Long id, CarRequest carRequest) {
        return null;
    }

    @Override
    public CarResponse partialUpdateCar(Long id, CarRequest carRequest) {
        return null;
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(Math.toIntExact(id));
    }

    private Sort getSort(String sortKey) {
        if (sortKey == null) return Sort.unsorted();
        return switch (sortKey) {
            case "priceAsc" -> Sort.by("price").ascending();
            case "priceDesc" -> Sort.by("price").descending();
            case "yearAsc" -> Sort.by("year").ascending();
            case "yearDesc" -> Sort.by("year").descending();
            default -> Sort.unsorted();
        };
    }

}
