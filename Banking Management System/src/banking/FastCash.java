package banking;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.awt.event.*;

public class FastCash extends JFrame implements ActionListener
{
	Image i2;
	String pin;
	JLabel label, text;
	JButton r1, r2, r3, r4, r5, r6, back;
	ImageIcon i1, i3;
	FastCash(String pin)
	{
		this.pin = pin;
	   	setTitle("BANKING-MANAGEMENT-SYSTEM - FAST CASH");
		setLayout(null);
   	
		i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		i3 = new ImageIcon(i2);
		label = new JLabel(i3);
		label.setBounds(0 , 0, 900, 900);
		add(label);
	
		text = new JLabel("Please Select An Amount");
		text.setFont(new Font("Merlin", Font.BOLD,18));
		text.setBounds(340, 120, 280, 50);
		text.setForeground(Color.BLACK);
		label.add(text);
	
		r1 = new JButton("Rs 500");
		r1.setFont(new Font("Owward", Font.ITALIC,14));
		r1.setBounds(236, 180, 150, 30);
		r1.setBackground(Color.CYAN);
		r1.setForeground(Color.BLUE);
		r1.addActionListener(this);
		label.add(r1);
	
		r2 = new JButton("Rs 1000");
		r2.setFont(new Font("Owward", Font.ITALIC,14));
		r2.setBounds(520, 180, 150, 30);
		r2.setBackground(Color.CYAN);
		r2.setForeground(Color.BLUE);
		r2.addActionListener(this);
		label.add(r2);
	
		r3 = new JButton("Rs 3000");
		r3.setFont(new Font("Owward", Font.ITALIC,14));
		r3.setBounds(236, 235, 150, 30);
		r3.setBackground(Color.CYAN);
		r3.setForeground(Color.BLUE);
		r3.addActionListener(this);
		label.add(r3);
	
		r4 = new JButton("Rs 5000");
		r4.setFont(new Font("Owward", Font.ITALIC,14));
		r4.setBounds(520, 235, 150, 30);
		r4.setBackground(Color.CYAN);
		r4.setForeground(Color.BLUE);
		r4.addActionListener(this);
		label.add(r4);
	
		r5 = new JButton("Rs 10000");
		r5.setFont(new Font("Owward", Font.ITALIC,14));
		r5.setBounds(236, 290, 150, 30);
		r5.setBackground(Color.CYAN);
		r5.setForeground(Color.BLUE);
		r5.addActionListener(this);
		label.add(r5);
	
		r6 = new JButton("Rs 20000");
		r6.setFont(new Font("Owward", Font.ITALIC,14));
		r6.setBounds(520, 290, 150, 30);
		r6.setBackground(Color.CYAN);
		r6.setForeground(Color.BLUE);
		r6.addActionListener(this);
		label.add(r6);
	
		back = new JButton("Back");
		back.setFont(new Font("Owward", Font.ITALIC,14));
		back.setBounds(520, 350, 150, 30);
		back.setBackground(Color.CYAN);
		back.setForeground(Color.BLUE);
		back.addActionListener(this);
		label.add(back);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == back)
			{
				setVisible(false);
				new Transaction(pin).setVisible(true);
			}
			else 
			{
				String amount = ((JButton)ae.getSource()).getText().substring(3);// Rs 1000
				Connect c = new Connect();
				try
				{
					ResultSet rs = c.s.executeQuery("select * from treasury where pin = '"+pin+"'");
					int balance = 0;
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
					if(ae.getSource() != back && balance < Integer.parseInt(amount))
					{
			    		JOptionPane.showMessageDialog(null, "You Have Insufficient Amount In Your Account");
			    		return;
					}
					Date date = new Date();
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
	public static void main(String[] args)
	{
		new FastCash("");
	}
}