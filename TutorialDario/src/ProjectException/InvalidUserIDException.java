package ProjectException;

public class InvalidUserIDException extends Exception {

	//private static final long serialVersionUID = 1L;
	private String Message;
	
	public InvalidUserIDException() {
		 this.Message = "Unknown";
	}

	public InvalidUserIDException(String message) {
		super(message);
		this.Message = message;
	}
	
	public String getMessage()
	{
		return Message;
	}

}
