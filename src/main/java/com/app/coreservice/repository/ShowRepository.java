package com.app.coreservice.repository;

import com.app.coreservice.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findByMovieIdAndShowDate(Long movieId, LocalDate showDate);
}