package ProjectException;

public class InvalidTelNumberFormatException extends Exception {
	
	private String massage;

	public InvalidTelNumberFormatException() {
		super();
		this.massage = "Unknown";
	}
	
	public InvalidTelNumberFormatException(String massage) {
		super();
		this.massage = massage;
	}

	public String getMassage() {
		return massage;
	}
}
