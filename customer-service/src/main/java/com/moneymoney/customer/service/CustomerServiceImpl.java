package com.moneymoney.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneymoney.customer.bean.Customer;
import com.moneymoney.customer.dao.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	/* (non-Javadoc)
	 * @see com.moneymoney.customer.service.CustomerService#addCustomer(com.moneymoney.customer.bean.Customer)
	 */
	@Override
	public void addCustomer(Customer customer) {
		repository.save(customer);
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.customer.service.CustomerService#viewAll()
	 */
	@Override
	public List<Customer> viewAll(){
		return repository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.moneymoney.customer.service.CustomerService#update(com.moneymoney.customer.bean.Customer)
	 */
	@Override
	public void update(Customer customer) {
		repository.save(customer);
	}
}
