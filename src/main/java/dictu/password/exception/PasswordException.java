package dictu.password.exception;

public class PasswordException extends RuntimeException {
	public String message;

	public PasswordException() {
		
	}
	
	public PasswordException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
