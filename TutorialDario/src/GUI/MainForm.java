package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.Group;

import ProjectException.InvalidEmailAddressException;
import ProjectException.InvalidPassword;
import ProjectException.InvalidTelNumberFormatException;
import ProjectException.InvalidUserException;
import ProjectException.InvalidUserIDException;
import Service.Validator;

import model.DBUsers;
import model.User;

public class MainForm extends JFrame {
	
	private GroupLayout layout;
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
		DbUsers = users;
		layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		init();
		setComponents();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 600);
		setVisible(true);
		pack();
		
	}
	
	private void init()
	{
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
		layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(lblConfirmPass)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(txpConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addComponent(lblPassword)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(txpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                    .addComponent(lblEmail)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(lblUsername)
	                                            .addComponent(lblIdnumber)
	                                            .addComponent(lblPhone))
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(txtIdNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                                .addGap(0, 0, Short.MAX_VALUE))
	                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                .addGap(0, 0, Short.MAX_VALUE)
	                                .addComponent(butCreate)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(butClose)))))
	                .addContainerGap())
	        );
		
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lblUsername)
	                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lblIdnumber)
	                    .addComponent(txtIdNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lblEmail)
	                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(lblPhone)
	                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(25, 25, 25)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lblPassword)
	                    .addComponent(txpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lblConfirmPass)
	                    .addComponent(txpConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(butClose)
	                    .addComponent(butCreate))
	                .addContainerGap())
	        );
	}

	private class ButtonHandler implements ActionListener
	{
		private User newUser;
		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getActionCommand() == "Close")
			{
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
		}
		
		private void ValidUser() throws Exception
		{
			
			Validator valid = new Validator(DbUsers.getUsers());
			
			valid.isValidNewUser(newUser);
			//valid.isValidId(newUser.getIdNumber());
			valid.isValidEmail(newUser.getEmail());
			//valid.isValidPhoneNumber(newUser.getTel());
		}
		
		private void CreateUser()
		{
			newUser.setName(txtUsername.getText());
			newUser.setIdNumber(txtIdNumber.getText());
			newUser.setEmail(txtEmail.getText());
			newUser.setTel(txtPhone.getText());
			newUser.setPassword(String.copyValueOf(txpPassword.getPassword()));
		}
		
		private void checkPassword() throws InvalidPassword
		{
			String password = String.copyValueOf(txpPassword.getPassword());
			String confirm = String.copyValueOf(txpConfirm.getPassword());
			
			if(password.compareTo(confirm) != 0)
				throw new InvalidPassword("The confirm Dont mach to password");
		}
		
	}
}
