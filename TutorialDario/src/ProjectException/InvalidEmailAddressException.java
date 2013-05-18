package ProjectException;

public class InvalidEmailAddressException extends Exception {

	public InvalidEmailAddressException() {
		super();
		
	}
	
	public InvalidEmailAddressException(String massage) {
		super(massage);
	}
	
}
