package ilsa.password.generator;

import java.security.SecureRandom;

import ilsa.password.models.CharacterBox;
import ilsa.password.models.Password;

public class PasswordGenerator {

	private Password password;
	private CharacterBox cbox;
	private SecureRandom secGenerator;

	public PasswordGenerator(int length) {
		password = new Password(length);
		cbox = new CharacterBox();
		secGenerator = new SecureRandom();

		createPassword();

	}

	private String createPassword() {
		for (int i = 0; i < password.getLength(); i++) {
			generateChar(i);

			System.out.println(password.getPassword()[i]);
		}

		return password.toString();

	}

	private int generateChar(int index) {
		
		if (index < 2) {
			// pick from all possibilities
			int randomInt = 
		}
			int randomInt = secGenerator.nextInt(cbox.getLetters().length);
		
		return randomInt;

	}


	public char generateChar(String candidateChars) {
		int index = secGenerator.nextInt(candidateChars.length());

		while (index < 0 || index > candidateChars.length()) {
			index = secGenerator.nextInt(candidateChars.length());
		}
		char randomChar = candidateChars.charAt(index);
		return randomChar;
	}

	

}
