package com.nagazlabs.dollarbankv3.models;

import com.nagazlabs.dollarbankv3.enums.AccountType;
import com.nagazlabs.dollarbankv3.models.abstracts.Transaction;

public class SavingsTransaction extends Transaction {

	public SavingsTransaction() {
		super();
	}

	public SavingsTransaction(int id, int customerId, int accountId, float amount, float startBalance,
			float endBalance) {
		super(id, customerId, accountId, amount, startBalance, endBalance, AccountType.SAVINGS);
	}

}
