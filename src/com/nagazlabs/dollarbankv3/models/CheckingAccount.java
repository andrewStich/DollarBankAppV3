package com.nagazlabs.dollarbankv3.models;

import com.nagazlabs.dollarbankv3.enums.AccountType;
import com.nagazlabs.dollarbankv3.models.abstracts.Account;

public class CheckingAccount extends Account {

	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(int id, int customerId, float balance) {
		super(id, customerId, balance, AccountType.CHECKING);
	}

}
