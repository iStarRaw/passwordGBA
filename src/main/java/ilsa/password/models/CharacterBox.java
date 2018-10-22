package ilsa.password.models;

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
		
	}
	
	private void deleteDigits() {
		// 48 tm 57
	}
	
	private void deleteSymbols() {
		// 0 tm 31
		// 33 tm 47
		// 58 tm 64
		// 91 tm 96
		// 123 tm 254
		
	}
	

	public int addChar(int index) {

		if (index < 2) {
			// pick from all possibilities
			return 0;
		}

//		if (!twoBeforeSame() && !duplicatesExist()) {
//			//pick from all possibilities
//		} else if (duplicatesExist()) {
//			//pick from all without the duplicate
//		}
//		
//		if (twoBeforeSame && threeBeforeSame()) {
//			if (duplicatesExist()) {
//				//pick from other sort without the duplicate
//			}
//			//pick from all possibilities
//		}
//		
//		//condition that two of the same type are not allowed together
//		if (twoBeforeSame()) {
//			if (duplicatesExist()) {
//				//pick from all without the duplicate
//			}
//			if (sequenceExists()) {
//				//pick same sort without lastChar +1 or -1
//			}
//			//pick the same sort
//		}
//		
//		
//		//condition that four of the same type are not allowed together
//		if (threeBeforeSame()) {
//			//pick another
//		}

		return 0;

	}

}
