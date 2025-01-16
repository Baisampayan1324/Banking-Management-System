package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AccountClosed extends JFrame implements ActionListener
{
    Image i2, ii2;
    ImageIcon i1, i3;
    JLabel formno, text, label;
    JTextField formnoTextField;
    JButton closeAccount, cancel;

    public AccountClosed() {
        setTitle("Close Account");
        setLayout(null);

        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
		i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		i3 = new ImageIcon(i2);
		label = new JLabel(i3);
		label.setBounds(50 , 10, 100, 99);
		label.setBackground(Color.BLACK);
		add(label);
		
        text = new JLabel("Welcome To DeBank");
		text.setFont(new Font("Merlin", Font.BOLD,40));
		text.setBounds(160, 55, 500, 40);
		add(text);
		
        formno = new JLabel("Form No:");
        formno.setFont(new Font("Osward", Font.BOLD, 28));
        formno.setBounds(160, 150, 375, 30);
		formno.setForeground(Color.BLACK);
        add(formno);

        formnoTextField = new JTextField();
		formnoTextField.setFont( new Font("Ariel", Font.BOLD, 14));
		formnoTextField.setBounds(300, 155, 230, 30);
		add(formnoTextField);

        closeAccount = new JButton("Close");
        closeAccount.setFont(new Font("Osward", Font.BOLD, 16));
        closeAccount.setBackground(Color.BLACK);
		closeAccount.setForeground(Color.WHITE);
        closeAccount.setBounds(300, 220, 100, 30);
        closeAccount.addActionListener(this);
        add(closeAccount);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Osward", Font.BOLD, 16));
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
        cancel.setBounds(430, 220, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(600, 320);
        setLocation(500, 300);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == closeAccount) {
            String formnoText = formnoTextField.getText().trim();
            if (!formnoText.isEmpty()) {
                String[] formnoArray = formnoText.split("[,\\s]+");
                deleteAccounts(formnoArray);
            } else {
                JOptionPane.showMessageDialog(null, "Form numbers are required");
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    private void deleteAccounts(String[] formnoArray) {
        try {
            Connect c = new Connect();
            StringBuilder queryBuilder = new StringBuilder("DELETE FROM login WHERE formno IN (");
            for (int i = 0; i < formnoArray.length; i++) {
                queryBuilder.append("?");
                if (i < formnoArray.length - 1) {
                    queryBuilder.append(", ");
                }
            }
            queryBuilder.append(")");
            String query = queryBuilder.toString();
            PreparedStatement pstmt = c.c.prepareStatement(query);
            for (int i = 0; i < formnoArray.length; i++) {
                pstmt.setString(i + 1, formnoArray[i]);
            }
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Accounts closed successfully");
            } else {
                JOptionPane.showMessageDialog(null, "No accounts found with the given form numbers");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new AccountClosed();
    }
}