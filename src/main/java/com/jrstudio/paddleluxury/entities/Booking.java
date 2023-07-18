package com.jrstudio.paddleluxury.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "RESERVAS")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@JsonFormat(pattern = "dd/MM/YYYY HH:mm")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIO", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    // CONSTRUCTORS
    public Booking() {
    }
    public Booking(String date) {
        this.date = date;
    }

    // GETTERS
    public Long getId() {
        return id;
    }
    public String getDate() {
        return date;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

