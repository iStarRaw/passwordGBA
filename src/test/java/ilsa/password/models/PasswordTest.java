package ilsa.password.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


class PasswordTest {

	@Test
	void testIsSameSort() {
		Password pw = new Password(5);
		
		char one = '0';
		char two = '6';
		
		boolean actual = pw.compareSorts(one, two);
		
		assertTrue(actual);
		
	}
	
	

}
