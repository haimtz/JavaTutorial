package Service;

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
	 * @param obj
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeObject(Object obj) throws FileNotFoundException, IOException
	{
		// check if object is null
		if(obj == null)
			throw new NullPointerException("Null Object");
		
		ObjectOutputStream outputObj;
		
		try{
			outputObj = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			outputObj.writeObject(obj);
			outputObj.close();
			
		}
		catch(Exception ex)
		{
			//TODO throw exception
		}
		
	}
	
	public < T extends User >  T readObject() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		T obj;
		
		try{
			ObjectInputStream inputObj = new ObjectInputStream(new FileInputStream(FILE_NAME));
			obj = (T)inputObj.readObject();
			return obj;
			
		}
		catch(FileNotFoundException ex)
		{
			
		}
		finally{
			return null;
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
