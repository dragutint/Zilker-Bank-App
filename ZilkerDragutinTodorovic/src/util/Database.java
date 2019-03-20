package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import klase.Account;
import klase.Transaction;

public class Database {
	private static Connection con;
	
	public Database(String path, String user, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(path, user, pass);
			
			java.sql.PreparedStatement stmt;
			
			String query;

			query = "delete from account";
			stmt = con.prepareStatement(query);
			stmt.execute();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getAccounts() {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from account");
			
			while (rs.next())
				System.out.println(rs.getInt("id") + "  " + rs.getString("name") + "  " + rs.getString("balance"));
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static boolean addAccount(Account a) {
		java.sql.PreparedStatement stmt;
		try {
			String query = "insert into account(name, balance) values('"+ a.getName() + "','" + a.getBalance() + "');";
			stmt = con.prepareStatement(query);
			if(stmt.execute()) 
				return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;  
	}
	
	
	public static boolean addTransaction(Transaction t) {
		java.sql.PreparedStatement stmt;
		try {
			String query = "insert into transaction(from_id, to_id, amount, status) values(" + t.getFrom_id() + ", " + t.getTo_id() + "," + t.getAmount() + ", " + t.getStatus() + ");";
			stmt = con.prepareStatement(query);
			if(stmt.execute()) 
				return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	     
	}
	
	
	public static int getID(String name) {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM account WHERE name = '" + name + "' ;");
			
			int id = 0;
			rs.next();
			id = rs.getInt("id");
			return id;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public static boolean updateAccount(Account a) {
		java.sql.PreparedStatement stmt;
		try {
			String query = "update account set balance = " + a.getBalance() + " where name = '" + a.getName() + "' ;";
			stmt = con.prepareStatement(query);
			if(stmt.execute()) 
				return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;  
	}
}	
