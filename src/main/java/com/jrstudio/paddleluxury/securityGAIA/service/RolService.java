package com.jrstudio.paddleluxury.securityGAIA.service;

import com.jrstudio.paddleluxury.securityGAIA.entities.Rol;
import com.jrstudio.paddleluxury.securityGAIA.enums.RolNombre;
import com.jrstudio.paddleluxury.securityGAIA.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepository.findByRolNombre(rolNombre);
    }
    public void save(Rol rol) {
        rolRepository.save(rol);
    }
}
