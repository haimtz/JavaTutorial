package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.Group;

import ProjectException.EmailAddressException;
import ProjectException.TelNumberException;
import ProjectException.UserException;
import ProjectException.UserIDException;
import ProjectException.UserNameException;
import ProjectException.UserPasswordException;
import Service.Validator;

import model.DBUsers;
import model.User;

public class MainForm extends JFrame {
	
	private GridBagConstraints gbc;
	private DBUsers DbUsers;
	
	// define Labels
	private JLabel lblConfirmPass;
    private JLabel lblEmail;
    private JLabel lblIdnumber;
    private JLabel lblPassword;
    private JLabel lblPhone;
    private JLabel lblUsername;
    
    // define Text fields
    private JTextField txtEmail;
    private JTextField txtIdNumber;
    private JTextField txtPhone;
    private JTextField txtUsername;
    // define password fields
    private JPasswordField txpConfirm;
    private JPasswordField txpPassword;
    
    //define buttons
    private JButton butClose;
    private JButton butCreate;
    
	public MainForm(DBUsers users)
	{
		super("Add USer");
		init();
		DbUsers = users;		
		this.setLayout(new GridBagLayout());
		setSize(1500, 1600);
		
		setComponents();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		setResizable(false);
		pack();
		
	}
	
	private void init()
	{
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		// Initialization Label
		lblUsername = new JLabel("Username:");
		lblIdnumber = new JLabel("ID number:");
		lblEmail = new JLabel("Email:");
		lblPhone = new JLabel("Phone:");
		lblPassword = new JLabel("Password:");
		lblConfirmPass = new JLabel("Confirm Pass:");
		
		// Initialization TextField
		txtUsername = new JTextField(20);
		txtIdNumber = new JTextField(20);
		txtEmail =  new JTextField(20);
		txtPhone = new JTextField(20);
		txpPassword = new JPasswordField(20);
		txpConfirm = new JPasswordField(20);
		
		// Initialization Buttons
		butClose = new JButton("Close");
		butCreate = new JButton("Create");
		
		ButtonHandler handler = new ButtonHandler();
		butClose.addActionListener(handler);
		butCreate.addActionListener(handler);
	}
	
	private void setComponents()
	{
		// Username
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(lblUsername, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(txtUsername, gbc);
		
		// Id number
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(lblIdnumber, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(txtIdNumber, gbc);
		
		// email
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(lblEmail, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(txtEmail, gbc);
		
		
		// phone number
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(lblPhone, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(txtPhone,gbc);
		
		// password
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(lblPassword,gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(txpPassword,gbc);
		
		// confirm password
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(lblConfirmPass, gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		add(txpConfirm,gbc);
		
		// buttons
		gbc.gridx = 0;
		gbc.gridy = 6;
		add(butCreate, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		add(butClose,gbc);
		
	}

	private class ButtonHandler implements ActionListener
	{
		private User newUser;
		private boolean isSaved;
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			
			if(event.getActionCommand() == "Close")
			{
				if(!isSaved)
					JOptionPane.showMessageDialog(MainForm.this, "User didnot save!!");
				dispose();
			}
			
			if(event.getActionCommand() == "Create")
			{
				newUser = new User();
				CreateUser();
				try {
					
					checkPassword();
					ValidUser();
					saveUser();
					
					// Clear Controls
					txtUsername.setText("");
					txtIdNumber.setText("");
					txtEmail.setText("");
					txtPhone.setText("");
					txpConfirm.setText("");
					txpPassword.setText("");
					isSaved = true;
					
					// confirm Message
					JOptionPane.showMessageDialog(MainForm.this, "User add successfully");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(MainForm.this, e.getMessage());
				}
				
			}
		}
		
		private void saveUser() throws FileNotFoundException, IOException
		{
			DbUsers.addUser(newUser);
			DbUsers.SaveList();
			isSaved = false;
		}
		
		private void ValidUser() throws UserException, UserNameException, 
										UserIDException, EmailAddressException,
										TelNumberException, UserPasswordException
		{
			
			Validator valid = new Validator(DbUsers.getUsers());
			
			valid.ValidNewUser(newUser);
			valid.ValidUserName(newUser.getName());
			valid.ValidId(newUser.getIdNumber());
			valid.ValidEmail(newUser.getEmail());
			valid.ValidPhoneNumber(newUser.getTel());
			valid.ValidPassword(String.copyValueOf(txpPassword.getPassword()));
		}
		
		private void CreateUser()
		{
			newUser.setName(txtUsername.getText());
			newUser.setIdNumber(txtIdNumber.getText());
			newUser.setEmail(txtEmail.getText());
			newUser.setTel(txtPhone.getText());
			newUser.setPassword(String.copyValueOf(txpPassword.getPassword()));
		}
		
		private void checkPassword() throws UserPasswordException
		{
			String password = String.copyValueOf(txpPassword.getPassword());
			String confirm = String.copyValueOf(txpConfirm.getPassword());
			
			if(password.compareTo(confirm) != 0)
				throw new UserPasswordException("The confirm Dont mach to password");
		}
		
	}
}
