package ilsa.password.generator;


import java.util.Arrays;

import ilsa.password.models.CharacterBox;
import ilsa.password.models.Password;

public class PasswordGenerator  {

	private Password password;
	private CharacterBox cbox;
	

	public PasswordGenerator(int length) {
		password = new Password(length);
		cbox = new CharacterBox();
		
		createPassword();
	}

	
	private void createPassword() {
		for (int i = 0; i < password.getLength(); i++) {
			addChar(i);

			System.out.println(password.getPassword()[i]);
		}

	}
	
	public void addChar(int index) {

		if (index < 2) {
			// pick from all possibilities
			password.getPassword()[index] = cbox.generateFromAll();
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

		password.getPassword()[index] = cbox.generateFromAll();
	}

	
	
	
	

}