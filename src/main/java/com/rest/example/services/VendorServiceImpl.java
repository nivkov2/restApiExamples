package com.rest.example.services;

import com.rest.example.domain.Vendor;
import com.rest.example.repositories.VendorRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    private VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<Vendor> findAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendor findByName(String name) {
        return vendorRepository.findByName(name);
    }

    @Override
    public Vendor saveVendor(Long id, Vendor vendor) {
        vendor.setId(id);
        return vendorRepository.save(vendor);
    }

    @Override
    public Vendor patchVendor(Long id, Vendor vendor) {
        return vendorRepository.findById(id).map( vendorToUpdate -> {
            if(vendor.getName() != null){
                vendorToUpdate.setName(vendor.getName());
            }
            return vendorRepository.save(vendorToUpdate);
        }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
