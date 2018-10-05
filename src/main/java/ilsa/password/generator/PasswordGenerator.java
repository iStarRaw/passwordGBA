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
			password.getPassword()[i] = generateChar(i);

			System.out.println(password.getPassword()[i]);
		}


		return password.toString();

	}

	private int generateChar(int index) {
		// pick from all letters
		int randomInt = secGenerator.nextInt(cbox.getLetters().length);
		return randomInt;

	}

//	password[i] = ALL_CHARS[rand.nextInt(ALL_CHARS.length)]

	public char generateChar(String candidateChars) {
		int index = secGenerator.nextInt(candidateChars.length());

		while (index < 0 || index > candidateChars.length()) {
			index = secGenerator.nextInt(candidateChars.length());
		}
		char randomChar = candidateChars.charAt(index);
		return randomChar;
	}

	// hulpmethode van generateChar
	private char asciiToChar(int asciiNumber) {
		return (char) asciiNumber;

	}

}
