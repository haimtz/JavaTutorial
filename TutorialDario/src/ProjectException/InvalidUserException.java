package ProjectException;

public class InvalidUserException extends Exception {
	
	public InvalidUserException()
	{
		super();
	}
	
	public InvalidUserException(String massage)
	{
		super(massage);
	}	
}
