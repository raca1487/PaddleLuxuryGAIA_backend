package com.jrstudio.paddleluxury.dto;

import com.jrstudio.paddleluxury.securityGAIA.entities.Usuario;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class BookingDTO {

    @NotBlank
    private LocalDateTime reservationDate;

    private Usuario usuario;

    public BookingDTO() {
    }
    public BookingDTO(@NotBlank LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
