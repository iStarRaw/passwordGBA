package ilsa.password.generator;

import java.util.ArrayList;
import java.util.List;

import ilsa.password.models.CharacterBox;
import ilsa.password.models.Password;

public class PasswordGenerator {

	private Password password;
	private CharacterBox cbox;
	private List<Character> duplicates;

	public PasswordGenerator(int length) {
		password = new Password(length);
		cbox = new CharacterBox();
		duplicates = new ArrayList<>();

		createPassword();
	}

	private void createPassword() {
		for (int i = 0; i < password.getLength(); i++) {
			addChar(i);

			System.out.printf("Index %d is: %c en is een %s\n", i, password.getPassword().get(i), password.getSort(i));
		}
		System.out.println(password.toHexString()); // sommige printen niet goed uit ivm encoding
		System.out.println(password.toBinaryString());

	}

	private void addChar(int indexToAdd) {
		char duplicate;
		boolean generateSame = false;
		boolean generateOther = false;
		String sort = "";
		char forbiddenChar = '\0';

		if (indexToAdd < 2) {
			password.getPassword().add(cbox.generateChar());
			
		}

		else if (indexToAdd == 2) {

			if (password.lastIsDuplicate()) {
				duplicate = password.getDuplicate();
				duplicates.add(duplicate);
			}

			if (password.areSameSort(2)) {
				generateSame = true;
				sort = password.getSort(indexToAdd - 1);

				if (password.isSequence()) {
					forbiddenChar = password.getForbiddenChar();
				}
			}
			password.getPassword().add(cbox.generateChar(duplicates, sort, generateSame, generateOther, forbiddenChar));

		}

		else if (indexToAdd > 2) {

			if (password.lastIsDuplicate()) {
				duplicate = password.getDuplicate();
				duplicates.add(duplicate);
			}
			
			
			if (password.areSameSort(2) & !password.areSameSort(3)) {
				generateSame = true;
				sort = password.getSort(indexToAdd - 1);
				
				if (password.isSequence()) {
					forbiddenChar = password.getForbiddenChar();
				}

			} else if (password.areSameSort(3)) {
				generateOther = true;
				sort = password.getSort(indexToAdd - 1);
			} 
			password.getPassword().add(cbox.generateChar(duplicates, sort, generateSame, generateOther, forbiddenChar));

		}

	}

}
