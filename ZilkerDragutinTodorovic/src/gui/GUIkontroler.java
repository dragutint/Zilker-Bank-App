package gui;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import klase.Account;
import klase.Bank;
import util.DataLoader;
import util.Database;

public class GUIkontroler {
	public static Bank sys;
	public static GUI frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database db = new Database("jdbc:mysql://localhost:3306/zilkerdragutin", "root", "");
					
//					String path1 = args[0];
//					String path2 = args[1];
					String path1 = "C:\\Users\\Dragutin Todorovic\\Desktop\\accounts.csv";
					String path2 = "C:\\Users\\Dragutin Todorovic\\Desktop\\transactions.csv";
					
					sys = new Bank(DataLoader.getAccounts(path1));
					sys.setAccounts(); 	

					sys.setTransactions(DataLoader.getTransactions(path2));
					sys.doTransactions();
															
					System.out.println("All clear!");
					
					frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void transfer(Object accFrom, Object accTo, double amount) {
		Account af = (Account) accFrom;
		Account at = (Account) accTo;
		
		if(sys.transaction(af.getId(), at.getId(), amount)) {
			JOptionPane.showMessageDialog(GUIkontroler.frame, "The transaction is succesfull!");
		} else {
			JOptionPane.showMessageDialog(GUIkontroler.frame, "Account from doesn't have enough money for transaction");
		}
	}
	
}
