package Tester;



import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;

import ProjectException.InvalidUserIDException;

import model.*;

public class TesterClass {
	
	public static void main(String[] args) throws Exception {
		
		List<User> myUsers = new LinkedList<>();
		
		myUsers.add(new User("ABS","123","pass"));
		myUsers.add(new User("ABS1","1234","pass1"));
		myUsers.add(new User("ABS2","12345","pass2"));
		myUsers.add(new User("ABS3","123456","pass3"));
		
		
		Formatter output;
		
		try
		{
			output = new Formatter("User.txt");
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

	}

}
