package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import klase.Account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtFldAmount;
	public static JComboBox comboBoxFrom = new JComboBox();
	public static JComboBox comboBoxTo = new JComboBox();
	public JButton btnTransfer = new JButton("Transfer");

	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountFrom = new JLabel("Account from");
		lblAccountFrom.setBounds(66, 50, 100, 16);
		contentPane.add(lblAccountFrom);
		
		JLabel lblAccountTo = new JLabel("Account to");
		lblAccountTo.setBounds(66, 90, 100, 16);
		contentPane.add(lblAccountTo);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(66, 132, 56, 16);
		contentPane.add(lblAmount);
		
		comboBoxFrom.setBounds(178, 47, 106, 22);
		contentPane.add(comboBoxFrom);
		
		comboBoxTo.setBounds(178, 87, 106, 22);
		contentPane.add(comboBoxTo);
		
		txtFldAmount = new JTextField();
		txtFldAmount.setBounds(178, 129, 106, 22);
		contentPane.add(txtFldAmount);
		txtFldAmount.setColumns(10);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double amount;
				
				try {
					amount = Double.parseDouble(txtFldAmount.getText());
					GUIkontroler.transfer(comboBoxFrom.getSelectedItem(), comboBoxTo.getSelectedItem(), amount);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(GUIkontroler.frame, "Amount is not valid!");
				}
				
			}
		});
		btnTransfer.setBounds(66, 178, 218, 25);
		contentPane.add(btnTransfer);
		
		updateBoxes(GUIkontroler.sys.getAccounts());
	}
	
	private void updateBoxes(LinkedList<Account> acc) {
		for(Account a : acc) {
			comboBoxFrom.addItem(a);
			comboBoxTo.addItem(a);
		}
	}
}
