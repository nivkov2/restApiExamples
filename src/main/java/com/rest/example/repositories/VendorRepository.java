package com.rest.example.repositories;

import com.rest.example.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{

    Vendor findByName(String name);
}
