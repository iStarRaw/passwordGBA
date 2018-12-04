package dictu.password.generator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import dictu.password.exception.PasswordException;

public class PasswordTestHelper {
	private int length;
	private List<Character> passwordHelper;
	
	public PasswordTestHelper (int length) {
		this.length = length;
		this.passwordHelper = new ArrayList<>();
		
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
