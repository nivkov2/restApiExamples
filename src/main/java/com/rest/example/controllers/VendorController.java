package com.rest.example.controllers;

import com.rest.example.domain.Vendor;
import com.rest.example.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/vendor")
public class VendorController {

    private VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors(){
        return new ResponseEntity<>(vendorService.findAllVendors(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Vendor> getVendorByName(@PathVariable String name){
        return new ResponseEntity<>(vendorService.findByName(name), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor vendor){
        return new ResponseEntity<>(vendorService.saveVendor(id, vendor), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Vendor> patchVendor(@PathVariable Long id, @RequestBody Vendor vendor){
        return new ResponseEntity<>(vendorService.patchVendor(id, vendor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id){
        vendorService.deleteVendor(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
