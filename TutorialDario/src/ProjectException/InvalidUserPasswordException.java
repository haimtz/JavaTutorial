package ProjectException;

public class InvalidUserPasswordException extends Exception {

	private String massage;

	public InvalidUserPasswordException() {
		super();
		this.massage = "Unknown";
	}
	
	public InvalidUserPasswordException(String massage) {
		super();
		this.massage = massage;
	}

	public String getMassage() {
		return massage;
	}
}
