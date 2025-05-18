CREATE TABLE categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    slug VARCHAR(50) NOT NULL UNIQUE
);

-- Таблица типов кузова
CREATE TABLE body_types
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    slug VARCHAR(50) NOT NULL UNIQUE
);

-- Таблица типов двигателей
CREATE TABLE engine_types
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    slug VARCHAR(50) NOT NULL UNIQUE
);

-- Таблица производителей (брендов)
CREATE TABLE manufacturers
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    logo_url     VARCHAR(255),
    description  TEXT,
    founded_year INT,
    country      VARCHAR(50),
    slug         VARCHAR(100) NOT NULL UNIQUE
);

-- Таблица автомобилей
CREATE TABLE cars
(
    id                   SERIAL PRIMARY KEY,
    manufacturer_id      INTEGER REFERENCES manufacturers (id),
    model                VARCHAR(100) NOT NULL,
    year                 INTEGER      NOT NULL,
    body_type_id         INTEGER REFERENCES body_types (id),
    engine_type_id       INTEGER REFERENCES engine_types (id),
    power_hp             INTEGER,
    battery_capacity_kwh DECIMAL(5, 1),
    range_km             INTEGER,
    acceleration_0_100   DECIMAL(4, 1),
    top_speed_kmh        INTEGER,
    price                DECIMAL(10, 2),
    main_image_url       VARCHAR(255) NOT NULL, -- Добавлено поле для основного изображения
    description          TEXT,
    views                INTEGER   DEFAULT 0,
    created_at           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    slug                 VARCHAR(150) NOT NULL UNIQUE
);

-- Таблица дополнительных изображений автомобилей
CREATE TABLE car_images
(
    id        SERIAL PRIMARY KEY,
    car_id    INTEGER REFERENCES cars (id),
    image_url VARCHAR(255) NOT NULL,
    is_main   BOOLEAN DEFAULT FALSE,
    alt_text  VARCHAR(100)
);

-- Таблица характеристик автомобилей
CREATE TABLE car_features
(
    id            SERIAL PRIMARY KEY,
    car_id        INTEGER REFERENCES cars (id),
    feature_name  VARCHAR(100) NOT NULL,
    feature_value VARCHAR(255) NOT NULL
);

-- Связь многие-ко-многим между автомобилями и категориями
CREATE TABLE car_categories
(
    car_id      INTEGER REFERENCES cars (id),
    category_id INTEGER REFERENCES categories (id),
    PRIMARY KEY (car_id, category_id)
);

