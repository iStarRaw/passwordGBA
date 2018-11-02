package ilsa.password;


import java.nio.charset.Charset;
import java.util.Locale;

import ilsa.password.generator.PasswordGenerator;

public class App {

	public static void main(String[] args) {
		System.out.println(Charset.defaultCharset());
//		Locale l = Locale.ENGLISH;
//		Locale l = new Locale("en");
//		Locale.setDefault(l);
		
		
		PasswordGenerator pg = new PasswordGenerator(4);
		
		

	}

	

}
