package com.bean.DAO;

import java.util.List;

import com.bean.Entity.Customer;

public interface Customer_DAO {

	/* Get an individual user from the database */
	public Customer getCustomer(int id);

	/* Get all the customers and return list */
	public List<Customer> getCustomers();

	/* Save an individual customer and return a success string */
	public String saveCustomer(Customer customer);

	/* Delete customer */
	public String deleteCustomer(int id);

}
