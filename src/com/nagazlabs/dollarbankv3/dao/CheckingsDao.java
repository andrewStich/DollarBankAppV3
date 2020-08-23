package com.nagazlabs.dollarbankv3.dao;

import com.nagazlabs.dollarbankv3.enums.AccountType;
import com.nagazlabs.dollarbankv3.models.CheckingAccount;

public interface CheckingsDao {
	
	public CheckingAccount getById(int id);
	public CheckingAccount getbyCustomerAndType(int customerId, AccountType type);
	public void delete(CheckingAccount a);
	public void create(CheckingAccount a);
	public void update(CheckingAccount a);
}
