package com.anuradha.demo.controller;

import com.anuradha.demo.model.Customer;
import com.anuradha.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-10-10
 * @project - heroku-repo
 **/
@CrossOrigin
@RestController
@RequestMapping("customer")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("save")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        LOGGER.info("request  - customer/save | saveCustomer | payload : {}", customer);
        customerRepository.save(customer);
        LOGGER.info("response - customer/save | saveCustomer | success");
        return new ResponseEntity<>("Customer saved", HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        LOGGER.info("request  - customer/getAll | getAll");
        List<Customer> all = customerRepository.findAll();
        LOGGER.info("response - customer/getAll | getAll | payload : {}", all);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
