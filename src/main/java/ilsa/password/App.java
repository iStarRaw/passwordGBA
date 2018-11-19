package ilsa.password;

import ilsa.password.models.Password;

public class App {

	public static void main(String[] args) {
		int length = 8;

		Password pwd = Password.generate(length);
		
//		String passwordString = pwd.toString();
	}

}
