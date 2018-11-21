package ilsa.password;

import ilsa.password.generator.Password;

public class App {

	public static void main(String[] args) {
		int length = 8;		

		Password pwd = Password.generate(length);
		
		System.out.println(pwd.toHexString());
		
	}

}
