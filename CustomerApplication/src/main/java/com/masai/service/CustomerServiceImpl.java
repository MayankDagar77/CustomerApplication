package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo cRepo;
	
	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		
		List<Customer> allCustomers = cRepo.findAll();
		
		if(allCustomers.size()==0) {
			throw new CustomerException("Customers record is empty");
		}
		else{
			return allCustomers;
		}
	}

	@Override
	public Customer getCustomerById(Integer cid) throws CustomerException {
		
	    return cRepo.findById(cid).orElseThrow(()-> new CustomerException("No customer found with this customer id") );
	}

	@Override
	public Customer addCustomer(Customer customer){
		
		return cRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Integer cid, Customer customer) throws CustomerException {
		
		Optional<Customer> opt = cRepo.findById(cid);
		
		if(opt.isPresent()) {
		   return cRepo.save(customer);
		}
		else {
		   throw new CustomerException("No customer found with this customer id");	
		}
	}

	@Override
	public Customer deleteCustomer(Integer cid) throws CustomerException{
	    
		Optional<Customer> opt = cRepo.findById(cid);
	    
	    Customer customerFound = opt.get();
		
	    if(opt.isPresent()) {
		   cRepo.deleteById(cid);
		   return customerFound;
		}
		else{
		   throw new CustomerException("No customer found with this customer id");	
		}
		
	}
	
	

}
