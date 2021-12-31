package com.jumia.exercise.repository;

import com.jumia.exercise.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
