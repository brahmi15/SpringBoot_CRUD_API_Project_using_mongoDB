package com.crudapi.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableMongoRepositories
public interface MongoRepo extends MongoRepository<Customer,String> {
    Optional<Customer> findById(String id);
}
