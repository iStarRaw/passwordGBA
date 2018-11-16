package ilsa.password.generator;

import java.util.ArrayList;
import java.util.List;

import ilsa.password.customexception.TooSmallException;
import ilsa.password.models.CharacterBox;
import ilsa.password.models.Password;

public class PasswordGenerator {

	private Password password;
	private CharacterBox cbox;
	private List<Character> duplicates;

	public PasswordGenerator(int length) throws TooSmallException {
		if (length < 8) {
			throw new TooSmallException();
		}

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
		System.out.println(password.toHexString());

	}

	private void addChar(int indexToAdd) {
		boolean generateSame = false;
		boolean generateOther = false;
		String lastCharName = "";
		char forbiddenChar = '\0';

		if (indexToAdd < 2) {
			char newChar = cbox.generateChar();
			password.addThisChar(newChar);

		} else if (indexToAdd >= 2) {
			checkDuplicates();
			lastCharName = password.getSort(indexToAdd - 1);

			if (indexToAdd == password.getLength() - 1) {
				if (!password.areSameSort(2)) {
					generateOther = true;
				}

			} else if (password.areSameSort(2)) {
				if (password.areSameSort(3)) {
					// 4 dezelfde mogen niet
					generateOther = true;

				} else if (!password.areSameSort(3) || indexToAdd == 2) {
					// 2 dezelfde mogen niet dus zelfde soort trekken.
					generateSame = true;

					if (password.isSequence()) {
						forbiddenChar = password.getForbiddenChar();
					}
				}
			}
			cbox.prepareBox(duplicates, lastCharName, generateSame, generateOther, forbiddenChar);

			char newChar = cbox.generateChar();
			password.addThisChar(newChar);

		}
	}

	private void checkDuplicates() {
		char duplicate;
		if (password.lastIsDuplicate()) {
			duplicate = password.getDuplicate();
			duplicates.add(duplicate);
		}
	}

}
