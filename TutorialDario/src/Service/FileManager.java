package Service;

import java.io.*;

public class FileManager 
{	
	private final String FILE_NAME;
	
	public FileManager(String fileName)
	{
		FILE_NAME = fileName;
	}
	
	public void writeObject(Object obj) throws FileNotFoundException, IOException
	{
		// check if object is null
		if(obj == null)
			throw new NullPointerException("Null Object");
		
		ObjectOutputStream outputObj;
		
		try{
			outputObj = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			
		}
		catch(Exception ex)
		{
			//TODO throw exception
		}
		
	}
	
	/***
	 * check if the file is existing 
	 * @return true/false
	 */
	private boolean isExistingFile()
	{
		File myFile = new File(FILE_NAME);
		if(myFile.exists())
			return true;
		
		return false;
	}	
}
