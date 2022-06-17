package com.bank.core.service.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.core.service.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
