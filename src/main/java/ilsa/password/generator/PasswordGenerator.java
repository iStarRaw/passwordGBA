package ilsa.password.generator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

import ilsa.password.exception.PasswordException;

public class PasswordGenerator {
	private Password password;
	private List<Character> box;
	private SecureRandom secGenerator = new SecureRandom();
	private List<Integer> excluded;
	private List<Character> duplicates;
	private final int MINIMUM_LENGTH = 8;

	public PasswordGenerator(int length) throws PasswordException {
		if (length < MINIMUM_LENGTH) {
			throw new PasswordException(String.format("Password has to be at least %d characters!", MINIMUM_LENGTH));
		}

		password = new Password(length);
		box = new ArrayList<>();
		duplicates = new ArrayList<>();
		excluded = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
				24, 25, 26, 27, 28, 29, 30, 31, 32, 48, 127, 129, 141, 143, 144, 157, 160, 173);
		fillBox();

		createPassword();
	}

	/**
	 * Creates a password. Chars are added to the list until the length given has
	 * been reached.
	 */
	private void createPassword() {
		for (int i = 0; i < password.getLength(); i++) {
			addChar(i);

		}
	}

	public Password getPassword() {
		return password;
	}

	/**
	 * Admitted char will be randomly generated and added to the given index in the
	 * password List.
	 * 
	 * @param indexToAdd
	 */
	private void addChar(int indexToAdd) throws InputMismatchException {
		makeSelection(indexToAdd);
		char newChar = generateChar();
		if ((int)newChar > 256) {
			throw new InputMismatchException("Character is not allowed!");
		}
		password.addThisChar(newChar);

	}

	/**
	 * Defines the admitted characters out of which the password will be made.
	 * 
	 * @param indexToAdd
	 */
	private void makeSelection(int indexToAdd) {
		if (indexToAdd >= 2) {
			boolean generateSame = false;
			boolean generateOther = false;
			char forbiddenChar = '\0';
			String lastCharName = password.getCharSort(indexToAdd - 1);

			checkDuplicates();

			if (password.areSameType(3)) {
				generateOther = true;
			} else if (password.areSameType(2) && !password.areSameType(3)) {
				generateSame = true;
			} else if (indexToAdd == password.getLength() - 1) {
				if ((!password.areSameType(2)) || (password.areSameType(3))) {
					generateOther = true;
				} else if (password.areSameType(2)) {
					generateSame = true;
				}
			}
			prepareBox(lastCharName, generateSame, generateOther, forbiddenChar);

		}
	}

	/**
	 * Determines if characters are not allowed to be generated. Starts with a full
	 * character box and deletes the prohibited characters.
	 * 
	 * @param charType
	 * @param generateSame
	 * @param generateOther
	 * @param forbiddenChar
	 */
	private void prepareBox(String charType, boolean generateSame, boolean generateOther, char forbiddenChar) {
		makeFullBox();

		deleteDoubles();
		deleteSequenceChar(forbiddenChar);

		if (generateSame) {
			makeSameTypeBox(charType);
		} else if (generateOther) {
			makeBoxWithout(charType);
		}
	}

	/**
	 * Checks if the last char is a duplicate and adds it to the duplicate List if
	 * so.
	 */
	private void checkDuplicates() {
		char duplicate;
		if (password.lastIsDuplicate()) {
			duplicate = password.getDuplicate();
			duplicates.add(duplicate);
		}
	}

	/**
	 * Character List (box) is filled with initial Characters (Extended ASCII).
	 * https://www.ascii-code.com. Excluded are: 0 to 32 inclusive, 48, 127, 129,
	 * 141, 143, 144, 157, 160, 173.
	 */
	private void fillBox() {
		for (int i = 1; i < 256; i++) {
			if (!excluded.contains(i)) {
				box.add((char) i);
			}
		}
	}

	/**
	 * Clears the existing list and fills it with the initial Characters.
	 */
	private void makeFullBox() {
		this.box.clear();
		fillBox();
	}

	/**
	 * Deletes all letters from the list.
	 */
	private void deleteLetters() {
		for (Iterator<Character> iterator = box.iterator(); iterator.hasNext();) {
			char c = iterator.next();
			if (Character.isLetter(c)) {
				iterator.remove();
			}
		}
	}

	/**
	 * Deletes all digits from the list.
	 */
	private void deleteDigits() {
		for (Iterator<Character> iterator = box.iterator(); iterator.hasNext();) {
			char c = iterator.next();
			if (Character.isDigit(c)) {
				iterator.remove();
			}
		}
	}

	/**
	 * Deletes all "other" (= no digit, no letter) from the list.
	 */
	private void deleteOther() {
		for (Iterator<Character> iterator = box.iterator(); iterator.hasNext();) {
			char c = iterator.next();
			if (!Character.isDigit(c) && !Character.isAlphabetic(c)) {
				iterator.remove();
			}
		}
	}

	/**
	 * Deletes the given char from the list.
	 * 
	 * @param charToDelete
	 */
	private void deleteCharFromBox(char charToDelete) {
		for (int i = 0; i < this.box.size(); i++) {
			if (box.get(i) == charToDelete) {
				box.remove(box.remove(i));
			}
		}
	}

	/**
	 * Generates a random char out of the list.
	 * 
	 * @return char
	 */
	private char generateChar() {
		int index = secGenerator.nextInt(this.box.size());

		while (index < 0 || index > this.box.size()) {
			index = secGenerator.nextInt(this.box.size());
		}
		return this.box.get(index);

	}

	/**
	 * Deletes the char, that is in sequence with the previous chars, from the list.
	 * 
	 * @param forbiddenChar
	 */
	private void deleteSequenceChar(char forbiddenChar) {
		if (forbiddenChar != 0) {
			deleteCharFromBox(forbiddenChar);
		}
	}

	/**
	 * Deletes the duplicates from the list.
	 */
	private void deleteDoubles() {
		if (!duplicates.isEmpty()) {
			for (Character c : duplicates) {
				deleteCharFromBox(c);
			}
		}
	}

	/**
	 * Deletes all other char types from the list. Only the given String character type
	 * remains.
	 * 
	 * @param onlyThisType
	 */
	private void makeSameTypeBox(String onlyThisType) {
		switch (onlyThisType) {
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

	/**
	 * Deletes the given character type from the list.
	 * 
	 * @param without
	 */
	private void makeBoxWithout(String without) {
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
