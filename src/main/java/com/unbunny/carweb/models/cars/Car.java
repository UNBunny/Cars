package com.unbunny.carweb.models.cars;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "body_type_id")
    private BodyType bodyType;

    @ManyToOne
    @JoinColumn(name = "engine_type_id")
    private EngineType engineType;

    private Integer powerHp;
    private Double batteryCapacityKwh;
    private Integer rangeKm;

    @Column(name = "acceleration_0_100")
    private Double acceleration0100;
    private Integer topSpeedKmh;
    private Double price;

    @Column(nullable = false)
    private String mainImageUrl;

    private String description;
    private Integer views = 0;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(nullable = false, unique = true)
    private String slug;

    @OneToMany(mappedBy = "car")
    private List<CarImage> images;

    @OneToMany(mappedBy = "car")
    private List<CarFeature> features;

    @ManyToMany
    @JoinTable(
            name = "car_categories",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}