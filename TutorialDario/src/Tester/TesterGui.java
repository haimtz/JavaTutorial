package Tester;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import model.DBUsers;

import GUI.MainForm;

public class TesterGui {

	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

		DBUsers myUsers = new DBUsers();
		MainForm myForm = new MainForm(myUsers);
		
	}

}
