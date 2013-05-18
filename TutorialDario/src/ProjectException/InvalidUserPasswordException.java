package ProjectException;

public class InvalidUserPasswordException extends Exception {
	
	public InvalidUserPasswordException() {
		super();
	}
	
	public InvalidUserPasswordException(String massage) {
		super(massage);
	}
}
