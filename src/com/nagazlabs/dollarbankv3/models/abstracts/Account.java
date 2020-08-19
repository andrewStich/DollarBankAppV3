package com.nagazlabs.dollarbankv3.models.abstracts;

import com.nagazlabs.dollarbankv3.enums.AccountType;

public abstract class Account {
	private int id;
	private int customerId;
	private float balance;
	private AccountType type;

	public Account() {

	}

	public Account(int id, int customerId, float balance, AccountType type) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.balance = balance;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

}
