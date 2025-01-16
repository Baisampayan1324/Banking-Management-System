package banking;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
	Image i2, ii2;
	JLabel label, text, cardno, pin;
	JButton login, clear, signup;
	ImageIcon i1, i3;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	Login()
	{
		setTitle("BANKING-MANAGEMENT-SYSTEM");
		setLayout(null);
		
		i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
		i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		i3 = new ImageIcon(i2);
		label = new JLabel(i3);
		label.setBounds(70 , 10, 100, 100);
		label.setBackground(Color.BLACK);
		add(label);
		
		text = new JLabel("Welcome To DeBank");
		text.setFont(new Font("Merlin", Font.BOLD,40));
		text.setBounds(200, 40, 500, 40);
		add(text);
		
		cardno = new JLabel("Card No:");
		cardno.setFont(new Font("Osward", Font.BOLD,28));
		cardno.setBounds(125, 150, 375, 30);
		cardno.setForeground(Color.BLACK);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setFont( new Font("Ariel", Font.BOLD, 14));
		cardTextField.setBounds(300, 155, 230, 30);
		add(cardTextField);
		
		pin = new JLabel("PIN:");
		pin.setFont(new Font("Osward", Font.BOLD,28));
		pin.setBounds(125, 220, 375, 30);
		pin.setForeground(Color.BLACK);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setFont( new Font("Ariel", Font.BOLD, 14));
		pinTextField.setBounds(300, 225, 230, 30);
		add(pinTextField);
		
		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 230, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 450);
		setLocation(350, 200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== clear){
			cardTextField.setText("");
			pinTextField.setText("");
		}
		 else if(ae.getSource()== login)
		{
			Connect c = new Connect();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "select * from login where cardnumber = '"+cardnumber+"'and pin = '"+pinnumber+"'";
			try
			{
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next())
				{
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Card Number and Pin");
				}
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		else if (ae.getSource()== signup)
		{
			setVisible(false);
			new Signup().setVisible(true);
		}
	}
	public static void main(String[] args)
	{
		new Login();
	}
}