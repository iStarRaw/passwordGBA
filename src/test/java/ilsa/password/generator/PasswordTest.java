package ilsa.password.generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordTest {

	@Test
	void testAddThisChar() {
		Password pw = new Password(2);
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
	void testAreSameSortTrue() {
		Password pw = new Password(6);
		char char1 = '@';
		char char2 = 'a';
		char char3 = 'r';
		char char4 = '3';
		char char5 = '4';
		char char6 = '0';
		
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		pw.addThisChar(char4);
		pw.addThisChar(char5);
		pw.addThisChar(char6);
		
		boolean actual = pw.areSameSort(3);
		assertTrue(actual);

	}
	
	@Test
	void testAreSameSortFalse() {
		Password pw = new Password(6);
		char char1 = '@';
		char char2 = 'a';
		char char3 = 'r';
		char char4 = 'p';
		char char5 = '4';
		char char6 = ';';
		
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		pw.addThisChar(char4);
		pw.addThisChar(char5);
		pw.addThisChar(char6);
		
		boolean actual = pw.areSameSort(3);
		assertFalse(actual);

	}
	
	@Test
	void testLastIsDuplicateTrue() {
		Password pw = new Password(4);
		char char1 = 'k';
		char char2 = '0';
		char char3 = 'a';
		char char4 = 'a';
		
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		pw.addThisChar(char4);
		
		boolean actual = pw.lastIsDuplicate();
		assertTrue(actual);
		
	}

	@Test
	void testLastIsDuplicateFalse() {
		Password pw = new Password(4);
		char char1 = 'k';
		char char2 = '0';
		char char3 = '@';
		char char4 = 'a';
		
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		pw.addThisChar(char4);
		
		boolean actual = pw.lastIsDuplicate();
		assertFalse(actual);
		
	}
	
	@Test
	void testGetCharSort() {
		Password pw = new Password(4);
		char char0 = 'k';
		char char1 = '0';
		char char2 = '@';
		char char3 = 'a';
		
		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		
		String actual1 = pw.getCharSort(1);
		String actual2 = pw.getCharSort(2);
		String actual3 = pw.getCharSort(3);
	
		assertEquals("Digit", actual1);
		assertEquals("Other", actual2);
		assertEquals("Letter", actual3);
		
	}
	
	@Test
	void testIsSequenceLetterDownTrue() {
		Password pw = new Password(4);
		char char0 = 'k';
		char char1 = '0';
		char char2 = 'd';
		char char3 = 'c';
		
		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		
		boolean actual = pw.isSequence();
		assertTrue(actual);
		
	}
	
	@Test
	void testIsSequenceLetterUpTrue() {
		Password pw = new Password(4);
		char char0 = 'k';
		char char1 = '0';
		char char2 = 'a';
		char char3 = 'b';
		
		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		
		boolean actual = pw.isSequence();
		assertTrue(actual);
		
	}
	
	@Test
	void testIsSequenceLetterFalse() {
		Password pw = new Password(4);
		char char0 = 'k';
		char char1 = '0';
		char char2 = 's';
		char char3 = 'c';
		
		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		
		boolean actual = pw.isSequence();
		assertFalse(actual);
		
	}
	
	@Test
	void testIsSequenceDigitDownTrue() {
		Password pw = new Password(4);
		char char0 = 'k';
		char char1 = '0';
		char char2 = '4';
		char char3 = '3';
		
		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		
		boolean actual = pw.isSequence();
		assertTrue(actual);
		
	}
	
	@Test
	void testIsSequenceDigitUpTrue() {
		Password pw = new Password(4);
		char char0 = 'k';
		char char1 = '0';
		char char2 = '6';
		char char3 = '7';
		
		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		
		boolean actual = pw.isSequence();
		assertTrue(actual);
		
	}
	
	@Test
	void testIsSequenceDigitFalse() {
		Password pw = new Password(4);
		char char0 = 'k';
		char char1 = '0';
		char char2 = '2';
		char char3 = '7';
		
		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		
		boolean actual = pw.isSequence();
		assertFalse(actual);
		
	}
	
	
	
	
	
	
	
}
