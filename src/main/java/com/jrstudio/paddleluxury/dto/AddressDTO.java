package com.jrstudio.paddleluxury.dto;

import com.jrstudio.paddleluxury.securityGAIA.entities.Usuario;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class AddressDTO {

    @NotBlank
    private String building;
    @NotBlank
    private String floor;
    @NotBlank
    private String door;
    private List<Usuario> usuarios;

    public AddressDTO() {
    }

    public AddressDTO(@NotBlank String building, @NotBlank String floor, @NotBlank String door) {
        this.building = building;
        this.floor = floor;
        this.door = door;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
