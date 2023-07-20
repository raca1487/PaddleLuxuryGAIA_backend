package com.jrstudio.paddleluxury.securityGAIA.entities;

import com.jrstudio.paddleluxury.entities.Address;
import com.jrstudio.paddleluxury.entities.Booking;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellidos;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS", referencedColumnName = "id", nullable = false)
    private Address address;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Booking.class, mappedBy = "usuario", orphanRemoval = true)
    private List<Booking> bookings;

    public Usuario() {
    }

    public Usuario(@NotNull String nombre, @NotNull String apellidos, @NotNull String nombreUsuario, Address address, @NotNull String email, @NotNull String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
    public void addBooking(Booking booking) {
        getBookings().add(booking);
        booking.setUsuario(this);
    }
}
