package banking;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Mini extends JFrame implements ActionListener
{
	String pin;
	JLabel label, mini, card, balance;
	JButton back;

	Mini(String pin)
	{
		this.pin = pin;
		setTitle("BMS - Mini Statement ");
		setLayout(null);
		
		balance = new JLabel();
		balance.setBounds(50 , 400, 300, 30);
		add(balance);
		
		mini = new JLabel();
		mini.setBounds(20, 140, 400, 200);
		add(mini);
		
		label = new JLabel("De Bank");
		label.setFont(new Font("Merlin", Font.BOLD,28));
		label.setBounds(130 , 80, 300, 30);
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);
		add(label);
		
		card = new JLabel();
		card.setBounds(20 , 100, 300, 30);
		add(card);
		
		try
		{
			Connect c = new Connect();
			ResultSet rs = c.s.executeQuery("select * from login where pin = ''"+pin+"'");
			while(rs.next())
			{
				card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(11));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try
		{
			Connect c = new Connect();
			int balan = 0;
			ResultSet rs = c.s.executeQuery("select * from treasury where pin = '"+pin+"'");
			while(rs.next())
			{
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
				if(rs.getString("type").equals("Deposit"))
				{
					balan += Integer.parseInt(rs.getString("amount"));
				}
				else
				{
					balan -= Integer.parseInt(rs.getString("amount"));

				}
			}
			balance.setText("Your Current Account Balance is Rs " + balan);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		back = new JButton("Back");
		back.setFont(new Font("Owward", Font.ITALIC,14));
		back.setBounds(20, 530, 80, 30);
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.BLACK);
		back.addActionListener(this);
		add(back);
		
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(400, 600);
		setLocation(30,30);
		// setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(true);
		new Transaction(pin).setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Mini("").setVisible(true);
	}
}