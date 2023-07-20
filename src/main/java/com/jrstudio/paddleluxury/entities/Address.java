package com.jrstudio.paddleluxury.entities;

import com.jrstudio.paddleluxury.securityGAIA.entities.Usuario;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String building;
    private String floor;
    private String door;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Usuario.class, mappedBy = "address", orphanRemoval = true)
    private List<Usuario> usuarios;

    public Address() {
    }
    public Address(String building, String floor, String door) {
        this.building = building;
        this.floor = floor;
        this.door = door;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Usuario> getUsers() {
        return usuarios;
    }

    public void addUser(Usuario usuario) {
        getUsers().add(usuario);
        usuario.setAddress(this);
    }
}
