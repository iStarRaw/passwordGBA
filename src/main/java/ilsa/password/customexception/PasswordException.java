package ilsa.password.customexception;

public class PasswordException extends RuntimeException {
	public String message = "Your password has to be 8 characters or more!";

	public PasswordException() {
		
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
