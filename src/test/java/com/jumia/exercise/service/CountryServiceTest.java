package com.jumia.exercise.service;

import com.jumia.exercise.model.CountryCodeEnum;
import com.jumia.exercise.model.Customer;
import com.jumia.exercise.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @MockBean
    private CustomerRepository repository;

    private static List<Customer> customerList;

    @BeforeAll
    static void init() {
        // Setup mock repository
        customerList = new ArrayList<>();
        // Valid
        customerList.add(Customer.builder().name("Yosaf Karrouch").phone("(212) 698054317").build());
        customerList.add(Customer.builder().name("JACKSON NELLY").phone("(256) 775069443").build());
        customerList.add(Customer.builder().name("VINEET SETH").phone("(256) 704244430").build());
        // Not valid
        customerList.add(Customer.builder().name("SUGAR STARRK BARRAGAN").phone("(237) 6780009592").build());
    }

    @Test
    @DisplayName("Test Find All Customers Success")
    void testAllCustomers() {
        doReturn(customerList).when(repository).findAll();
        // Execute getAllCustomers service call
        List<Customer> returnedCustomerList = countryService.getAllCustomers();
        // Assert the response
        Assertions.assertFalse(returnedCustomerList.isEmpty(), "Customer List was not found");
        Assertions.assertSame(returnedCustomerList.size(), customerList.size(), "The Customer List returned was not the same size as the mock");
    }

    @Test
    @DisplayName("Test Find All Customers By Country Success")
    void getCustomersByCountry() {
        doReturn(customerList).when(repository).findAll();
        // Execute getCustomersByCountry service call
        List<Customer> returnedCustomerList = countryService.getCustomersByCountry(CountryCodeEnum.UGANDA.getCode());
        // Assert the response
        Assertions.assertFalse(returnedCustomerList.isEmpty(), "Customer List was not found");
        Assertions.assertSame(returnedCustomerList.size(), 2, "The Customer List returned was not the same size as the mock");
    }

    @Test
    @DisplayName("Test Find All InvalidNumbers Success")
    void getInvalidNumbers() {
        doReturn(customerList).when(repository).findAll();
        // Execute getCustomersByCountry service call
        List<Customer> returnedCustomerList = countryService.getInvalidNumbers();
        // Assert the response
        Assertions.assertFalse(returnedCustomerList.isEmpty(), "Invalid Numbers List was not found");
        Assertions.assertSame(returnedCustomerList.size(), 1, "The Invalid Numbers List returned was not the same size as the mock");
    }

}
