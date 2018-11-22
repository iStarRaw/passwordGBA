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

}
