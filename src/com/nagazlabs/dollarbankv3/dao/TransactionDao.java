package com.nagazlabs.dollarbankv3.dao;

import java.util.List;

import com.nagazlabs.dollarbankv3.enums.AccountType;
import com.nagazlabs.dollarbankv3.models.abstracts.Transaction;

public interface TransactionDao {

	public Transaction getById(int id);
	public List<Transaction> getByCustomerAndType(int customerId, AccountType type);
	public void delete(Transaction t);
	public void create(Transaction t);
	public void update(Transaction t);
}
