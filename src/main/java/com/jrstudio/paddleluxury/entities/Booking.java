package com.jrstudio.paddleluxury.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jrstudio.paddleluxury.securityGAIA.entities.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVAS")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/YYYY HH:mm")
    private LocalDateTime reservationDate, applicationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIO", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    // CONSTRUCTORS
    public Booking() {
    }
    public Booking(LocalDateTime reservationDate) {
        this.applicationDate = LocalDateTime.now();
        this.reservationDate = reservationDate;
    }

    // GETTERS
    public Long getId() {
        return id;
    }
    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
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

