package banking;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Balance extends JFrame implements ActionListener
{
	Image i2;
	String pin;
	JLabel label, text;
	JButton back;
	ImageIcon i1, i3;
	
	Balance(String pin)
	{
		this.pin = pin;
		setTitle("BANKING-MANAGEMENT-SYSTEM - BALANCE ENQUIRY");
		setLayout(null);
		
		i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		i3 = new ImageIcon(i2);
		label = new JLabel(i3);
		label.setBounds(0 , 0, 900, 900);
		add(label);
		
		back = new JButton("Back");
		back.setFont(new Font("Owward", Font.ITALIC,14));
		back.setBounds(520, 350, 150, 30);
		back.setBackground(Color.CYAN);
		back.setForeground(Color.BLUE);
		back.addActionListener(this);
		label.add(back);
		
		Connect c = new Connect();
		int balance = 0;
		try
		{
			ResultSet rs = c.s.executeQuery("select * from treasury where pin = '"+pin+"'");
			while(rs.next())
			{
				if(rs.getString("type").equals("Deposit"))
				{
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else
				{
					balance -= Integer.parseInt(rs.getString("amount"));

				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		text = new JLabel("Your Current Account Balance is Rs " + balance);
		text.setFont(new Font("Merlin", Font.BOLD,18));
		text.setBounds(236, 170, 580, 50);
		text.setForeground(Color.BLACK);
		label.add(text);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Transaction(pin).setVisible(true);
	}
	public static void main(String[] args)
	{
		new Balance("").setVisible(true);
	}
}