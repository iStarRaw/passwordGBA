package ilsa.password;

import ilsa.password.customexception.TooSmallException;
import ilsa.password.generator.PasswordGenerator;

public class App {

	public static void main(String[] args) {
		int length = 8;

		try {
			PasswordGenerator pg = new PasswordGenerator(length);

		} catch (TooSmallException e) {
			System.out.println(e.getMessage());
		}

	}

}
