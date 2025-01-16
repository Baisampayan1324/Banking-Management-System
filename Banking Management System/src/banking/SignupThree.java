package banking;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener
{
	Image i2;
	JLabel accountDetails, type, card, pin, n1, n2, cdetail, pdetail, services, label;
	String formno;
	JButton submit, cancel;
	ImageIcon i1, i3;
	JCheckBox  s1, s2 ,s3, s4, s5, s6, s7;
	ButtonGroup accgroup;
	JRadioButton a1, a2, a3, a4;
	
	SignupThree(String formno)
	{
	   	this.formno = formno;
	   	setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
	   	setLayout(null);
		
	   	i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
		i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		i3 = new ImageIcon(i2);
		label = new JLabel(i3);
		label.setBounds(190 , 40, 100, 100);
		add(label);
	   	
	   	accountDetails = new JLabel("Page 3: Account Details");
		accountDetails.setFont(new Font("Merlin", Font.BOLD, 25));
		accountDetails.setBounds(290, 80, 400, 40);
		add(accountDetails);
		
		type = new JLabel("Account Type");
		type.setFont(new Font("Osward", Font.BOLD, 25));
		type.setBounds(80, 150, 540, 30);
		add(type);
		
		a1 = new JRadioButton("Saving Account");
		a1.setFont(new Font("Ariel", Font.ITALIC, 20));
		a1.setBounds(100, 190, 190, 30);
		a1.setBackground(Color.WHITE);
		add(a1);
		
		a2 = new JRadioButton("Fixed Deposit Account");
		a2.setFont(new Font("Ariel", Font.ITALIC, 20));
		a2.setBounds(350, 190, 340, 30);
		a2.setBackground(Color.WHITE);
		add(a2);
		
		a3 = new JRadioButton("Current Account");
		a3.setFont(new Font("Ariel", Font.ITALIC, 20));
		a3.setBounds(100, 240, 190, 30);
		a3.setBackground(Color.WHITE);
		add(a3);
		
		a4 = new JRadioButton("Recurring Deposit Account");
		a4.setFont(new Font("Ariel", Font.ITALIC, 20));
		a4.setBounds(350, 240, 340, 30);
		a4.setBackground(Color.WHITE);
		add(a4);
		
		accgroup = new ButtonGroup();
		accgroup.add(a1);
		accgroup.add(a2);
		accgroup.add(a3);
		accgroup.add(a4);
		
		card = new JLabel("Card Number");
		card.setFont(new Font("Osward", Font.BOLD, 25));
		card.setBounds(80, 290, 220, 30);
		add(card);
		
		n1 = new JLabel("XXXX-XXXX-XXXX-8975");
		n1.setFont(new Font("Osward", Font.BOLD, 20));
		n1.setBounds(350, 310, 340, 30);
		add(n1);
		
		cdetail = new JLabel("Your 16 Digit Card Number");
		cdetail.setFont(new Font("Osward", Font.ITALIC, 14));
		cdetail.setBounds(80, 310, 220, 30);
		add(cdetail);
		
		pin = new JLabel("PIN");
		pin.setFont(new Font("Osward", Font.BOLD, 25));
		pin.setBounds(80, 370, 540, 30);
		add(pin);
		
		n2 = new JLabel("XXXX");
		n2.setFont(new Font("Osward", Font.BOLD, 20));
		n2.setBounds(350, 390, 220, 30);
		add(n2);
		
		pdetail = new JLabel("Your 4 Digit Password");
		pdetail.setFont(new Font("Osward", Font.ITALIC, 14));
		pdetail.setBounds(80, 390, 220, 30);
		add(pdetail);
		
		services = new JLabel("Services Required:");
		services.setFont(new Font("Osward", Font.BOLD, 25));
		services.setBounds(80, 450, 540, 30);
		add(services);
		
		s1 = new JCheckBox("ATM CARD");
		s1.setFont(new Font("Ariel", Font.ITALIC, 20));
		s1.setBounds(100, 490, 190, 30);
		s1.setBackground(Color.WHITE);
		add(s1);
		
		s2 = new JCheckBox("Mobile Banking");
		s2.setFont(new Font("Ariel", Font.ITALIC, 20));
		s2.setBounds(100, 540, 190, 30);
		s2.setBackground(Color.WHITE);
		add(s2);
		
		s3 = new JCheckBox("Cheque Book");
		s3.setFont(new Font("Ariel", Font.ITALIC, 20));
		s3.setBounds(100, 590, 190, 30);
		s3.setBackground(Color.WHITE);
		add(s3);
		
		s4 = new JCheckBox("Internet Banking");
		s4.setFont(new Font("Ariel", Font.ITALIC, 20));
		s4.setBounds(350, 490, 190, 30);
		s4.setBackground(Color.WHITE);
		add(s4);
		
		s5 = new JCheckBox("EMAIL & SMS Alerts");
		s5.setFont(new Font("Ariel", Font.ITALIC, 20));
		s5.setBounds(350, 540, 340, 30);
		s5.setBackground(Color.WHITE);
		add(s5);
		
		s6 = new JCheckBox("E-Statement");
		s6.setFont(new Font("Ariel", Font.ITALIC, 20));
		s6.setBounds(350, 590, 190, 30);
		s6.setBackground(Color.WHITE);
		add(s6);
		
		s6 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
		s6.setFont(new Font("Ariel", Font.ITALIC, 14));
		s6.setBounds(100, 650, 750, 30);
		s6.setBackground(Color.WHITE);
		add(s6);
		
		submit = new JButton("Submit");
		submit.setBounds(250, 700, 100, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(450, 700, 100, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);	
		setSize(780,800);
		setLocation(350, 20);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == submit){		
        String type = null;
        if(a1.isSelected())
        {
            type = "Saving Account";
        }
        else if(a2.isSelected())
        {
            type = "Fixed Deposit Account";
        }
        else if(a3.isSelected())
        {
            type = "Current Account";
        }
        else if(a4.isSelected())
        {
            type = "Recurring Deposit Account";
        }
        
        Random random = new Random();
        String card = "" + Math.abs((random.nextLong() % 90000000L) + 654964900000000L);
        String pin = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
        String services = "";
        
        if(s1.isSelected())
        {
            services = "ATM CARD";
        }
        if(s2.isSelected())
        {
            services += " Mobile Banking";
        }
        if(s3.isSelected())
        {
            services += " Cheque Book";
        }
        if(s4.isSelected())
        {
            services += " Internet Banking";
        }
        if(s5.isSelected())
        {
            services += " EMAIL & SMS Alerts";
        }
        if(s6.isSelected())
        {
            services += " E-Statement";
        }
        
        try
        {
            if(type == null)
            {
                JOptionPane.showMessageDialog(null, "Account Type is Required");
            }
            else
            {
                Connect c = new Connect();
                String query1 = "Insert into signupthree values('" + formno + "', '" + type + "', '" + card + "', '" + pin + "','" + services + "')";
                c.s.executeUpdate(query1);
                String query2 = "Insert into login values('" + formno + "', '" + card + "', '" + pin + "')";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Card Number:" + card + "\n Pin:" + pin);
                
                setVisible(false);
                new Login().setVisible(true);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    else if(ae.getSource() == cancel)
    {
        setVisible(false);
        new Login().setVisible(true);
    }
}
	public static void main(String[] args)
	{
		new SignupThree("");
	}
}