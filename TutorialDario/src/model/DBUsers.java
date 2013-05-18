package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import Service.FileManager;

public class DBUsers {
	
	private List<User> users;
	private FileManager myFile;
	
	public DBUsers() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		myFile = new FileManager("User.ser");
		init();
	}
	
	private void init() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		if(myFile.isExistingFile())
			users = (List<User>)myFile.readObject();
	}

	public List<User> getUsers() {
		return users;
	}
	
	public void SaveList() throws FileNotFoundException, IOException
	{
		myFile.writeObject(users);
	}
	
}
