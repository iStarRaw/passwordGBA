package ilsa.password.generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordTest {

	@Test
	void testAddThisChar() {
		Password pw = new Password(8);

		char thisChar = 'k';
		char otherChar = '0';
		pw.addThisChar(thisChar);
		pw.addThisChar(otherChar);

		char actual = pw.getPassword().get(0);
		char otherActual = pw.getPassword().get(1);

		assertEquals(thisChar, actual);
		assertEquals(otherChar, otherActual);

	}

	@Test
	void testIsSameSortFalse() {
		Password pw = new Password(4);

		char thisChar = 'k';
		char otherChar = '0';
		
		boolean actual = pw.isSameSort(thisChar, otherChar);

		assertFalse(actual);
		
	}
	
	@Test
	void testIsSameSortTrue() {
		Password pw = new Password(4);

		char thisChar = '4';
		char otherChar = '0';
		
		boolean actual = pw.isSameSort(thisChar, otherChar);

		assertTrue(actual);
	}

	@Test
	void testAreSameSort() {

	}

}
