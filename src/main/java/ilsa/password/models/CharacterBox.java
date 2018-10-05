package ilsa.password.models;

/**
 * @author ilsadejager Class that defines the characters out of which the
 *         password will be made (Extended ASCII).
 *
 */
public class CharacterBox {

	// 65 tm 90 en 97 tm 122
	private int[] letters = new int[52];
	// 48 tm 57
	private int[] digits = new int[10];
	// 0 tm 47 (32 NIET), 58 tm 64, 91 tm 96, 123 tm 254
	private int[] symbols = new int[92];

	public CharacterBox() {
		fillLetters();
		fillDigits();
		fillSymbols();
	}

	public int[] getLetters() {
		return letters;
	}

	private void fillLetters() {
		// 65 tm 90
		for (int i = 0; i < 26; i++) {
			letters[i] = 65 + i;
		}

		// 97 tm 122
		for (int i = 26, j = 0; i < 52; i++, j++) {
			letters[i] = 97 + j;
		}

	}

	private void fillDigits() {
		// 48 tm 57
		for (int i = 0; i < 10; i++) {
			digits[i] = 48 + i;
		}
	}
	
	private void fillSymbols() {
		// 0 tm 47 (32 NIET)
		for (int i=0;i<48; i++) {
			if (i==32) {
				continue;
			}
			symbols[i] = i;
		}
		
		//58 tm 64
		for (int i=48,j=0; i<55; i++,j++) {
			symbols[i] = 58 + j;
		}
		
		//91 tm 96
		for (int i=55, j=0;i<61;i++,j++) {
			symbols[i] = 91 + j;
		}
		
		//123 tm 254
		for (int i =61, j=0; i<192;i++,j++) {
			symbols[i] = 123 + j;
		}
		
		
		
		
	}

}
