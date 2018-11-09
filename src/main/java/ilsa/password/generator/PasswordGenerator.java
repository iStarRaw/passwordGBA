package ilsa.password.generator;

import java.util.ArrayList;
import java.util.Arrays;
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

			System.out.printf("Index %d is: %c\n", i, password.getPassword().get(i));
		}
		System.out.println(password.toHexString());
		
	}

	
	
	private void addChar(int indexToAdd) {
		char duplicate;
		boolean generateSame = false;
		boolean generateAll = false; //als sort niet uit maakt?
		String sort = "";
		char forbiddenChar = '\0';

		// bij 0 en 1
		if (indexToAdd < 2) {
			password.getPassword().add(cbox.generateChar());

		} 
		
		//bij index 2
		else if (indexToAdd % 2 == 0) {

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
			password.getPassword().add(cbox.generateChar(duplicates, sort, generateSame, generateAll, forbiddenChar));

		} 
		
		//bij index 3
		else if (indexToAdd % 2 != 0) {

			if (password.lastIsDuplicate()) {
				duplicate = password.getDuplicate();
				duplicates.add(duplicate);
			}

			if (password.areSameSort(3)) {
				generateSame = false;
				sort = password.getSort(indexToAdd - 1);
				
			} else if (password.areSameSort(2)) {
				// laatste 2 checken
				generateSame = true;
				sort = password.getSort(indexToAdd - 1);

				if (password.isSequence()) {
					forbiddenChar = password.getForbiddenChar();
				}
			}
			
			password.getPassword().add(cbox.generateChar(duplicates, sort, generateSame, generateAll, forbiddenChar));

		}
		
		//bij anders... maar met welke % met restwaarde?
		else if (indexToAdd > 4) {
			password.getPassword().add(cbox.generateChar(duplicates, sort, generateSame, generateAll, forbiddenChar));

		}

	}

}
