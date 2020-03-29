package com.rest.example.bootstrap;

import com.rest.example.domain.Vendor;
import com.rest.example.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private VendorRepository vendorRepository;

    public Bootstrap(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadVendors();
    }

    private void loadVendors(){
        Vendor vendorOne = new Vendor();
        vendorOne.setName("Adidas");

        Vendor vendorTwo = new Vendor();
        vendorTwo.setName("Adidas1");

        Vendor vendorThree = new Vendor();
        vendorThree.setName("Adidas2");

        Vendor vendorFour = new Vendor();
        vendorFour.setName("Adidas3");

        Vendor vendorFive = new Vendor();
        vendorFive.setName("Adidas4");

        vendorRepository.save(vendorOne);
        vendorRepository.save(vendorTwo);
        vendorRepository.save(vendorThree);
        vendorRepository.save(vendorFour);
        vendorRepository.save(vendorFive);

        System.out.println("Vendor loaded" + vendorRepository.count());
    }
}
