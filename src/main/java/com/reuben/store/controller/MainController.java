package com.reuben.store.controller;



import com.reuben.store.exception.ResourceNotFoundException;
import com.reuben.store.model.*;
import com.reuben.store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;


@RestController
public class MainController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @PostMapping("/vendor")
    public Vendor addVendor(@RequestBody Vendor vendor){
        // Saving the Vendor Details
        Vendor v = vendorRepository.save(vendor);
        return v;
    }

    @PostMapping("/customer")
    public Customer addCustomer(
            @RequestBody Customer customer

    ){
        // Saving the Vendor Details
        Customer c = customerRepository.save(customer);
//        System.out.println(c.getId());
        return c;


    }

    @PostMapping("/customer/{customer_id}")
    public Profile updateProfile(@RequestBody Profile profile,
                                 @PathVariable("customer_id") Long customer_id) {
        // Saving the Vendor Details
        Customer c = customerRepository.getOne(customer_id);
        profile.setCustomer(c);
        Profile p = profileRepository.save(profile);
        return p;
//        System.out.println(c.getId());
//        return c;

    }

    @PostMapping("addproduct/{vendor_id}")
    public Product AddProduct(@PathVariable("vendor_id") Long vendor_id,
                              @RequestBody Product product){
        Vendor v = vendorRepository.getOne(vendor_id); //existing record

        product.setVendor(v);
        Product p1 = productRepository.save(product);
        return p1;

    }

    @PostMapping("/customer/product/{customer_id}/{product_id}")
    public ResponseEntity<?> enrollStudentInCourse(
            @PathVariable("customer_id") Long customer_id,
            @PathVariable("product_id") Long product_id
    ){
        //3/10
        //fetch student object from studentID
        Optional<Customer> customer_check = customerRepository.findById(customer_id);
        String str = "" + Optional.empty();
        String str1 = "" + customer_check;
        if(str.equals(str1)){
            ResourceNotFoundException res
                    = new ResourceNotFoundException("CUSTOMER ID NOT FOUND");
            return  new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        Customer c = customerRepository.getOne(customer_id);

        Optional<Product> product_check = productRepository.findById(product_id);
        String str2 = "" + Optional.empty();
        String str3 = "" + product_check;
        if(str2.equals(str3)){
            ResourceNotFoundException res
                    = new ResourceNotFoundException("PRODUCT ID NOT FOUND");
            return  new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        //fetch course object from courseID
        Product p = productRepository.getOne(product_id);

        //attach student and course to enroll object
        Purchase purchase = new Purchase();
        purchase.setCustomer(c);
        purchase.setProduct(p);
        purchase.setDate(LocalDate.now());

        //save enroll object in DB
        Purchase purchase1 =  purchaseRepository.save(purchase);
        return  new ResponseEntity<>(purchase1, HttpStatus.OK);

    }



}



//            @RequestBody ObjectNode objectNode

//
//        String email_id = objectNode.get("email_id").asText();
//        String password = objectNode.get("password").asText();
//        String first_name = objectNode.get("first_name").asText();
//        String last_name = objectNode.get("last_name").asText();
//        String city = objectNode.get("city").asText();
//
//        Profile p = new Profile();
//        p.setCity(city);
//        p.setFirst_name(first_name);
//        p.setLast_name(last_name);
//        Profile p1 = profileRepository.save(p);
//
//        Customer c = new Customer();
//        c.setEmail_id(email_id);
//        c.setPassword(password);
//        c.setProfile(p1);
//
//        Customer c1 = customerRepository.save(c);
//        return c1;



