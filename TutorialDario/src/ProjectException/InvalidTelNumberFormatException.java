package ProjectException;

public class InvalidTelNumberFormatException extends Exception {

	public InvalidTelNumberFormatException() {
		super();
	}
	
	public InvalidTelNumberFormatException(String massage) {
		super(massage);
	}
}
