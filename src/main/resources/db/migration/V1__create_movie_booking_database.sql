1. DATABASE CREATION:-
=======================

CREATE DATABASE IF NOT EXISTS movie_booking_db;

2. DATABASE SELECT
========================

USE movie_booking_db;

3. TABLE CREATION:movies
===========================

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

INSERT  movie_id,
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


5. TABLE CREATION:theatres
=========================

CREATE TABLE theatres (
                          theatre_id BIGINT PRIMARY KEY,
                          theatre_name VARCHAR(255) NOT NULL,
                          city VARCHAR(100) NOT NULL,
                          address VARCHAR(500),
                          is_active BOOLEAN DEFAULT TRUE
);


6.DATA INSERTION
===========================

 INSERT INTO theatres (
    theatre_id,
    theatre_name,
    city,
    address,
    is_active
)
VALUES
(1, 'PVR Orion Mall', 'Bangalore', 'Rajajinagar, Bangalore', TRUE),
(2, 'INOX Forum Mall', 'Bangalore', 'Koramangala, Bangalore', TRUE),
(3, 'Cinepolis Banjara Hills', 'Hyderabad', 'Banjara Hills, Hyderabad', TRUE);


7. TABLE CREATION:screens
===============================

CREATE TABLE screens (
                         screen_id BIGINT PRIMARY KEY,
                         theatre_id BIGINT NOT NULL,
                         screen_name VARCHAR(100) NOT NULL,
                         total_seats INT,
                         FOREIGN KEY (theatre_id) REFERENCES theatres(theatre_id)
);

8.DATA INSERTION:screens
===============================

INSERT INTO screens (
    screen_id,
    theatre_id,
    screen_name,
    total_seats
)
VALUES
(101, 1, 'Screen 1', 150),
(102, 1, 'Screen 2', 120),
(103, 2, 'Screen 1', 180),
(104, 3, 'Screen 1', 200);


9. TABLE CREATION:shows
===============================

CREATE TABLE shows (
                       show_id BIGINT PRIMARY KEY,
                       movie_id BIGINT NOT NULL,
                       theatre_id BIGINT NOT NULL,
                       screen_id BIGINT NOT NULL,
                       show_date DATE NOT NULL,
                       show_time TIME NOT NULL,
                       ticket_price DECIMAL(10,2),
                       available_seats INT,
                       FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
                       FOREIGN KEY (theatre_id) REFERENCES theatres(theatre_id),
                       FOREIGN KEY (screen_id) REFERENCES screens(screen_id)
);

10. TABLE CREATION:shows
===============================

INSERT INTO shows (
    show_id,
    movie_id,
    theatre_id,
    screen_id,
    show_date,
    show_time,
    ticket_price,
    available_seats
)
VALUES
    (1001, 101, 1, 101, '2026-04-20', '10:00:00', 250.00, 120),
    (1002, 101, 1, 102, '2026-04-20', '14:00:00', 300.00, 100),
    (1003, 101, 2, 103, '2026-04-20', '18:00:00', 350.00, 140),
    (1004, 102, 3, 104, '2026-04-20', '16:00:00', 280.00, 180);