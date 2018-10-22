package ilsa.password.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CharacterBoxTest {
	
	

	
	@Test
	void testFillBox() {
		CharacterBox cbox = new CharacterBox();	
		
		int expectedSize = 52;
		int actualSize = cbox.getBox().size();
		
		assertEquals(expectedSize, actualSize);
	}
	
	
	

}
