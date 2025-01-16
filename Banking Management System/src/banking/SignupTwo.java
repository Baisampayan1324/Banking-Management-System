package banking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener
{
	Image I2;
	JLabel additionalDetails, religion, category, income, education, occupation, qualification, pan, aadhar, sr1, ex1, label; ;
	String formno;
	JButton next;
	ImageIcon I1, I3;
	JComboBox r1, c1, i1, o1, e1;
	JTextField p1, a1;
    ButtonGroup sr2, ex2;
    JRadioButton yes1, no1, yes2, no2;

    SignupTwo(String formno)
	{
    	this.formno= formno;
	   	setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		setLayout(null);
		
		I1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
		I2 = I1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		I3 = new ImageIcon(I2);
		label = new JLabel(I3);
		label.setBounds(190 , 20, 100, 100);
		add(label);
		
		additionalDetails = new JLabel("Page 2: Personal Details");
		additionalDetails.setFont(new Font("Merlin", Font.BOLD, 25));
		additionalDetails.setBounds(290, 60, 400, 30);
		add(additionalDetails);
			
		religion = new JLabel("Regligion:");
		religion.setFont(new Font("Osward", Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);
			
		String valreligion[] = {"Hindu", "Muslim", "Christian", "Sikh", "Others"};
		r1 = new JComboBox(valreligion);
		r1.setBounds(300, 140, 400, 30);
		r1.setBackground(Color.WHITE);
		add(r1);
			
		category= new JLabel("Category:");
		category.setFont(new Font("Osward", Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);
		add(category);
			
		String valcategory[] = {"General", "OBC", "SC", "ST", "Others"};
		c1 = new JComboBox(valcategory);
		c1.setBounds(300, 190, 400, 30);
		c1.setBackground(Color.WHITE);
		add(c1);
			
		income = new JLabel("Income:");
		income.setFont(new Font("Osward", Font.BOLD, 20));
		income.setBounds(100, 240, 200, 30);
		add(income);
			
		String valincome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
		i1 = new JComboBox(valincome);
		i1.setBounds(300, 240, 400, 30);
		i1.setBackground(Color.WHITE);
		add(i1);
			
		education= new JLabel("Educational");
		education.setFont(new Font("Osward", Font.BOLD, 20));
		education.setBounds(100, 290, 200, 30);
		add(education);
			
		qualification= new JLabel("Qualification:");
		qualification.setFont(new Font("Osward", Font.BOLD, 20));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);
			
		String valeducation[] = {"Non-Graduation", "Graduation", "Post-Graduation", "Doctrate", "Others"};
		e1 = new JComboBox(valeducation);
		e1.setBounds(300, 315, 400, 30);
		e1.setBackground(Color.WHITE);
		add(e1);
			
		occupation= new JLabel("Occupation:");
		occupation.setFont(new Font("Osward", Font.BOLD, 20));
		occupation.setBounds(100, 390, 200, 30);
		add(occupation);
			
		String valoccupation[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others"};
		o1 = new JComboBox(valoccupation);
		o1.setBounds(300, 390, 400, 30);
		o1.setBackground(Color.WHITE);
		add(o1);
			
		pan= new JLabel("PAN Numbber:");
		pan.setFont(new Font("Osward", Font.BOLD, 20));
		pan.setBounds(100, 440, 200, 30);
		add(pan);
			
		p1 = new JTextField();
		p1.setFont( new Font("Ariel", Font.BOLD, 14));
		p1.setBounds(300, 440, 400, 30);
		add(p1);
			
		aadhar= new JLabel("Aadhar Number:");
		aadhar.setFont(new Font("Osward", Font.BOLD, 20));
		aadhar.setBounds(100, 490, 200, 30);
		add(aadhar);
			
		a1 = new JTextField();
		a1.setFont( new Font("Ariel", Font.BOLD, 14));
		a1.setBounds(300, 490, 400, 30);
		add(a1);
			
		sr1= new JLabel("Senior Citizen:");
		sr1.setFont(new Font("Osward", Font.BOLD, 20));
		sr1.setBounds(100, 540, 200, 30);
		add(sr1);
			
		yes1 = new JRadioButton("Yes");
		yes1.setBounds(300, 540, 100, 30);
		yes1.setBackground(Color.WHITE);
		add(yes1);
			
		no1 = new JRadioButton("No");
		no1.setBounds(450, 540, 120, 30);
		no1.setBackground(Color.WHITE);
		add(no1);
			
		sr2 = new ButtonGroup();
		sr2.add(yes1);
		sr2.add(no1);
			
		ex1= new JLabel("Existing Account:");
		ex1.setFont(new Font("Osward", Font.BOLD, 20));
		ex1.setBounds(100, 590, 200, 30);
		add(ex1);
			
		yes2 = new JRadioButton("Yes");
		yes2.setBounds(300, 590, 120, 30);
		yes2.setBackground(Color.WHITE);
		add(yes2);
			
		no2 = new JRadioButton("No");
		no2.setBounds(450, 590, 120, 30);
		no2.setBackground(Color.WHITE);
		add(no2);
			
		ex2 = new ButtonGroup();
		ex2.add(yes2);
		ex2.add(no2);
			
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
	    String sreligion = (String) r1.getSelectedItem();
	   	String scategory = (String) c1.getSelectedItem();
	   	String sincome = (String) i1.getSelectedItem();
	   	String seducation = (String) e1.getSelectedItem();
	   	String soccupation = (String) o1.getSelectedItem();
    	String sr1 = null;
	   	if(yes1.isSelected())
	    {
	    	sr1 = "Yes";
	   	}
	   	else if (no1.isSelected())
	   	{
	   		sr1 = "No";
	   	}
	   	String ex1 = null;
	   	if(yes2.isSelected())
	   	{
	   		ex1 = "Yes";
	   	}
	   	else if (no2.isSelected())
	   	{
	   		ex1 = "No";
	   	}
	   	String span = p1.getText();
	   	String saadhar = a1.getText();  	
	   	try
	    {
	   		Connect c = new Connect();
	    	String query = "Insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+sr1+"', '"+ex1+"')";
	   		c.s.executeUpdate(query);
	   		
	   		setVisible(false);
			new SignupThree(formno).setVisible(true);
	   	}
	   	catch(Exception e)
    	{
	   		System.out.println(e);
	    }
	}
	public static void main(String[] args) 
	{
		new SignupTwo("");
	}
}