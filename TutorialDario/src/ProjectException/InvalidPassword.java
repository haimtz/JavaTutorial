package ProjectException;

public class InvalidPassword extends Exception {

	public InvalidPassword() {
		super();
	}

	public InvalidPassword(String massage) {
		super(massage);
	}

}
