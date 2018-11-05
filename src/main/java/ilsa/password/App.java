package ilsa.password;


import java.nio.charset.Charset;
import java.util.Locale;

import ilsa.password.generator.PasswordGenerator;

public class App {

	public static void main(String[] args) {
		System.out.println(Charset.defaultCharset());
		
		
		PasswordGenerator pg = new PasswordGenerator(4);
		
		

	}

	

}
