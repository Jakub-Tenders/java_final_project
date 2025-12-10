CREATE TABLE IF NOT EXISTS users (
    id_user SERIAL PRIMARY KEY,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    address TEXT,
    email VARCHAR(100),
    phone VARCHAR(20),
    birthdate DATE
);

CREATE TABLE IF NOT EXISTS clients (
    num_passport VARCHAR(20) PRIMARY KEY,
    id_user INT REFERENCES users(id_user)
);

CREATE TABLE IF NOT EXISTS employees (
    num_emp SERIAL PRIMARY KEY,
    profession VARCHAR(50),
    title VARCHAR(50),
    id_user INT REFERENCES users(id_user)
);

CREATE TABLE IF NOT EXISTS planes (
    id_plane SERIAL PRIMARY KEY,
    brand VARCHAR(50),
    model VARCHAR(50),
    manufacturing_year INT
);

CREATE TABLE IF NOT EXISTS airports (
    id_airport SERIAL PRIMARY KEY,
    name_airport VARCHAR(100),
    country_airport VARCHAR(100),
    city_airport VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS flights (
    id_flight SERIAL PRIMARY KEY,
    plane_id INT REFERENCES planes(id_plane),
    departure_airport INT REFERENCES airports(id_airport),
    arrival_airport INT REFERENCES airports(id_airport),
    departure_time TIMESTAMP,
    arrival_time TIMESTAMP
);

CREATE TABLE IF NOT EXISTS bookings (
    id_booking SERIAL PRIMARY KEY,
    lastname VARCHAR(50),
    firstname VARCHAR(50),
    passport_number VARCHAR(50),
    birthdate DATE,
    flight_id INT REFERENCES flights(id_flight)
);

CREATE TABLE IF NOT EXISTS miles_reward (
    id_reward SERIAL PRIMARY KEY,
    passport_number VARCHAR(50),
    flights_this_year INT DEFAULT 0,
    discount_code VARCHAR(20)
);
