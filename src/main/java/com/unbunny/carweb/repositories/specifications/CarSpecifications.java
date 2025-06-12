package com.unbunny.carweb.repositories.specifications;

import com.unbunny.carweb.models.cars.Car;
import org.springframework.data.jpa.domain.Specification;

public class CarSpecifications {
    public static Specification<Car> hasManufacturerSlug(String slug) {
        return (root, query, cb) -> cb.equal(root.join("manufacturer").get("slug"), slug);
    }

    public static Specification<Car> hasCategorySlug(String slug) {
        return (root, query, cb) -> cb.equal(root.join("categories").get("slug"), slug);
    }

    public static Specification<Car> yearGreaterThanOrEqualTo(Integer year) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("year"), year);
    }

    public static Specification<Car> yearLessThanOrEqualTo(Integer year) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("year"), year);
    }
}
