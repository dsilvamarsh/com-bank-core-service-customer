package com.bank.core.service.controller;

import java.util.Optional;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.core.service.model.Customer;
import com.bank.core.service.service.CustomerService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@AllArgsConstructor
@Data
public class CustomerController {


	private CustomerService service;

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> find(@NotNull(message = "ID cannot be null") @PathVariable(name = "id") UUID id) throws Exception {
		Optional<Customer> tmp;
		log.debug("Finding customer with id:"+id);
		tmp = service.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(tmp.get());
	}
	@PostMapping("/customer")
	public String save(@RequestBody(required = true)Customer cust) throws Exception {
		log.debug("Creating New customer");
		service.save(cust);
		
		return "completed";
	}
	@DeleteMapping("/customer/{id}")
	public String delete(@NotNull(message = "ID cannot be null") @PathVariable("id") UUID id) throws Exception {
		log.debug("Deleting customer with id:"+id);
		service.deleteById(id);
		
		return "completed";
	}

}
