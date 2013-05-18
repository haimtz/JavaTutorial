package ProjectException;

public class InvalidUserException extends Exception {

	private String massage;
	public InvalidUserException()
	{
		massage = "Unknown";
	}
	
	public InvalidUserException(String msg)
	{
		massage = msg;
	}

	public String getMassage() {
		return massage;
	}	
}
