package ilsa.password.customexception;

public class TooSmallException extends Exception {
	public String message = "Your password has to be 8 characters or more!";

	public TooSmallException() {
		
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
