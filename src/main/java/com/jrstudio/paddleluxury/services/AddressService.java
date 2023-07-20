package com.jrstudio.paddleluxury.services;

import com.jrstudio.paddleluxury.entities.Address;
import com.jrstudio.paddleluxury.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> addressList() {
        return addressRepository.findAll();
    }
    public Optional<Address> getOne(Long id) {
        return addressRepository.findById(id);
    }
    public Optional<Address> getByBuilding(String building) {
        return addressRepository.findByBuilding(building);
    }
    public Optional<Address> getByFloor(String floor) {
        return addressRepository.findByFloor(floor);
    }

    public void save(Address address) {
        addressRepository.save(address);
    }
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return addressRepository.existsById(id);
    }
    public boolean existsByBuilding(String building) {
        return addressRepository.existsByBuilding(building);
    }
    public boolean existsByFloor(String floor) {
        return addressRepository.existsByFloor(floor);
    }

}
