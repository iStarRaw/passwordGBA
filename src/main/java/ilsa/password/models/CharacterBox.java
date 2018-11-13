package ilsa.password.models;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ilsadejager Class that defines the characters out of which the
 *         password will be made (Extended ASCII).
 *         https://www.ascii-code.com. Uitgesloten zijn: 0 t/m 32, 48, 127, 129,
 *         141, 143, 144, 157, 160, 173.
 *
 */
public class CharacterBox {

	// alle characters in 1 arraylist stoppen
	// condities opstellen en dan box kleiner maken
	private List<Character> box;
	private SecureRandom secGenerator = new SecureRandom();
	private List<Integer> excluded;

	public CharacterBox() {
		box = new ArrayList<>();
		excluded = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,48,127,129,141,143,144,157,160,173);
		fillBox();

	}

	public List<Character> getBox() {
		return box;
	}	
	
	private void fillBox() {
		for (int i = 1; i < 256; i++) {
			if (!excluded.contains(i)) {
			box.add((char)i);
			}
		}
	}
	


	private void returnToFullBox() {
		this.box.clear();
		fillBox();
	}

	private void deleteLetters() {
		for (int i = 0; i < this.box.size(); i++) {
			if (Character.isLetter(this.box.get(i))) {
				box.remove(i);
			}
		}
	}

	private void deleteDigits() {
		for (int i = 0; i < this.box.size(); i++) {
			if (Character.isDigit(this.box.get(i)))
				box.remove(i);
		}
	}

	private void deleteSymbols() {
		for (int i = 0; i < this.box.size(); i++) {
			if (!Character.isDigit(this.box.get(i)) && !Character.isLetter(this.box.get(i))) {
				box.remove(i);
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

	public char generateChar() {
		int index = secGenerator.nextInt(this.box.size());

		while (index < 0 || index > this.box.size()) {
			index = secGenerator.nextInt(this.box.size());
		}
		return this.box.get(index);

	}

	public char generateChar(List<Character> doubles, String sort, boolean generateSame,char forbiddenChar) { // generateAll toevoegen in passwordGenerator als sort niet uit maakt?

		returnToFullBox();

		if (!doubles.isEmpty()) {
			for (Character c : doubles) {
				deleteCharFromBox(c);
			}
		}

		if (forbiddenChar != 0) {
			// generate without sequenceInt
			deleteCharFromBox(forbiddenChar);
		}

		if (generateSame) {
			makeSameSortBox(sort);
		}
		makeOtherSortsBox(sort);

		return generateChar();

	}

	private void makeSameSortBox(String nameSort) {
		switch (nameSort) {
		case "Digit":
			deleteLetters();
			deleteSymbols();

			break;
		case "Letter":
			deleteSymbols();
			deleteDigits();

			break;
		case "Symbol":
			deleteDigits();
			deleteLetters();

			break;
		}

	}

	private void makeOtherSortsBox(String nameSort) {
		switch (nameSort) {
		case "Digit":
			deleteDigits();

			break;
		case "Letter":
			deleteLetters();

			break;
		case "Symbol":
			deleteSymbols();

			break;
		}
	}

}
