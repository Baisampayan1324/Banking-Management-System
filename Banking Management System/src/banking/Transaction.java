package banking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener
{
	Image i2;
	String pin;
	JLabel label, text;
	JButton deposit, cashw, fcash, mini, pinchange, balance, exit, accountclosed;
	ImageIcon i1, i3;
	Transaction(String pin)
	{
		this.pin = pin;
		setLayout(null);
   	
		i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		i3 = new ImageIcon(i2);
		label = new JLabel(i3);
		label.setBounds(0 , 0, 900, 900);
		add(label);
	
		text = new JLabel("Please select your Transaction");
		text.setFont(new Font("Merlin", Font.BOLD,18));
		text.setBounds(310, 120, 280, 50);
		text.setForeground(Color.BLACK);
		label.add(text);
	
		deposit = new JButton("Deposit");
		deposit.setFont(new Font("Owward", Font.ITALIC,14));
		deposit.setBounds(236, 180, 150, 30);
		deposit.setBackground(Color.CYAN);
		deposit.setForeground(Color.BLUE);
		deposit.addActionListener(this);
		label.add(deposit);
	
		cashw = new JButton("Cash Withdrawl");
		cashw.setFont(new Font("Owward", Font.ITALIC,14));
		cashw.setBounds(520, 180, 150, 30);
		cashw.setBackground(Color.CYAN);
		cashw.setForeground(Color.BLUE);
		cashw.addActionListener(this);
		label.add(cashw);
	
		fcash = new JButton("Fast Cash");
		fcash.setFont(new Font("Owward", Font.ITALIC,14));
		fcash.setBounds(236, 235, 150, 30);
		fcash.setBackground(Color.CYAN);
		fcash.setForeground(Color.BLUE);
		fcash.addActionListener(this);
		label.add(fcash);
	
		mini = new JButton("Mini Statement");
		mini.setFont(new Font("Owward", Font.ITALIC,14));
		mini.setBounds(520, 235, 150, 30);
		mini.setBackground(Color.CYAN);
		mini.setForeground(Color.BLUE);
		mini.addActionListener(this);
		label.add(mini);
	
		pinchange = new JButton("Pin Change");
		pinchange.setFont(new Font("Owward", Font.ITALIC,14));
		pinchange.setBounds(236, 290, 150, 30);
		pinchange.setBackground(Color.CYAN);
		pinchange.setForeground(Color.BLUE);
		pinchange.addActionListener(this);
		label.add(pinchange);
	
		accountclosed = new JButton("Account Closed");
		accountclosed.setFont(new Font("Owward", Font.ITALIC,14));
		accountclosed.setBounds(236, 350, 150, 30);
		accountclosed.setBackground(Color.CYAN);
		accountclosed.setForeground(Color.BLUE);
		accountclosed.addActionListener(this);
		label.add(accountclosed);
		
		balance = new JButton("Balance Enquiry");
		balance.setFont(new Font("Owward", Font.ITALIC,14));
		balance.setBounds(520, 290, 150, 30);
		balance.setBackground(Color.CYAN);
		balance.setForeground(Color.BLUE);
		balance.addActionListener(this);
		label.add(balance);
	
		exit = new JButton("Exit");
		exit.setFont(new Font("Owward", Font.ITALIC,14));
		exit.setBounds(520, 350, 150, 30);
		exit.setBackground(Color.CYAN);
		exit.setForeground(Color.BLUE);
		exit.addActionListener(this);
		label.add(exit);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == exit)
			{
				System.exit(0);
			}
			else if(ae.getSource() == deposit)
			{
				setVisible(false);;
				new Deposit(pin).setVisible(true);
			}
			else if(ae.getSource() == cashw)
			{
				setVisible(false);;
				new Withdrawl(pin).setVisible(true);
			}
			else if(ae.getSource() == fcash)
			{
				setVisible(false);
				new FastCash(pin).setVisible(true);
			}
			else if(ae.getSource() == pinchange)
			{
				setVisible(false);
				new PinChange(pin).setVisible(true);
			}
			else if(ae.getSource() == balance)
			{
				setVisible(false);
				new Balance(pin).setVisible(true);
			}
			else if(ae.getSource() == mini)
			{
				new Mini(pin).setVisible(true);
			}
			else if(ae.getSource() == accountclosed)
			{
				 new AccountClosed().setVisible(true);
			}
		}
	public static void main(String[] args)
	{
		new Transaction("");
	}
}