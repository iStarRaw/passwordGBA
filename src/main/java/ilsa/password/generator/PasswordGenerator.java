package ilsa.password.generator;

import ilsa.password.models.CharacterBox;
import ilsa.password.models.Password;

public class PasswordGenerator {

	private Password password;
	private CharacterBox cbox;

	public PasswordGenerator(int length) {
		password = new Password(length);
		cbox = new CharacterBox();

		createPassword();
	}

	private void createPassword() {
		for (int i = 0; i < password.getPassword().size(); i++) {
			addChar(i);

			System.out.println(password.getPassword().get(i));
		}

	}

	private void addChar(int index) {

		if (index < 2) {
			// pick from all possibilities
			password.getPassword().add(cbox.generateFromAll());
		}

		if (!twoBeforeSame() && !duplicatesExist()) {
			// pick from all possibilities
			password.getPassword().add(cbox.generateFromAll());
//		} else if (duplicatesExist()) {
//			//pick from all without the duplicate
			int duplicate = getDuplicate();
			password.getPassword().add(cbox.generateWithout(duplicate));
//		}
//		
//		if (twoBeforeSame && threeBeforeSame()) {
//			if (duplicatesExist()) {
//				//pick from other sort without the duplicate
//			}
//			//pick from all possibilities
//			password.getPassword().add(cbox.generateFromAll());
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

			password.getPassword().add(cbox.generateFromAll());

		}

	}

	private int getDuplicate() {
		// TODO Auto-generated method stub
		for (int i = 0; i < password.getLength(); i++) {

		}
		return 0;
	}

	private boolean duplicatesExist() {
		// TODO Auto-generated method stub
		if (password.getPassword().size() < 2) {
			return false;
		}
		
		int occurrences = 0;
		for (int i = 0; i < password.getLength() - 1; i++) {
			if (password.getPassword().get(i) == password.getPassword().get(i + 1)) {
				occurrences++;
			}
			if (occurrences == 2) {
				return true;
			}
		}
		return false;
	}
	

	private boolean twoBeforeSame() {
		// TODO Auto-generated method stub
		for (int i = 0; i < password.getLength(); i++) {
			
		}
		
		return false;
	}

}
