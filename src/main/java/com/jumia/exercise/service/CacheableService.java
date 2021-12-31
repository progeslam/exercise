package com.jumia.exercise.service;

import com.jumia.exercise.model.CountryCodeEnum;
import com.jumia.exercise.model.Customer;
import com.jumia.exercise.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CacheableService {

    private CustomerRepository customerRepository;

    /**
     * Retrieve All customers list from the database and cache the result to the memory for future operations
     * @return List<Customer>
     */
    @Cacheable("customerList")
    public List<Customer> getCustomerList() {
        List<Customer> customersList = new ArrayList();
        customerRepository.findAll().forEach(customer -> {
            if (Arrays.stream(CountryCodeEnum.values()).noneMatch(code -> UtilService.validateNumbers(customer.getPhone(), code)))
                customer.setIsInvalid(Boolean.TRUE);
            customersList.add(customer);
        });
        return customersList;
    }
}
