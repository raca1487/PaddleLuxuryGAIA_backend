package com.jrstudio.paddleluxury.controllers;

import com.jrstudio.paddleluxury.dto.AddressDTO;
import com.jrstudio.paddleluxury.dto.Message;
import com.jrstudio.paddleluxury.entities.Address;
import com.jrstudio.paddleluxury.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public ResponseEntity<List<Address>> list() {
        List<Address> list = addressService.addressList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Address> getById(@PathVariable("id") long id) {
        if(!addressService.existsById(id))
            return new ResponseEntity(new Message("Address NO exists"), HttpStatus.NOT_FOUND);
        Address address = addressService.getOne(id).get();
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AddressDTO addressDTO, @AuthenticationPrincipal UserDetails userDetails) {
        Address address = new Address(addressDTO.getBuilding(), addressDTO.getFloor(), addressDTO.getDoor());

        addressService.save(address);
        return new ResponseEntity(new Message("Address created"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!addressService.existsById(id))
            return new ResponseEntity(new Message("Address NO exists"), HttpStatus.NOT_FOUND);
        addressService.delete(id);
        return new ResponseEntity(new Message("Address deleted"), HttpStatus.OK);
    }
}
