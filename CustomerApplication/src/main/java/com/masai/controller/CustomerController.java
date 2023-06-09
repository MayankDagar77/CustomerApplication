package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
//@RequestMapping("/CustomerApp")
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerException{
		
		List<Customer> allCustomers = cService.getAllCustomers();
		
		return new ResponseEntity<List<Customer>>(allCustomers,HttpStatus.OK);
	}
	
	@GetMapping("/customers/{cid}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("cid") Integer cid) throws CustomerException{
		
		Customer customer = cService.getCustomerById(cid);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		
		Customer newCustomer = cService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers/{cid}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("cid") Integer cid,@RequestBody Customer customer) throws CustomerException{
		
		Customer updatedCustomer = cService.updateCustomer(cid, customer);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{cid}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("cid") Integer cid)  throws CustomerException{
		
		Customer customerDeleted = cService.deleteCustomer(cid);
		
		return new ResponseEntity<Customer>(customerDeleted,HttpStatus.OK);
	}

}
