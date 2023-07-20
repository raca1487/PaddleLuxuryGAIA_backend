package com.jrstudio.paddleluxury.repositories;

import com.jrstudio.paddleluxury.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    boolean existsById(Long id);
    Optional<Address> findByBuilding(String building);
    Optional<Address> findByFloor(String floor);
    boolean existsByBuilding(String building);
    boolean existsByFloor(String floor);
}
