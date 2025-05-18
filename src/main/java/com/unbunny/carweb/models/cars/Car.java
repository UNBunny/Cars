package com.unbunny.carweb.models.cars;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @Column(nullable = false, length = 100)
    private String model;

    @Column(nullable = false)
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "body_type_id", nullable = false)
    private BodyType bodyType;

    @ManyToOne
    @JoinColumn(name = "engine_type_id", nullable = false)
    private EngineType engineType;

    private Integer powerHp;

//    @Column(name = "battery_capacity_kwh", precision = 5, scale = 1)
    private Double batteryCapacityKwh;

    @Column(name = "range_km")
    private Integer rangeKm;

    @Column(name = "acceleration_0_100")
    private Double acceleration0100;

    @Column(name = "top_speed_kmh")
    private Integer topSpeedKmh;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "main_image_url", nullable = false, length = 255)
    private String mainImageUrl;

    @Lob
    private String description;

    @Column(columnDefinition = "integer default 0")
    private Integer views = 0;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

}
