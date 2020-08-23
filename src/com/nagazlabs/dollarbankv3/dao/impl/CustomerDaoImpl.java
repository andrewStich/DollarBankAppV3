package com.nagazlabs.dollarbankv3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nagazlabs.dollarbankv3.connections.ConnectionFactory;
import com.nagazlabs.dollarbankv3.dao.CustomerDao;
import com.nagazlabs.dollarbankv3.models.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer getById(int id) {
		Connection conn = ConnectionFactory.getConnection();

		try {
			Customer c = new Customer();
			PreparedStatement stmt = conn.prepareStatement("select * from customers where id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("firstname"));
				c.setLastName(rs.getString("lastname"));
				c.setUserName(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setEmail(rs.getString("email"));
			}
			return c;
		} catch (Exception e) {
			System.out.println("Could not retrieve Customer by ID");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getByUserName(String username) {
		Connection conn = ConnectionFactory.getConnection();

		try {
			Customer c = new Customer();
			PreparedStatement stmt = conn.prepareStatement("select * from customers where username = ?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("firstname"));
				c.setLastName(rs.getString("lastname"));
				c.setUserName(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setEmail(rs.getString("email"));
			}
			return c;
		} catch (Exception e) {
			System.out.println("Could not retrieve Customer by username");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Customer c) {
		Connection conn = ConnectionFactory.getConnection();

		try {
			PreparedStatement stmt = conn.prepareStatement("delete from customers where id = ?");
			stmt.setInt(1, c.getId());
			stmt.execute();
		} catch (Exception e) {
			System.out.println("Error deleteing Customer");
			e.printStackTrace();
		}

	}

	@Override
	public void create(Customer c) {
		Connection conn = ConnectionFactory.getConnection();

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"Insert into customers (firstname, lastname, username, password, email) values (?, ?, ?, ?, ?)");
			stmt.setString(1, c.getFirstName());
			stmt.setString(2, c.getLastName());
			stmt.setString(3, c.getUserName());
			stmt.setString(4, c.getPassword());
			stmt.setString(5, c.getEmail());
			stmt.execute();
		} catch (Exception e) {
			System.out.println("Error creating Customer");
			e.printStackTrace();
		}

	}

	@Override
	public void update(Customer c) {
		Connection conn = ConnectionFactory.getConnection();

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"update customer set firstname=?, lastname=?, username=?, password=?, email=? where id=?");
			stmt.setString(1, c.getFirstName());
			stmt.setString(2, c.getLastName());
			stmt.setString(3, c.getUserName());
			stmt.setString(4, c.getPassword());
			stmt.setString(5, c.getEmail());
			stmt.setInt(6, c.getId());
			stmt.execute();
		} catch (Exception e) {
			System.out.println("Error creating Customer");
			e.printStackTrace();
		}

	}

}
