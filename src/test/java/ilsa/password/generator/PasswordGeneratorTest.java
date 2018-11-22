package ilsa.password.generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ilsa.password.customexception.PasswordException;

class PasswordGeneratorTest {

	@Test
	void testConstructor() {
		
	
	}

	

	@Test
	void exceptionTesting() {
	    // set up user
	    Throwable exception = expectThrows(PasswordException.class, () -> new PasswordGenerator(4));
	    assertEquals("Your password has to be 8 characters or more!", exception.getMessage());
	}
	
	
}
