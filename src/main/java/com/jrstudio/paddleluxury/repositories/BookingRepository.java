package com.jrstudio.paddleluxury.repositories;

import com.jrstudio.paddleluxury.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsById(Long id);
    Optional<Booking> findByReservationDate(LocalDateTime reservationDate);
    boolean existsByReservationDate(LocalDateTime reservationDate);

}