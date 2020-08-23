package com.nagazlabs.dollarbankv3.models;

import com.nagazlabs.dollarbankv3.enums.AccountType;
import com.nagazlabs.dollarbankv3.models.abstracts.Account;

public class CheckingAccount extends Account {

	private AccountType type = AccountType.CHECKING;
	
	public CheckingAccount() {
		super();
	}

	public CheckingAccount(int id, int customerId, float balance) {
		super(id, customerId, balance);
	}
	
	public AccountType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "SavingsAccount [type=" + type + ", getId()=" + getId() + ", getCustomerId()=" + getCustomerId()
				+ ", getBalance()=" + getBalance() + ", toString()=" + super.toString() + "]";
	}

}
