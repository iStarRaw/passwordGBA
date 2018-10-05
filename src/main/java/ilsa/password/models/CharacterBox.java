package ilsa.password.models;

/**
 * @author ilsadejager Class that defines the characters out of which the password
 *         will be made (Extended ASCII).
 *
 */
public class CharacterBox {

	// 65 tm 90 en 97 tm 122
	private int[] letters = new int[52];
	// 48 tm 57
	private int[] digits = new int[10];
	// 1 tm 47 (32 NIET), 58 tm 64, 91 tm 96, 123 tm 254
	private int[] symbols = new int[91];
	
	
	public CharacterBox() {
		fillLetters();
	}
	
	
	
	
	public int[] getLetters() {
		return letters;
	}

	
	

	private void fillLetters() {
		// 65 tm 90
		for (int i =0; i < 26; i++) {
			letters[i] = 65 + i;
		}
		
		// 97 tm 122
		for (int i = 26, j = 0; i < 52; i ++, j++) {
			letters[i] = 97 + j;
		}
		
	}
	
	
	
	
	
	
	
}
