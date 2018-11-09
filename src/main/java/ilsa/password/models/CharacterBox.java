package ilsa.password.models;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ilsadejager Class that defines the characters out of which the
 *         password will be made (Extended ASCII). Spatie (32), 0 (48) en delete
 *         (127) zijn uitgesloten.
 *
 */
public class CharacterBox {

	// alle characters in 1 arraylist stoppen
	// condities opstellen en dan box kleiner maken
	private List<Integer> box;
	private SecureRandom secGenerator = new SecureRandom();

	public CharacterBox() {
		box = new ArrayList<>();
		fillBox();

	}

	public List<Integer> getBox() {
		return box;
	}

	private void fillBox() {
		fillLetters();
		fillDigits();
		fillSymbols();
	}

	private void fillLetters() {
		// 65 tm 90
		for (int i = 0; i < 26; i++) {
			box.add(65 + i);
		}

		// 97 tm 122
		for (int i = 26, j = 0; i < 52; i++, j++) {
			box.add(97 + j);
		}

	}

	private void fillDigits() {
		// 49 tm 57 (48 NIET)
		for (int i = 0; i < 9; i++) {
			box.add(49 + i);
		}
	}

	// TODO checken na verandering
	private void fillSymbols() {
		// 33 tm 47
		for (int i = 0; i < 15; i++) {
			box.add(33 + i);
		}

		// 58 tm 64
		for (int i = 15, j = 0; i < 22; i++, j++) {
			box.add(58 + j);
		}

		// 91 tm 96
		for (int i = 22, j = 0; i < 28; i++, j++) {
			box.add(91 + j);
		}

		// 123 tm 254 (127 NIET)
		for (int i = 28, j = 0; i < 160; i++, j++) {
			if (j != 4) {
				box.add(123 + j);
			}
		}
	}

	private void returnToFullBox() {
		this.box.clear();
		fillBox();
	}

	private void deleteLetters() {
		// 65 tm 90, 97 tm 122
		for (int i = 0; i < this.box.size(); i++) {
			if (box.get(i) >= 65 && box.get(i) <= 90 || box.get(i) >= 97 && box.get(i) <= 122) {
				box.remove(i);
			}
		}

	}

	private void deleteDigits() {
		// 49 tm 57
		for (int i = 0; i < this.box.size(); i++) {
//			char someChar = (char)Integer.parseInt(String.valueOf(digit));
//			if (!Character.isDigit(someChar)) {
			if (box.get(i) <= 49 && box.get(i) <= 57) {
				box.remove(i);
			}
		}
	}

	// TODO checken na verandering symbol fill box
	private void deleteSymbols() {
		// 33 tm 47, 58 tm 64, 91 tm 96, 123 tm 254
		for (int i = 0; i < this.box.size(); i++) {
			if (box.get(i) >= 33 && box.get(i) <= 47 || box.get(i) >= 58 && box.get(i) <= 64 || box.get(i) >= 91 && box.get(i) <= 96
					|| box.get(i) >= 123 && box.get(i) <= 254) {
				box.remove(i);
			}
		}

	}

	private void deleteInt(int intToDelete) {
		for (int i = 0; i < this.box.size(); i++) {
			if (box.get(i) == intToDelete) {
				box.remove(box.remove(i));
			}
		}
		
	}

	public int generateChar() {
		int index = secGenerator.nextInt(this.box.size());

		while (index < 0 || index > this.box.size()) {
			index = secGenerator.nextInt(this.box.size());
		}
		return this.box.get(index);

	}

	public int generateChar(List<Integer> doubles, String sort, boolean generateSame, boolean generateAll,
			int forbiddenInt) { // generateAll toevoegen in passwordGenerator als sort niet uit maakt?

		returnToFullBox();
		
		if (!doubles.isEmpty()) {
			// delete double inhoud uit box
			for (Integer number : doubles) {
				deleteInt(number);
			}
		}

		if (generateAll) {
			return generateChar();
		}

		if (forbiddenInt != 0) {
			// generate without sequenceInt
			deleteInt(forbiddenInt);
		}

		if (generateSame) {
			boxSameSort(sort);
		}
		boxOtherSorts(sort);

		return generateChar();

	}

	private void boxSameSort(String nameSort) {
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

	private void boxOtherSorts(String nameSort) {
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
