package dictu.password.generator;

import java.util.InputMismatchException;

import dictu.password.exception.PasswordException;

public class PasswordTestHelper {
	
	public PasswordTestHelper () {
		
		
	}
	
	
	void addThisChar(char thisChar) throws PasswordException, InputMismatchException {
		if (thisChar == 0) {
			throw new InputMismatchException();
		}
		
		if (passwordHelper.size() >= this.length) {
			throw new PasswordException("Password already has the desired length");
		}
		this.passwordHelper.add(thisChar);

	}

}
