package com.jrstudio.paddleluxury.dto;

import com.jrstudio.paddleluxury.securityGAIA.entity.Usuario;

import javax.validation.constraints.NotBlank;

public class BookingDTO {

    @NotBlank
    private String date;

    private Usuario usuario;

    public BookingDTO() {
    }
    public BookingDTO(@NotBlank String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
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
