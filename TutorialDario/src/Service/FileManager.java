package Service;

import java.util.List;
import java.io.*;

import model.*;

public class FileManager 
{	
	private final String FILE_NAME;
	
	public FileManager(String fileName)
	{
		FILE_NAME = fileName;
	}
	
	
	/***
	 * write the object into file
	 * @param users
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeObject(List<User> users) throws FileNotFoundException, IOException
	{
		// check if object is null
		if(users == null)
			throw new NullPointerException("Null Object");
		
		ObjectOutputStream outputObj;
		
		try{
			outputObj = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			outputObj.writeObject(users);
			outputObj.close();
			
		}
		catch(Exception ex)
		{
			ex.getMessage();
			System.out.println("IN");
		}
		
	}
	
	public  List<User> readObject() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		if(!isExistingFile())
			return null;
		
		List<User> obj = null;
		ObjectInputStream inputObj = new ObjectInputStream(new FileInputStream(FILE_NAME));
		
		try{
			
			while(true)
			{
				obj = (List<User>)inputObj.readObject();
			}
			
		}
		catch (EOFException endOfFileException )
		{
			inputObj.close();
		}
		catch(FileNotFoundException ex)
		{
			return obj;
		}
		
		
		return obj;
	}
	
	
	/***
	 * check if the file is existing 
	 * @return true/false
	 */
	public boolean isExistingFile()
	{
		File myFile = new File(FILE_NAME);
		if(myFile.exists())
			return true;
		
		return false;
	}	
}
