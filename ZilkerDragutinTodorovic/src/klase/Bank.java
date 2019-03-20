package klase;

import java.nio.channels.AcceptPendingException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import gui.GUIkontroler;
import util.Database;

public class Bank {
	private LinkedList<Account> accounts;
	private LinkedList<Transaction> transactions;
	
	public Bank() {
	}
	
	public Bank(LinkedList<Account> a, LinkedList<Transaction> t) {
		this.accounts = a;
		this.transactions = t;
	}	

	public Bank(LinkedList<Account> a) {
		this.accounts = a;
	}
	
	public void logAccounts() {
		for (Account acc : accounts) {
			System.out.println(acc);
		}	
	}
	
	public void logTransactions() {
		for (Transaction t: transactions) {
			System.out.println(t);
		}	
	}
	
	public void setAccounts() {
		for (Account acc : accounts) {
			Database.addAccount(acc);
		}
		
		for (Account acc : accounts) {
			acc.setId(Database.getID(acc.getName()));
		}
	}
	
	public void doTransactions() {
		for (Transaction t: transactions) {
			transaction(t.getFrom_id(), t.getTo_id(), t.getAmount());
		}
		transactions.clear();
	}
	
	public boolean transaction(int from_id, int to_id, double amount) {
		Account accFrom = getAccByID(from_id);
		Account accTo = getAccByID(to_id);
		int status = 0;
		boolean ret = false;
		
		if(accFrom.getBalance() >= amount) {
			accTo.increaseBalance(amount);
			accFrom.decreaseBalance(amount);
			status = 1;
			ret = true;
			Database.updateAccount(accFrom);
			Database.updateAccount(accTo);
		}
		
		Transaction trans = new Transaction(from_id, to_id, amount, status);
		Database.addTransaction(trans);		
		
		return ret;
	}
	
	private Account getAccByID(int id) {
		for (Account acc : accounts) {
			if(acc.getId() == id) {
				return acc;
			}
		}	
		return null;
	}
	
	private Transaction getTraByID(int id) {
		for (Transaction tra : transactions) {
			if(tra.getId() == id) {
				return tra;
			}
		}	
		return null;
	}
	
	// getters and setters
	
	public LinkedList<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(LinkedList<Account> accounts) {
		this.accounts = accounts;
	}
	
	public LinkedList<Transaction> getTransactions() {
		return transactions;
	}
	
	public void setTransactions(LinkedList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}
