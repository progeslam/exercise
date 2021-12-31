package com.jumia.exercise.service;

import com.jumia.exercise.model.CountryCodeEnum;
import com.jumia.exercise.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryService {

    private CacheableService cacheableService;

    /**
     * Retrieve all Customers Data without any filtration
     * @return List<Customer>
     */
    public List<Customer> getAllCustomers() {
        return cacheableService.getCustomerList();
    }

    /**
     * Retrieve all Customers Data according to sent country name as input
     * @param countryName String country name to be filtered by
     * @return List<Customer>
     */
    public List<Customer> getCustomersByCountry(String countryName) {
        List<Customer> customersList = new ArrayList();
        cacheableService.getCustomerList().forEach(customer -> {
            if (UtilService.validateNumbers(customer.getPhone(), CountryCodeEnum.findByCode(countryName)))
                customersList.add(customer);
        });
        return customersList;
    }

    /**
     * Retrieve all Customers that have Invalid phone numbers (that don't match with any pre-config code country regex)
     * @return List<Customer>
     */
    public List<Customer> getInvalidNumbers() {
        // return cacheableService.getCustomerList().stream().filter(customer -> Arrays.stream(CountryCodeEnum.values()).noneMatch(code -> UtilService.validateNumbers(customer.getPhone(), code))).collect(Collectors.toList());
        return cacheableService.getCustomerList().stream().filter(customer -> Boolean.TRUE.equals(customer.getIsInvalid())).collect(Collectors.toList());
    }
}
