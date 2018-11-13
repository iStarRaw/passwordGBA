package ilsa.password.models;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ilsadejager Class that defines the characters out of which the
 *         password will be made (Extended ASCII, ISO LATIN-1).
 *         https://www.ascii-code.com. Uitgesloten zijn: 0 t/m 32, 48, 127, 129,
 *         141, 143, 144, 157, 160, 173.
 *
 */
public class CharacterBox {

	// alle characters in 1 arraylist stoppen
	// condities opstellen en dan box kleiner maken
	private List<Character> box;
	private SecureRandom secGenerator = new SecureRandom();

	public CharacterBox() {
		box = new ArrayList<>();
		fillBox();

	}

	public List<Character> getBox() {
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
			box.add((char) (65 + i));
		}
		// 97 tm 122
		for (int i = 26, j = 0; i < 52; i++, j++) {
			box.add((char) (97 + j));
		}

	}

	private void fillDigits() {
		// 49 tm 57
		for (int i = 0; i < 9; i++) {
			box.add((char) (49 + i));
		}
	}

	private void fillSymbols() {
		// 33 tm 47
		for (int i = 0; i < 15; i++) {
			box.add((char) (33 + i));
		}
		// 58 tm 64
		for (int i = 15, j = 0; i < 22; i++, j++) {
			box.add((char) (58 + j));
		}
		// 91 tm 96
		for (int i = 22, j = 0; i < 28; i++, j++) {
			box.add((char) (91 + j));
		}
		// 123 tm 126
		for (int i = 28, j = 0; i < 32; i++, j++) {
			box.add((char) (123 + j));
		}
		// t/m 255
		box.addAll(Arrays.asList('ÿ', 'þ', 'ý', 'ü', 'û', 'ú', 'ù', 'ø', '÷', 'ö', 'õ', 'ô', 'ó', 'ò', 'ñ', 'ð', 'ï',
				'î', 'í', 'ì', 'ë', 'ê', 'é', 'è', 'ç', 'æ', 'å', 'ä', 'ã', 'â', 'á', 'à', 'ß', 'Þ', 'Ý', 'Ü', 'Û', 'Ú',
				'Ù', 'Ø', '×', 'Ö', 'Õ', 'Ô', 'Ó', 'Ò', 'Ñ', 'Ð', 'Ï', 'Î', 'Í', 'Ì', 'Ë', 'Ê', 'É', 'È', 'Ç', 'Æ', 'Å',
				'Ä', 'Ã', 'Â', 'Á', 'À', '¿', '¾', '½', '¼', '»', 'º', '¹', '¸', '·', '¶', 'µ', '´', '³', '²', '±', '°',
				'¯', '®', '¬', '«', 'ª', '©', '¨', '§', '¦', '¥', '¤', '£', '¢', '¡', 'Ÿ', 'ž', 'œ', '›', 'š', '™', '˜',
				'—', '–', '•', '”', '“', '’', '‘', 'Ž', 'Œ', '‹', 'Š', '‰', 'ˆ', '‡', '†', '…', '„', 'ƒ', '‚', '€'));

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

	private void deleteChar(char charToDelete) {
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
			// delete double inhoud uit box
			for (Character c : doubles) {
				deleteChar(c);
			}
		}

		if (generateAll) {
			return generateChar();
		}

		if (forbiddenChar != 0) {
			// generate without sequenceInt
			deleteChar(forbiddenChar);
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
