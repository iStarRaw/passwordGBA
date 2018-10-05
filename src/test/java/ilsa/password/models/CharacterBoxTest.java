package ilsa.password.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CharacterBoxTest {
	
	

	
	@Test
	void testFillLetters() {
		CharacterBox cbox = new CharacterBox();	
		
		int expectedSize = 52;
		int actualSize = cbox.getLetterBox().length;
		
		assertEquals(expectedSize, actualSize);
	}
	
	@Test
	void testFillDigits() {
		CharacterBox cbox = new CharacterBox();	
		
		int expectedSize = 10;
		int actualSize = cbox.getDigitBox().length;
		
		assertEquals(expectedSize, actualSize);	
	}
	
	@Test
	void testFillSymbols() {
		CharacterBox cbox = new CharacterBox();	
		
		int expectedSize = 192;
		int actualSize = cbox.getSymbolBox().length;
		
		assertEquals(expectedSize, actualSize);	
	}
	

}
