package ilsa.password.generator;

import java.security.SecureRandom;

import ilsa.password.models.CharacterBox;
import ilsa.password.models.Password;

public class PasswordGenerator  {

	private Password password;
	private CharacterBox cbox;
	private SecureRandom secGenerator;

	public PasswordGenerator(int length) {
		password = new Password(length);
		cbox = new CharacterBox();
		secGenerator = new SecureRandom();
		createPassword();
	}

	
	private void createPassword() {
		for (int i = 0; i < password.getLength(); i++) {
			cbox.addChar(i);

			System.out.println(password.getPassword()[i]);
		}

	}

	//TODO godarray meegeven als parameter ipv string
	public char generateChar(String candidateChars) {
		int index = secGenerator.nextInt(candidateChars.length());

		while (index < 0 || index > candidateChars.length()) {
			index = secGenerator.nextInt(candidateChars.length());
		}
		char randomChar = candidateChars.charAt(index);
		return randomChar;
	}

	

}
