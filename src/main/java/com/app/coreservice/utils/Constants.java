package com.app.coreservice.constants;

public interface Constants {

    // Movie related
    String BROWSE_MOVIES = "/browse-movies";
    String GET_MOVIES = "";
    String GET_MOVIE_BY_ID = "/{movieId}";

    // Theatre related
    String BROWSE_THEATRES = "/browse-theatres";
    String GET_THEATRES = "";

    // Show related
    String BROWSE_SHOWS = "/browse-shows";
    String GET_SHOWS = "";
    String GET_SHOW_BY_ID = "/{showId}";
    String GET_SHOW_SEATS = "/{showId}/seats";

    // Booking related
    String BOOKINGS = "/bookings";
    String CREATE_BOOKING = "";
    String GET_BOOKING_BY_ID = "/{bookingId}";
    String CANCEL_BOOKING = "/{bookingId}";

    // Payment related
    String PAYMENTS = "/payments";
    String INITIATE_PAYMENT = "/initiate";
    String CONFIRM_PAYMENT = "/confirm";
}