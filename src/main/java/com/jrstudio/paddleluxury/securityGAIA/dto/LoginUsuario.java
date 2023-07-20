package com.jrstudio.paddleluxury.securityGAIA.dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {

    /*@NotBlank
    private String nombreUsuario;*/
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    /*public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
