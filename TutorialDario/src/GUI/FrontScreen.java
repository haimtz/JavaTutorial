package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.DBUsers;

public class FrontScreen extends JFrame {
	
	private JButton butNewUser;
	private JButton butExit;
	private GridLayout layout;
	
	GridBagConstraints c;
	public FrontScreen()
	{
		super("Main Frame");
		init();
		//layout = new GridLayout(1,2);
		setLayout(new GridBagLayout());
		setSize(200, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		c = new GridBagConstraints();
		
		c.insets = new Insets(5, 5, 5, 5);
		
		c.gridx = 1;
		c.gridy = 0;
		add(butNewUser, c);
		
		
		c.gridx = 2;
		c.gridy = 0;
		add(butExit, c);
	}
	
	private void init()
	{
		butNewUser = new JButton("New User");
		butExit = new JButton("Exit");
		
		ButtonHandler handler = new ButtonHandler();
		
		butNewUser.addActionListener(handler);
		butExit.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getActionCommand() == "New User")
			{
				try{
					DBUsers myUsers = new DBUsers();
					MainForm myForm = new MainForm(myUsers);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(FrontScreen.this, ex.getMessage());
				}
			}
			else
			{
				dispose();
			}
			
		}
		
	}

}
