package com.anuradha.demo.repository;

import com.anuradha.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author - Anuradha Ranasinghe on 2020-10-10
 * @project - heroku-repo
 **/
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
