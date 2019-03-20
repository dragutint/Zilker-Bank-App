package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import javax.xml.crypto.Data;

import klase.Account;
import klase.Transaction;

public class DataLoader {
	public static LinkedList<Account> getAccounts(String pathToAccountsCSV) {
		LinkedList<Account> accounts = new LinkedList<Account>();
		Path pathToFile = Paths.get(pathToAccountsCSV);

		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();

			while (line != null) {
				String[] attributes = line.split(";");
				String name = attributes[0];
				double amount = Double.parseDouble(attributes[1]);
				Account account = new Account(name, amount);
				
				accounts.add(account);

				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return accounts;
	}

	public static LinkedList<Transaction> getTransactions(String pathToTransactionsCSV) {
		LinkedList<Transaction> tra = new LinkedList<Transaction>();
		
		Path pathToFile = Paths.get(pathToTransactionsCSV);

		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();

			while (line != null) {
				String[] attributes = line.split(";");
				String nameFrom = attributes[0];
				String nameTo = attributes[1];
				double amount = Double.parseDouble(attributes[2]);
				
				int idFrom = 0; 
				int idTo = 0;
				
				idFrom = Database.getID(nameFrom);
				idTo = Database.getID(nameTo);
				
				Transaction transaction = new Transaction(idFrom, idTo, amount);
				
				tra.add(transaction);

				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return tra;
	}
}
