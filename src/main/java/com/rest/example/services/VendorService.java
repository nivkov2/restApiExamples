package com.rest.example.services;

import com.rest.example.domain.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VendorService {

    List<Vendor> findAllVendors();

    Vendor findByName(String name);

    Vendor saveVendor(Long id, Vendor vendor);

    Vendor patchVendor(Long id, Vendor vendor);

    void deleteVendor(Long id);
}
