package ilsa.password.generator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import ilsa.password.customexception.PasswordException;
import ilsa.password.models.Password;

public class PasswordGenerator {
	private Password password;
	private List<Character> box;
	private SecureRandom secGenerator = new SecureRandom();
	private List<Integer> excluded;
	private List<Character> duplicates;
	private final int MINIMUM_LENGTH = 8;

	public PasswordGenerator(int length) throws PasswordException {
		if (length < MINIMUM_LENGTH) {
			throw new PasswordException();
		}

		password = new Password(length);
		box = new ArrayList<>();
		duplicates = new ArrayList<>();
		excluded = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
				24, 25, 26, 27, 28, 29, 30, 31, 32, 48, 127, 129, 141, 143, 144, 157, 160, 173);
		fillBox();

		createPassword();
	}
	
	private void createPassword() {
		for (int i = 0; i < password.getLength(); i++) {
			addChar(i);

			System.out.printf("Index %d is: %c en is een %s\n", i, password.getPassword().get(i),
					password.getCharSort(i));
		}
		System.out.println(password.toHexString());

	}
	
	public Password getPassword() {
		return password;
	}

	private void addChar(int indexToAdd) {
		makeSelection(indexToAdd);
		char newChar = generateChar();
		password.addThisChar(newChar);

	}

	/**defines the characters out of which the password will be made (Extended ASCII). https://www.ascii-code.com.
	 * Uitgesloten zijn: 0 t/m 32, 48, 127, 129, 141, 143, 144, 157, 160, 173.
	 */     
	private void makeSelection(int indexToAdd) {
		if (indexToAdd >= 2) {
			boolean generateSame = false;
			boolean generateOther = false;
			char forbiddenChar = '\0';
			String lastCharName = password.getCharSort(indexToAdd - 1);

			checkDuplicates();

			// bij laatste index
			if (indexToAdd == password.getLength() - 1) {
				// bij 2 verschillende of 3 dezelfde een andere trekken
				if ((!password.areSameSort(2)) || (password.areSameSort(3))) {
					generateOther = true;

				} else if (password.areSameSort(2)) {
					generateSame = true;
				}

			} else if (password.areSameSort(2)) {
				if (!password.areSameSort(3) || indexToAdd == 2) {
					// 2 dezelfde mogen niet dus zelfde soort trekken.
					generateSame = true;

					if (password.isSequence()) {
						forbiddenChar = password.getForbiddenChar();
					}
				} else if (password.areSameSort(3)) {
					// 4 dezelfde mogen niet
					generateOther = true;

				}
			}
			prepareBox(lastCharName, generateSame, generateOther, forbiddenChar);

		}
	}
	
	private void prepareBox(String sort, boolean generateSame, boolean generateOther,
			char forbiddenChar) {
		makeFullBox();

		deleteDoubles();
		deleteSequenceChar(forbiddenChar);

		if (generateSame) {
			makeSameSortBox(sort);
		} else if (generateOther) {
			makeOtherSortsBox(sort);
		}
	}

	private void checkDuplicates() {
		char duplicate;
		if (password.lastIsDuplicate()) {
			duplicate = password.getDuplicate();
			duplicates.add(duplicate);
		}
	}
	
	private void fillBox() {
		for (int i = 1; i < 256; i++) {
			if (!excluded.contains(i)) {
				box.add((char) i);
			}
		}
	}

	private void makeFullBox() {
		this.box.clear();
		fillBox();
	}

	private void deleteLetters() {
		System.out.println("deleting letters");
		for (Iterator<Character> iterator = box.iterator(); iterator.hasNext();) {
			char c = iterator.next();
			if (Character.isLetter(c)) {
				iterator.remove();
			}
		}
	}

	private void deleteDigits() {
		System.out.println("deleting digits");
		for (Iterator<Character> iterator = box.iterator(); iterator.hasNext();) {
			char c = iterator.next();
			if (Character.isDigit(c)) {
				iterator.remove();
			}
		}
	}

	private void deleteOther() {
		System.out.println("deleting other");
		for (Iterator<Character> iterator = box.iterator(); iterator.hasNext();) {
			char c = iterator.next();
			if (!Character.isDigit(c) && !Character.isAlphabetic(c)) {
				iterator.remove();
			}
		}
	}

	private void deleteCharFromBox(char charToDelete) {
		for (int i = 0; i < this.box.size(); i++) {
			if (box.get(i) == charToDelete) {
				box.remove(box.remove(i));
			}
		}
	}

	private char generateChar() {
		int index = secGenerator.nextInt(this.box.size());

		while (index < 0 || index > this.box.size()) {
			index = secGenerator.nextInt(this.box.size());
		}
		return this.box.get(index);

	}

	private void deleteSequenceChar(char forbiddenChar) {
		if (forbiddenChar != 0) {
			deleteCharFromBox(forbiddenChar);
		}
	}

	private void deleteDoubles() {
		if (!duplicates.isEmpty()) {
			for (Character c : duplicates) {
				deleteCharFromBox(c);
			}
		}
	}

	private void makeSameSortBox(String onlyThis) {
		switch (onlyThis) {
		case "Digit":
			deleteLetters();
			deleteOther();

			break;
		case "Letter":
			deleteOther();
			deleteDigits();

			break;
		case "Other":
			deleteDigits();
			deleteLetters();

			break;
		}
	}

	private void makeOtherSortsBox(String without) {
		switch (without) {
		case "Digit":
			deleteDigits();

			break;
		case "Letter":
			deleteLetters();

			break;
		case "Other":
			deleteOther();

			break;
		}
	}

}
