package Tester;



import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;

import ProjectException.InvalidUserIDException;

import model.*;

public class TesterClass {
	
	static List<User> fromFile = new LinkedList<User>();
	
	public static void main(String[] args) throws Exception {
		
		List<User> myUsers = new LinkedList<User>();
		
		
		
		myUsers.add(new User("SDfdhfjk","123","pass"));
		myUsers.add(new User("abcd","123","pass"));
		
		
		ObjectOutputStream  output;
		File storageFile = new File("C:\\Users\\HOME\\Desktop\\User.txt");
		
		
		try
		{
			output = new ObjectOutputStream (new FileOutputStream("C:\\Users\\HOME\\Desktop\\User.txt"));
			
			for(User u : myUsers)
			{
				output.writeObject(u);
			}
			output.close();
		}
		 // end try
		catch ( SecurityException securityException )
		{
		      System.err.println(
		      "You do not have write access to this file." );
		      System.exit( 1 );
		} // end catch
		catch ( FileNotFoundException filesNotFoundException )
		{
		       System.err.println( "Error creating file." );
		          System.exit( 1 );
		} 
		

		read();
		
		for(User u : fromFile)
		{
			System.out.println(u.getName() + " " + u.getIdNumber());
		}

	}
	
	public static void read() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream input;
		
		try{
			input = new ObjectInputStream(new FileInputStream("C:\\Users\\HOME\\Desktop\\User.txt"));
			
			while(true)
			{
				User temp;
				temp = (User)input.readObject();
				fromFile.add(temp);
			}
		}

		catch (EOFException endOfFileException )
		{
			return;
		}
	}

}
