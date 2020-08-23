package com.nagazlabs.dollarbankv3.models.abstracts;

import com.nagazlabs.dollarbankv3.enums.AccountType;

public abstract class Transaction {
	private int id;
	private int customerId;
	private int accountId;
	private float amount;
	private float startBalance;
	private float endBalance;
	private AccountType type;

	public Transaction() {

	}

	public Transaction(int id, int customerId, int accountId, float amount, float startBalance, float endBalance,
			AccountType type) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.accountId = accountId;
		this.amount = amount;
		this.startBalance = startBalance;
		this.endBalance = endBalance;
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

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(float startBalance) {
		this.startBalance = startBalance;
	}

	public float getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(float endBalance) {
		this.endBalance = endBalance;
	}

	public AccountType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", customerId=" + customerId + ", accountId=" + accountId + ", amount="
				+ amount + ", startBalance=" + startBalance + ", endBalance=" + endBalance + ", type=" + type + "]";
	}

}
