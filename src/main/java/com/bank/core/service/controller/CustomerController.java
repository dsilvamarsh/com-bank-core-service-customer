package com.bank.core.service.controller;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.core.service.model.Customer;
import com.bank.core.service.repository.CustomerRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerController {

	private CustomerRepository repo;

	@PostMapping("/customer")
	public String save(Customer cust) {
		
		repo.save(cust);
		return "completed";
	}

}
