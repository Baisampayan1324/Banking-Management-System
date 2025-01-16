package banking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener
{
	Image i2;
	String pin;
	JLabel label, t1, t2, t3;
	JButton change, back;
	ImageIcon i1, i3;
	JPasswordField p1, p2;
	PinChange(String pin)
	{
		this.pin = pin;
		setTitle("BANKING-MANAGEMENT-SYSTEM - PIN CHANGE");
		setLayout(null);
   	
		i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		i3 = new ImageIcon(i2);
		label = new JLabel(i3);
		label.setBounds(0 , 0, 900, 900);
		add(label);
		
		t1 = new JLabel("Change Your PIN");
		t1.setFont(new Font("Merlin", Font.BOLD,18));
		t1.setBounds(375, 120, 280, 50);
		t1.setForeground(Color.BLACK);
		label.add(t1);
		
		t2 = new JLabel("New PIN:");
		t2.setFont(new Font("Merlin", Font.BOLD,18));
		t2.setBounds(236, 180, 150, 30);
		t2.setForeground(Color.BLACK);
		label.add(t2);
		
		p1 = new JPasswordField();
		p1.setFont( new Font("Ariel", Font.BOLD, 14));
		p1.setBounds(420, 180, 210, 30);
		add(p1);
		
		t3 = new JLabel("Re-Enter Your PIN:");
		t3.setFont(new Font("Merlin", Font.BOLD,18));
		t3.setBounds(236, 235, 280, 30);
		t3.setForeground(Color.BLACK);
		label.add(t3);
		
		p2 = new JPasswordField();
		p2.setFont( new Font("Ariel", Font.BOLD, 14));
		p2.setBounds(420, 235, 210, 30);
		add(p2);
		
		change = new JButton("Change");
		change.setFont(new Font("Owward", Font.ITALIC,14));
		change.setBounds(520, 290, 150, 30);
		change.setBackground(Color.CYAN);
		change.setForeground(Color.BLUE);
		change.addActionListener(this);
		label.add(change);
		
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
		if(ae.getSource()== change)
		{
			try
			{
				String npin = p1.getText();
				String rpin = p2.getText();
				if(!npin.equals(rpin))
				{
		    		JOptionPane.showMessageDialog(null, "Enter PIN does not match");
		    		return;
				}
				if(npin.equals(""))
				{
		    		JOptionPane.showMessageDialog(null, "Please enter new PIN");
		    		return;
				}
				if(rpin.equals(""))
				{
		    		JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
		    		return;
				}
				Connect c = new Connect();
				String q1 = "update treasury set pin = '"+rpin+"' where pin = '"+pin+"'";
				String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"'";
				String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pin+"'";
				c.s.executeUpdate(q1);
				c.s.executeUpdate(q2);
				c.s.executeUpdate(q3);
	    		JOptionPane.showMessageDialog(null, "PIN changed Successfully");
	    		setVisible(false);
				new Transaction(rpin).setVisible(true);
	    	}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			setVisible(false);
			new Transaction(pin).setVisible(true);

		}
	}
	public static void main(String[] args)
	{
		new PinChange("").setVisible(true);
	}
}