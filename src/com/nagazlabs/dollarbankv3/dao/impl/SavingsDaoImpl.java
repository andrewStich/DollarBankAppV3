package com.nagazlabs.dollarbankv3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nagazlabs.dollarbankv3.connections.ConnectionFactory;
import com.nagazlabs.dollarbankv3.dao.SavingsDao;
import com.nagazlabs.dollarbankv3.enums.AccountType;
import com.nagazlabs.dollarbankv3.models.SavingsAccount;

public class SavingsDaoImpl implements SavingsDao {

	@Override
	public SavingsAccount getById(int id) {
		Connection conn = ConnectionFactory.getConnection();
		SavingsAccount a = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from accounts where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				a = new SavingsAccount();
				a.setId(rs.getInt("id"));
				a.setCustomerId(rs.getInt("customer_id"));
				a.setBalance(rs.getFloat("balance"));
			}
			
			return a;
		} catch (Exception e) {
			System.out.println("Error getting account by id");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SavingsAccount getbyCustomerAndType(int customerId, AccountType type) {
		Connection conn = ConnectionFactory.getConnection();
		SavingsAccount a = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from accounts where customer_id=? and type=?");
			stmt.setInt(1, customerId);
			stmt.setObject(2, type);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				a = new SavingsAccount();
				a.setId(rs.getInt("id"));
				a.setCustomerId(rs.getInt("customer_id"));
				a.setBalance(rs.getFloat("balance"));
			}
			
			return a;
		} catch (Exception e) {
			System.out.println("Error getting customers account");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(SavingsAccount a) {
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from accounts where id=?");
			stmt.setInt(1, a.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error deleting account");
			e.printStackTrace();
		}
	}

	@Override
	public void create(SavingsAccount a) {
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into accounts (customer_id, balance, type) values (?, ?, ?)");
			stmt.setInt(1, a.getCustomerId());
			stmt.setFloat(2, a.getBalance());
			stmt.setObject(3, a.getType().toString());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error creating account");
			e.printStackTrace();
		}
	}

	@Override
	public void update(SavingsAccount a) {
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("update accounts set customer_id=?, balance=?, type=? where id=?");
			stmt.setInt(1, a.getCustomerId());
			stmt.setFloat(2, a.getBalance());
			stmt.setObject(3, a.getType().toString());
			stmt.setInt(4, a.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error updating account");
			e.printStackTrace();
		}
	}
}
