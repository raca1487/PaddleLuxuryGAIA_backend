package com.jrstudio.paddleluxury.services;

import com.jrstudio.paddleluxury.entities.Booking;
import com.jrstudio.paddleluxury.repositories.BookingRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> bookingList() {
        return bookingRepository.findAll();
    }
    public Optional<Booking> getOne(long id) {
        return bookingRepository.findById(id);
    }
    public Optional<Booking> getByDate(String date) {
        return bookingRepository.findByDate(date);
    }

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }
    public void delete(long id) {
        bookingRepository.deleteById(id);
    }
    public boolean existsById(long id) {
        return bookingRepository.existsById(id);
    }
    public boolean existsByDate(String date) {
        return bookingRepository.existsByDate(date);
    }
}