package com.jrstudio.paddleluxury.repositories;

import com.jrstudio.paddleluxury.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsById(Long id);
    Optional<Booking> findByDate(String date);
    boolean existsByDate(String date);

}