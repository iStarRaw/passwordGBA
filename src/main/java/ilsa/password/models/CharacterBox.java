package ilsa.password.models;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ilsadejager Class that defines the characters out of which the
 *         password will be made (Extended ASCII).
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
		// 48 tm 57
		for (int i = 0; i < 10; i++) {
			box.add(48 + i);
		}
	}

	private void fillSymbols() {
		// 0 tm 31 (32 NIET)
		for (int i = 0; i < 32; i++) {
			box.add(i);
		}

		// 33 tm 47
		for (int i = 32, j = 0; i < 47; i++, j++) {
			box.add(33 + j);
		}

		// 58 tm 64
		for (int i = 47, j = 0; i < 54; i++, j++) {
			box.add(58 + j);
		}

		// 91 tm 96
		for (int i = 54, j = 0; i < 60; i++, j++) {
			box.add(91 + j);
		}

		// 123 tm 254
		for (int i = 60, j = 0; i < 192; i++, j++) {
			box.add(123 + j);
		}

	}
	
	
	private void deleteLetters() {
		// 65 tm 90
		// 97 tm 122
		for (Integer digit : this.box) {
			if (digit >= 65 && digit <= 90 || digit >= 97 && digit <= 122) {
				box.remove(digit);
			}
		}
		
	}
	
	private void deleteDigits() {
		// 48 tm 57
		for (Integer digit : this.box) {
			if (digit >= 48 && digit <= 57) {
				box.remove(digit);
			}
		}
	}
	
	private void deleteSymbols() {
		// 0 tm 31
		// 33 tm 47
		// 58 tm 64
		// 91 tm 96
		// 123 tm 254
		for (Integer digit : this.box) {
			if (digit >= 0 && digit <= 31 || digit >= 33 && digit <= 47 || digit >= 58 && digit <= 64 || digit >= 91 && digit <= 96 || digit >= 123 && digit <= 254) {
				box.remove(digit);
			}
		}
		
	}
	

	
	
	public int generateFromAll() {
		int index = secGenerator.nextInt(box.size());

		while (index < 0 || index > box.size()) {
			index = secGenerator.nextInt(box.size());
		}
		return box.get(index);
		
	}

}
