package com.crudapi.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class Controller {

    @Autowired
    private Services service;

    // To get all the details
    @GetMapping("/findAll")
    public ResponseEntity<List<Customer>> getDetails() {
        List<Customer> list = service.getAllDetails();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    // GET SINGLE CUSTOMER BASED ON ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Customer> getDetail(@PathVariable("id") String id) {
        Optional<Customer> customer = service.getDetailById(id);
        if (customer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(customer.get());
    }

    // CREATE A NEW CUSTOMER
    @PostMapping
    public ResponseEntity<Customer> addDetails(@RequestBody Customer customer) {
        try {
            Customer savedCustomer = service.addDetail(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // DELETE CUSTOMER
    @DeleteMapping("/delete/{customer_details_Id}")
    public ResponseEntity<Void> deleteDetails(@PathVariable("customer_details_Id") String id) {
        try {
            service.deleteDetail(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // UPDATE DETAILS
    @PutMapping("/update/{customer_details_Id}")
    public ResponseEntity<Customer> updateDetails(@RequestBody Customer customer, @PathVariable("customer_details_Id") String id) {
        try {
            Customer updatedCustomer = service.updateDetail(customer, id);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
