package banking;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Withdrawl extends JFrame implements ActionListener
{
	Image i2;
	String pin;
	JLabel label, text;
	JButton withdraw, back;
	ImageIcon i1,i3;
	JTextField number;
	
	Withdrawl(String pin)
	{
		this.pin = pin;
	   	setTitle("BANKING-MANAGEMENT-SYSTEM - WITHDRAWL");
	   	setLayout(null);
		
		i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		i3 = new ImageIcon(i2);
		label = new JLabel(i3);
		label.setBounds(0 , 0, 900, 900);
		add(label);
		
		text = new JLabel("Enter the amount you want to withdraw");
		text.setFont(new Font("Merlin", Font.BOLD,18));
		text.setBounds(290, 150, 350, 50);
		text.setForeground(Color.BLACK);
		label.add(text);
		
		number = new JTextField();
		number.setFont( new Font("Ariel", Font.BOLD, 22));
		number.setBounds(300, 205, 310, 30);
		add(number);
		
		withdraw = new JButton("Withdrawl");
		withdraw.setFont(new Font("Owward", Font.ITALIC,14));
		withdraw.setBounds(520, 290, 150, 30);
		withdraw.setBackground(Color.CYAN);
		withdraw.setForeground(Color.BLUE);
		withdraw.addActionListener(this);
		label.add(withdraw);
		
		back = new JButton("Back");
		back.setFont(new Font("Owward", Font.ITALIC,14));
		back.setBounds(520, 350, 150, 30);
		back.setBackground(Color.CYAN);
		back.setForeground(Color.BLUE);
		back.addActionListener(this);
		label.add(back);
		
		setSize(900, 900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == withdraw)
		{
			String amount = number.getText();
			Date date = new Date();
			if(amount.equals(""))
			{
	    		JOptionPane.showMessageDialog(null, "Please enter the amount your want to withdraw");

			}
			else
			{
				try
				{
					Connect c = new Connect();
					String query = "insert into treasury values ('"+pin+"', '"+date+"', 'Withdrawl' , '"+amount+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+amount+" Credited Successfully");
					setVisible(false);
					new Transaction(pin).setVisible(true);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		else if(ae.getSource() == back)
		{
			setVisible(false);
			new Transaction(pin).setVisible(true);
		}
	}
	public static void main(String[] args)
	{
		new Withdrawl("");
	}
}