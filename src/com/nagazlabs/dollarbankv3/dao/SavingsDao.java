package com.nagazlabs.dollarbankv3.dao;

import com.nagazlabs.dollarbankv3.enums.AccountType;
import com.nagazlabs.dollarbankv3.models.SavingsAccount;

public interface SavingsDao {

	public SavingsAccount getById(int id);
	public SavingsAccount getbyCustomerAndType(int customerId, AccountType type);
	public void delete(SavingsAccount a);
	public void create(SavingsAccount a);
	public void update(SavingsAccount a);
}
