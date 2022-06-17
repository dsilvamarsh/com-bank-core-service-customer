package com.bank.core.service.service;

import java.util.Optional;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.core.service.constants.ExceptionConstants;
import com.bank.core.service.constants.SuccessConstants;
import com.bank.core.service.model.Customer;
import com.bank.core.service.repository.CustomerRepository;

import lombok.Data;
import lombok.extern.log4j.Log4j2;


@Data
@Log4j2
@Service
public class CustomerService {

	
	@Autowired
	private CustomerRepository repo;

	public Optional<Customer> findById(@NotNull(message = "ID cannot be null") Long id) throws Exception {
		Optional<Customer> tmp = null;
		try {

			tmp = repo.findById(id);

		} catch (Exception e) {
			log.error(ExceptionConstants.EXCEPTION, e);
			throw new Exception(ExceptionConstants.EXCEPTION_DB_FIND);
		}
		return tmp;

	}

	public Customer save(Customer cust) throws Exception {
		Customer tmp = null;
		try {
			//generate the UUID using the jave util
			cust.setId(12548);
			tmp = repo.save(cust);
		} catch (Exception e) {
			log.error(ExceptionConstants.EXCEPTION, e);
			throw new Exception(ExceptionConstants.EXCEPTION_DB_INSERT);
		}
		return tmp;

	}

	public String deleteById(@NotNull(message = "ID cannot be null") Long id) throws Exception {
	
		try {
			
			repo.deleteById(id);
			
		}catch (Exception e) {
			
			log.error(ExceptionConstants.EXCEPTION, e);
			throw new Exception(ExceptionConstants.EXCEPTION_DB_DELETE);
			
		}
		return SuccessConstants.RECORD_CREATED;
		
	}

}
