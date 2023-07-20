package com.jrstudio.paddleluxury.securityGAIA.entities;

import com.jrstudio.paddleluxury.entities.Address;
import com.jrstudio.paddleluxury.entities.Booking;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {

    private String nombre;
    private String apellidos;
    private String nombreUsuario;
    private Address address;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private List<Booking> bookingList;
    private Usuario usuario;

    public UsuarioPrincipal(String nombre, String apellidos, Address address, String email, String password, Collection<? extends GrantedAuthority> authorities, Usuario usuario) {
        this.nombre = nombre;
        this.apellidos = apellidos;

        this.address = address;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.usuario = usuario;
    }

    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                        .getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getApellidos(), usuario.getAddress(), usuario.getEmail(), usuario.getPassword(), authorities, usuario);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Address getAddress() {
        return address;
    }
}
