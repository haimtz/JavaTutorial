package ProjectException;

public class UserPasswordException extends Exception {
	
	public UserPasswordException() {
		super();
	}
	
	public UserPasswordException(String massage) {
		super(massage);
	}
}
