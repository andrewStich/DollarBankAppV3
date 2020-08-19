package com.nagazlabs.dollarbankv3.models;

import com.nagazlabs.dollarbankv3.enums.AccountType;
import com.nagazlabs.dollarbankv3.models.abstracts.Account;

public class SavingsAccount extends Account {

	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(int id, int customerId, float balance) {
		super(id, customerId, balance, AccountType.SAVINGS);
	}
}
