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
		for (int i = 0; i < password.getLength(); i++) {
			addChar(i);
			
			System.out.println(password.getPassword().get(i));
		}

	}

	private void addChar(int index) {

		if (index < 2) {
			// pick from all possibilities
			password.getPassword().add(cbox.generateFromAll());
		}

		//if lastTwoSameSort() then getSort() and add.generateFromSameSort()
		//if lastThreeSameSort() then getSort() and add.generateFromOtherSort()
		
		
		
//		if (!password.isTwoBeforeSame() && !password.hasDuplicates()) {
			// pick from all possibilities
			password.getPassword().add(cbox.generateFromAll());
//		} else if (password.hasDuplicates()) {
//			//pick from all without the duplicate
//			int duplicate = getDuplicate();
//			password.getPassword().add(cbox.generateWithout(duplicate));
//		}
//		
//		if (twoBeforeSame && threeBeforeSame()) {
//			if (password.hasDuplicates()) {
//				//pick from other sort without the duplicate
//			}
//			//pick from all possibilities
//			password.getPassword().add(cbox.generateFromAll());
//		}
//		
//		//condition that two of the same type are not allowed together
//		if (twoBeforeSame()) {
//			if (password.hasDuplicates()) {
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
