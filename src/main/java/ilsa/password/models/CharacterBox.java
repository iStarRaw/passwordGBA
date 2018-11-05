package ilsa.password.models;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ilsadejager Class that defines the characters out of which the
 *         password will be made (Extended ASCII). Spatie (32), 0 (48) en delete (127) zijn
 *         uitgesloten.
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
		for (Integer digit : this.box) {
			if (digit >= 65 && digit <= 90 || digit >= 97 && digit <= 122) {
				box.remove(digit);
			}
		}

	}

	private void deleteDigits() {
		// 49 tm 57
		for (Integer digit : this.box) {
//			char someChar = (char)Integer.parseInt(String.valueOf(digit));
//			if (!Character.isDigit(someChar)) {
			if (digit >= 49 && digit <= 57) {
				box.remove(digit);
			}
		}
	}

	// TODO checken na verandering symbol fill box
	private void deleteSymbols() {
		// 33 tm 47, 58 tm 64, 91 tm 96, 123 tm 254
		for (Integer digit : this.box) {
			if (digit >= 33 && digit <= 47 || digit >= 58 && digit <= 64 || digit >= 91 && digit <= 96
					|| digit >= 123 && digit <= 254) {
				box.remove(digit);
			}
		}

	}

	private void deleteInt(int intToDelete) {
		for (Integer digit : this.box) {
			if (digit == intToDelete) {
				box.remove(digit);
			}
		}
	}

	public int generateChar() {
		int index = secGenerator.nextInt(box.size());

		while (index < 0 || index > box.size()) {
			index = secGenerator.nextInt(box.size());
		}
		return box.get(index);

	}

	// TODO aanpassen met in acht neming parameters
	public int generateChar(String sort, boolean generateSame, int forbiddenInt) {
		int index = secGenerator.nextInt(box.size());

		while (index < 0 || index > box.size()) {
			index = secGenerator.nextInt(box.size());
		}
		return box.get(index);

	}

	private int generateFrom(String nameSort) {
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
		return generateChar();

	}

}
