package com.nagazlabs.dollarbankv3.models.abstracts;

public abstract class Account {
	private int id;
	private int customerId;
	private float balance;

	public Account() {

	}

	public Account(int id, int customerId, float balance) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.balance = balance;
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

	@Override
	public String toString() {
		return "Account [id=" + id + ", customerId=" + customerId + ", balance=" + balance + "]";
	}

}
