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

	private void createPassword() {
		for (int i = 0; i < password.getLength(); i++) {
			addChar(i);

			System.out.println(password.getPassword()[i]);
		}

	}

	
	
	private int addChar(int index) {
		
		if (index < 2) {
			// pick from all possibilities
			return 0;
		}
		
		
//		if (!twoBeforeSame() && !duplicatesExist()) {
//			//pick from all possibilities
//		} else if (duplicatesExist()) {
//			//pick from all without the duplicate
//		}
//		
//		if (twoBeforeSame && threeBeforeSame()) {
//			if (duplicatesExist()) {
//				//pick from other sort without the duplicate
//			}
//			//pick from all possibilities
//		}
//		
//		//condition that two of the same type are not allowed together
//		if (twoBeforeSame()) {
//			if (duplicatesExist()) {
//				//pick from all without the duplicate
//			}
//			if (sequenceExists()) {
//				//pick same sort without lastChar +1 or -1
//			}
//			//pick the same sort
//		}
//		
//		
//		//condition that four of the same type are not allowed together
//		if (threeBeforeSame()) {
//			//pick another
//		}
		
		
		
		return 0;

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
