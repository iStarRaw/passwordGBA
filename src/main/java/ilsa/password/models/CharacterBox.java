package ilsa.password.models;

/**
 * @author ilsadejager Class that defines the characters out of which the
 *         password will be made (Extended ASCII).
 *
 */
public class CharacterBox {

	// 65 tm 90 en 97 tm 122
	private int[] letterBox = new int[52];
	// 48 tm 57
	private int[] digitBox = new int[10];
	// 0 tm 47 (32 NIET), 58 tm 64, 91 tm 96, 123 tm 254
	private int[] symbolBox = new int[192];
	
	public CharacterBox() {
		fillLetters();
		fillDigits();
		fillSymbols();
		
	}
	

	public int[] getLetterBox() {
		return letterBox;
	}


	public int[] getDigitBox() {
		return digitBox;
	}


	public int[] getSymbolBox() {
		return symbolBox;
	}


	private void fillLetters() {
		// 65 tm 90
		for (int i = 0; i < 26; i++) {
			letterBox[i] = 65 + i;
		}

		// 97 tm 122
		for (int i = 26, j = 0; i < 52; i++, j++) {
			letterBox[i] = 97 + j;
		}

	}

	private void fillDigits() {
		// 48 tm 57
		for (int i = 0; i < 10; i++) {
			digitBox[i] = 48 + i;
		}
	}

	private void fillSymbols() {
		// 0 tm 31 (32 NIET)
		for (int i = 0; i < 32; i++) {
			symbolBox[i] = i;
		}

		// 33 tm 47
		for (int i = 32, j = 0; i < 47; i++, j++) {
			symbolBox[i] = 33 + j;
		}

		// 58 tm 64
		for (int i = 47, j = 0; i < 54; i++, j++) {
			symbolBox[i] = 58 + j;
		}

		// 91 tm 96
		for (int i = 54, j = 0; i < 60; i++, j++) {
			symbolBox[i] = 91 + j;
		}

		// 123 tm 254
		for (int i = 60, j = 0; i < 192; i++, j++) {
			symbolBox[i] = 123 + j;
		}

	}

}
