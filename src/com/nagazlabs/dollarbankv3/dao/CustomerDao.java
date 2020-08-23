package com.nagazlabs.dollarbankv3.dao;

import com.nagazlabs.dollarbankv3.models.Customer;

public interface CustomerDao {

	public Customer getById(int id);
	public Customer getByUserName(String username);
	public void delete(Customer c);
	public void create(Customer c);
	public void update(Customer c);
}
