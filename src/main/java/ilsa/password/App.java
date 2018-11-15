package ilsa.password;

import ilsa.password.customexception.TooSmallException;
import ilsa.password.generator.PasswordGenerator;

public class App {

	public static void main(String[] args) {

		try {
			PasswordGenerator pg = new PasswordGenerator(0);

		} catch (TooSmallException e) {
			System.out.println(e.getMessage());
		}

	}

}
