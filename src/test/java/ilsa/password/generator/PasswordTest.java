package ilsa.password.generator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Test;

import ilsa.password.exception.PasswordException;

class PasswordTest {

	@Test
	void testGenerateLength() {
		 Password pwd = Password.generate(8);
		 assertNotNull(pwd);
		 assertEquals(8, pwd.getPassword().size());
	}
	
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
	void testAddThisCharEmptyListThrowsException() {
		Password pw = new Password(0);
		char thisChar = '3';

		assertThrows(PasswordException.class, () -> {
			pw.addThisChar(thisChar);
		});
	}
	
	@Test
	void testAddThisCharNotAllowed() {
		Password pw = new Password(1);
		char thisChar = '∇'; //not ASCII < 256
		
		assertThrows(InputMismatchException.class, () -> {
			pw.addThisChar(thisChar);
		});
	}
	

	@Test
	void testAreSameTypeTrue() {
		Password pw = new Password(6);
		char char0 = '@';
		char char1 = 'a';
		char char2 = 'r';
		char char3 = '3';
		char char4 = '4';
		char char5 = '0';

		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		pw.addThisChar(char4);
		pw.addThisChar(char5);

		boolean actual = pw.areSameType(3);
		assertTrue(actual);

	}

	@Test
	void testAreSameTypeFalse() {
		Password pw = new Password(6);
		char char0 = '@';
		char char1 = 'a';
		char char2 = 'r';
		char char3 = 'p';
		char char4 = '4';
		char char5 = ';';

		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);
		pw.addThisChar(char4);
		pw.addThisChar(char5);

		boolean actual = pw.areSameType(3);
		assertFalse(actual);

	}

	@Test
	void testAreSameTypeZeros() {
		Password pw = new Password(3);
		char char0 = '0';
		char char1 = '0';
		char char2 = '0';

		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);

		boolean actual0 = pw.areSameType(2);
		boolean actual1 = pw.areSameType(3);

		assertTrue(actual0);
		assertTrue(actual1);
	}
	
	@Test
	void testAreSameTypeEmptyListThrowsException() {
		Password pw = new Password(0);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			pw.areSameType(2);
		});
	}

	@Test
	void testLastIsDuplicateTrue() {
		Password pw = new Password(4);
		char char0 = 'k';
		char char1 = '0';
		char char2 = 'a';
		char char3 = 'a';

		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);

		boolean actual = pw.lastIsDuplicate();
		assertTrue(actual);

	}

	@Test
	void testLastIsDuplicateFalse() {
		Password pw = new Password(4);
		char char0 = 'k';
		char char1 = '0';
		char char2 = '@';
		char char3 = 'a';

		pw.addThisChar(char0);
		pw.addThisChar(char1);
		pw.addThisChar(char2);
		pw.addThisChar(char3);

		boolean actual = pw.lastIsDuplicate();
		assertFalse(actual);

	}
	
	@Test
	void testLastIsDuplicateEmptyList() {
		Password pw = new Password(0);

		boolean actual = pw.lastIsDuplicate();
		assertFalse(actual);

	}

	@Test
	void testGetCharType() {
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
	void testGetCharTypeEmptyListThrowsException() {
		Password pw = new Password(0);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			pw.getCharSort(2);
		});
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
	void testIsSequenceEmptyList() {
		Password pw = new Password(0);
		
		boolean actual = pw.isSequence();
		assertFalse(actual);

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
		Password pw = new Password(2);
		char char0 = '2';
		char char1 = '7';

		pw.addThisChar(char0);
		pw.addThisChar(char1);

		boolean actual = pw.isSequence();
		assertFalse(actual);

	}

	@Test
	void testGetForbiddenCharDigitUp() {
		Password pw = new Password(2);
		char char0 = '2';
		char char1 = '3';

		pw.addThisChar(char0);
		pw.addThisChar(char1);

		char actual = pw.getForbiddenChar();
		assertEquals('4', actual);

	}

	@Test
	void testGetForbiddenCharDigitDown() {
		Password pw = new Password(2);
		char char0 = '4';
		char char1 = '3';

		pw.addThisChar(char0);
		pw.addThisChar(char1);

		char actual = pw.getForbiddenChar();
		assertEquals('2', actual);

	}

	@Test
	void testGetForbiddenCharLetterUp() {
		Password pw = new Password(2);
		char char0 = 'a';
		char char1 = 'b';

		pw.addThisChar(char0);
		pw.addThisChar(char1);

		char actual = pw.getForbiddenChar();
		assertEquals('c', actual);

	}

	@Test
	void testGetForbiddenCharLetterDown() {
		Password pw = new Password(2);
		char char0 = 'z';
		char char1 = 'y';

		pw.addThisChar(char0);
		pw.addThisChar(char1);

		char actual = pw.getForbiddenChar();
		assertEquals('x', actual);

	}

	@Test
	void testGetForbiddenCharNone() {
		Password pw = new Password(2);
		char char0 = 'k';
		char char1 = 'r';

		pw.addThisChar(char0);
		pw.addThisChar(char1);

		char actual = pw.getForbiddenChar();
		assertEquals(0, actual);

	}
	
	@Test
	void testGetForbiddenCharEmptyList() {
		Password pw = new Password(0);
		
		char actual = pw.getForbiddenChar();
		assertEquals(0, actual);
	}

}
