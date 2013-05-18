package ProjectException;

public class InvalidEmailAddressException extends Exception {

	private String massage;

	public InvalidEmailAddressException() {
		super();
		this.massage = "Unknown";
	}
	
	public InvalidEmailAddressException(String massage) {
		super();
		this.massage = massage;
	}

	public String getMassage() {
		return massage;
	}
	
}
