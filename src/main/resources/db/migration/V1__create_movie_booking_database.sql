1. DATABASE CREATION:-
=======================

CREATE DATABASE IF NOT EXISTS movie_booking_db;

2. DATABASE SELECT
========================

USE movie_booking_db;

3. DATABASE CREATION
========================

CREATE TABLE movies (
                        movie_id BIGINT PRIMARY KEY,
                        movie_name VARCHAR(255) NOT NULL,
                        language VARCHAR(100) NOT NULL,
                        genre VARCHAR(100) NOT NULL,
                        duration_in_minutes INT NOT NULL,
                        release_date DATE NOT NULL,
                        rating DECIMAL(2,1),
                        city VARCHAR(100) NOT NULL
);

4. DATA INSERTION
========================

INSERT INTO movies (
    movie_id,
    movie_name,
    language,
    genre,
    duration_in_minutes,
    release_date,
    rating,
    city
)
VALUES
    (101, 'Jawan', 'HINDI', 'ACTION', 170, '2026-04-10', 8.5, 'Bangalore'),
    (102, 'Leo', 'TAMIL', 'ACTION', 160, '2026-04-05', 8.2, 'Bangalore'),
    (103, 'KGF Chapter 2', 'KANNADA', 'ACTION', 168, '2026-03-20', 9.0, 'Bangalore'),
    (104, 'Pushpa', 'TELUGU', 'ACTION', 175, '2026-04-01', 8.7, 'Hyderabad'),
    (105, 'Drishyam', 'HINDI', 'THRILLER', 145, '2026-02-15', 8.9, 'Mumbai');
