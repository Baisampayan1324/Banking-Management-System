package banking;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener
{
	
	Image i2;
    JLabel label, formno, personDetails, name, fname, dob, gender, email, marital, address, city, pincode, state;
	long random;
    JButton next;
	ImageIcon i1, i3;
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    ButtonGroup gendergroup, maritalgroup;
	JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    
    Signup()
	{
    	setTitle("NEW ACCOUNT APPLICATION FORM");
		setLayout(null);
		
		i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
		i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		i3 = new ImageIcon(i2);
		label = new JLabel(i3);
		label.setBounds(20 , 10, 100, 100);
		add(label);

		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		formno = new JLabel("CUSTOMER APPLICATION FORM NO. " + random);
		formno.setFont(new Font("Merlin", Font.BOLD, 28));
		formno.setBounds(140, 30, 600, 40);
		add(formno);
		
		personDetails = new JLabel("Page I: Personal Details");
		personDetails.setFont(new Font("Osward", Font.ITALIC, 25));
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);
		
		name = new JLabel("Name:");
		name.setFont(new Font("Osward", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont( new Font("Ariel", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Osward", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont( new Font("Ariel", Font.BOLD, 14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
		
		dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Osward", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		dateChooser.setForeground(new Color(105, 105, 105));
		add(dateChooser);
		
		gender = new JLabel("Gender:");
		gender.setFont(new Font("Osward", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 290, 120, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		email = new JLabel("Email Address:");
		email.setFont(new Font("Osward", Font.BOLD, 20));
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont( new Font("Ariel", Font.BOLD, 14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		
		marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Osward", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 390, 100, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(630, 390, 100, 30);
		other.setBackground(Color.WHITE);
		add(other);
		
		maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);
		
		address = new JLabel("Address:");
		address.setFont(new Font("Osward", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont( new Font("Ariel", Font.BOLD, 14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);
		
		city = new JLabel("City:");
		city.setFont(new Font("Osward", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont( new Font("Ariel", Font.BOLD, 14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
		
		pincode = new JLabel("Pin Code:");
		pincode.setFont(new Font("Osward", Font.BOLD, 20));
		pincode.setBounds(100, 540, 200, 30);
		add(pincode);
		
		pincodeTextField = new JTextField();
		pincodeTextField.setFont( new Font("Ariel", Font.BOLD, 14));
		pincodeTextField.setBounds(300, 590, 400, 30);
		add(pincodeTextField);
		
		state = new JLabel("State:");
		state.setFont(new Font("Osward", Font.BOLD, 20));
		state.setBounds(100, 590, 200, 30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont( new Font("Ariel", Font.BOLD, 14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);
		
		next = new JButton("NEXT");
		next.setBounds(620, 660, 80, 30);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(780, 800);
		setLocation(350, 20);
		setVisible(true);
	}
    public void actionPerformed(ActionEvent ae)
    {
    	String formno = "" + random;// long
    	String name = nameTextField.getText();// setText
    	String fname = fnameTextField.getText();
    	String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
    	String gender = null;
    	if(male.isSelected())
    	{
    		gender = "Male";
    	}
    	else if (female.isSelected())
    	{
    		gender = "Female";
    	}
    	String email = emailTextField.getText();
    	String marital = null;
    	if(married.isSelected())
    	{
    		marital = "Married";
    	}
    	else if (unmarried.isSelected())
    	{
    		marital = "Unmarried";
    	}
    	else if (other.isSelected())
    	{
    		marital = "Other";
    	}
    	String address = addressTextField.getText();
    	String city = cityTextField.getText();
    	String pincode = pincodeTextField.getText();
    	String state = stateTextField.getText();
    	try
    	{
    		if(name.equals(""))
    		{
    			JOptionPane.showMessageDialog(null, "Name is Required");
    		}
    		else if(fname.equals(""))
    		{
    			JOptionPane.showMessageDialog(null, "Father's Name is Required");
    		}
    		else if(dob.equals(""))
    		{
    			JOptionPane.showMessageDialog(null, "Date Of Birth is Required");
    		}
    		else if(gender.equals(""))
    		{
    			JOptionPane.showMessageDialog(null, "Gender is Required");
    		}
    		else if(marital.equals(""))
    		{
    			JOptionPane.showMessageDialog(null, "Marital Status is Required");
    		}
    		else if(address.equals(""))
    		{
    			JOptionPane.showMessageDialog(null, "Address is Required");
    		}
    		else if(city.equals(""))
    		{
    			JOptionPane.showMessageDialog(null, "City is Required");
    		}
    		else if(pincode.equals(""))
    		{
    			JOptionPane.showMessageDialog(null, "Pin Code is Required");
    			if(state.equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "State is Required");
        		}
    		}
    		else
    		{
    			Connect c = new Connect();
    			String query = "Insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pincode+"', '"+state+"')";
    			c.s.executeUpdate(query);
    			
    			setVisible(false);
    			new SignupTwo(formno).setVisible(true);
    		}
    	}
    	catch (Exception e)
    	{
    		System.out.println(e);
    	}
    }
	public static void main(String[] args) 
	{
		new Signup();
	}
}