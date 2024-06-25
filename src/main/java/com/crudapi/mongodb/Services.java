package com.crudapi.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Services {

    @Autowired
    private MongoRepo mongoRepo;

    // To get all details
    public List<Customer> getAllDetails() {
        return (List<Customer>) mongoRepo.findAll();
    }

    // Get details by ID
    public Optional<Customer> getDetailById(String id) {
        return mongoRepo.findById(id);
    }

    // Adding the customer detail
    public Customer addDetail(Customer customer) {
        customer.setId(UUID.randomUUID().toString().split("-")[0]);
        return mongoRepo.save(customer);
    }

    // Deleting details
    public String deleteDetail(String id) {
        mongoRepo.deleteById(id);
        return id + " entry deleted from dashboard";
    }

    // Update customer details
    public Customer updateDetail(Customer customer, String id) {
        customer.setId(id);
        return mongoRepo.save(customer);
    }
}
