package com.nagazlabs.dollarbankv3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nagazlabs.dollarbankv3.connections.ConnectionFactory;
import com.nagazlabs.dollarbankv3.dao.TransactionDao;
import com.nagazlabs.dollarbankv3.enums.AccountType;
import com.nagazlabs.dollarbankv3.models.CheckingTransaction;
import com.nagazlabs.dollarbankv3.models.SavingsTransaction;
import com.nagazlabs.dollarbankv3.models.abstracts.Transaction;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public Transaction getById(int id) {
		Connection conn = ConnectionFactory.getConnection();
		Transaction t = null;

		try {
			PreparedStatement stmt = conn.prepareStatement("select * from transactions where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(AccountType.CHECKING.equals(rs.getObject("type"))) {
					t = new CheckingTransaction();
					t.setAccountId(rs.getInt("id"));
					t.setCustomerId(rs.getInt("customer_id"));
					t.setAccountId(rs.getInt("account_id"));
					t.setAmount(rs.getFloat("amount"));
					t.setStartBalance(rs.getFloat("start_balance"));
					t.setEndBalance(rs.getFloat("end_balance"));
				} else if(AccountType.SAVINGS.equals(rs.getObject("type"))) {
					t = new SavingsTransaction();
					t.setAccountId(rs.getInt("id"));
					t.setCustomerId(rs.getInt("customer_id"));
					t.setAccountId(rs.getInt("account_id"));
					t.setAmount(rs.getFloat("amount"));
					t.setStartBalance(rs.getFloat("start_balance"));
					t.setEndBalance(rs.getFloat("end_balance"));
				} else {
					System.out.println("Unknown account type");
				}
			}
			return t;
		} catch (Exception e) {
			System.out.println("Error getting Transaction by id");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Transaction> getByCustomerAndType(int customerId, AccountType type) {
		Connection conn = ConnectionFactory.getConnection();
		Transaction t = null;
		List<Transaction> transList = new ArrayList<Transaction>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from transaction where customer_id = ? and type = ? order by desc");
			stmt.setInt(1, customerId);
			stmt.setObject(2, type);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(AccountType.CHECKING.equals(rs.getObject("type"))) {
					t = new CheckingTransaction();
					t.setAccountId(rs.getInt("id"));
					t.setCustomerId(rs.getInt("customer_id"));
					t.setAccountId(rs.getInt("account_id"));
					t.setAmount(rs.getFloat("amount"));
					t.setStartBalance(rs.getFloat("start_balance"));
					t.setEndBalance(rs.getFloat("end_balance"));
				} else if(AccountType.SAVINGS.equals(rs.getObject("type"))) {
					t = new SavingsTransaction();
					t.setAccountId(rs.getInt("id"));
					t.setCustomerId(rs.getInt("customer_id"));
					t.setAccountId(rs.getInt("account_id"));
					t.setAmount(rs.getFloat("amount"));
					t.setStartBalance(rs.getFloat("start_balance"));
					t.setEndBalance(rs.getFloat("end_balance"));
				} else {
					System.out.println("Unknown account type");
				}
				transList.add(t);
			}
			
			return transList;
		} catch (Exception e) {
			System.out.println("Error getting all user account transactions");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Transaction t) {
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from transactions where id=?");
			stmt.setInt(1, t.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error deleting transaction");
			e.printStackTrace();
		}

	}

	@Override
	public void create(Transaction t) {
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into transactions (customer_id, account_id, amount, start_balance, end_balance, type) values (?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, t.getCustomerId());
			stmt.setInt(2, t.getAccountId());
			stmt.setFloat(3, t.getAmount());
			stmt.setFloat(4, t.getStartBalance());
			stmt.setFloat(5, t.getEndBalance());
			stmt.setObject(6, t.getType().toString());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error creating transaction");
			e.printStackTrace();
		}

	}

	@Override
	public void update(Transaction t) {
Connection conn = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("update transactions set customer_id=?, account_id=?, amount=?, start_balance=?, end_balance=?, type=? where id=?");
			stmt.setInt(1, t.getCustomerId());
			stmt.setInt(2, t.getAccountId());
			stmt.setFloat(3, t.getAmount());
			stmt.setFloat(4, t.getStartBalance());
			stmt.setFloat(5, t.getEndBalance());
			stmt.setObject(6, t.getType().toString());
			stmt.setInt(7, t.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error updating transaction");
			e.printStackTrace();
		}

	}

}
