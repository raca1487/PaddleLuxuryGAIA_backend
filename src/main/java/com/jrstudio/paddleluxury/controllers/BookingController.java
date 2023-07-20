package com.jrstudio.paddleluxury.controllers;

import com.jrstudio.paddleluxury.dto.BookingDTO;
import com.jrstudio.paddleluxury.dto.Message;
import com.jrstudio.paddleluxury.entities.Booking;
import com.jrstudio.paddleluxury.securityGAIA.entities.Usuario;
import com.jrstudio.paddleluxury.securityGAIA.entities.UsuarioPrincipal;
import com.jrstudio.paddleluxury.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/list")
    public ResponseEntity<List<Booking>> list() {
        List<Booking> list = bookingService.bookingList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Booking> getById(@PathVariable("id") long id) {
        if(!bookingService.existsById(id))
            return new ResponseEntity(new Message("Booking NO exists"), HttpStatus.NOT_FOUND);
        Booking booking = bookingService.getOne(id).get();
        return new ResponseEntity(booking, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BookingDTO bookingDTO, @AuthenticationPrincipal UserDetails userDetails) {
        if (bookingDTO.getReservationDate() == null)
            return new ResponseEntity(new Message("Reservation date is mandatory"), HttpStatus.BAD_REQUEST);

        if (bookingService.existsByReservationDate(bookingDTO.getReservationDate()))
            return new ResponseEntity(new Message("Date is booked"), HttpStatus.BAD_REQUEST);

        Booking booking = new Booking(bookingDTO.getReservationDate());

        // Get the user from the UserDetails object
        Usuario usuario = ((UsuarioPrincipal) userDetails).getUsuario();
        booking.setUsuario(usuario);

        bookingService.save(booking);
        return new ResponseEntity(new Message("Booking created"), HttpStatus.OK);
    }

    /*@PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BookingDTO bookingDTO){
        if(StringUtils.isBlank(bookingDTO.getDate()))
            return new ResponseEntity(new Message("Reservation date is mandatory"), HttpStatus.BAD_REQUEST);

        if(bookingService.existsByDate(bookingDTO.getDate()))
            return new ResponseEntity(new Message("Date is booked"), HttpStatus.BAD_REQUEST);
        Booking booking = new Booking(bookingDTO.getDate());
        bookingService.save(booking);
        return new ResponseEntity(new Message("Booking created"), HttpStatus.OK);
    }*/


    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!bookingService.existsById(id))
            return new ResponseEntity(new Message("Booking NO exists"), HttpStatus.NOT_FOUND);
        bookingService.delete(id);
        return new ResponseEntity(new Message("Booking deleted"), HttpStatus.OK);
    }

}
