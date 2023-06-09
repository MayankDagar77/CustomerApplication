package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers() throws CustomerException;
	
	public Customer getCustomerById(Integer cid) throws CustomerException;
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Integer cid,Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(Integer cid) throws CustomerException;	

}
