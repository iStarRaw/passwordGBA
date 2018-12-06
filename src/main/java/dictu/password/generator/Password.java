package dictu.password.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that holds the password in the form of a Character List. It has methods
 * that add chars and compare chars in this List.
 * 
 * @author Dictu
 *
 */
public class Password {
	private static final int MIN_LENGTH = 2;
	private static final int THREE_TO_CHECK = 3;
	private static final int SECOND_CHAR = 1;
	private int length;
	private List<Character> password;

	public Password(int length) {
		this.length = length;
		this.password = new ArrayList<>();
	}

	/**
	 * Password will be generated with the length given.
	 * 
	 * @param length
	 * @return List
	 */
	public static Password generate(int length) {
		PasswordGenerator pg = new PasswordGenerator(length);
		return pg.getPassword();
	}

	/**
	 * Adds an admitted char to the password List.
	 * 
	 * @param thisChar
	 */
	void addAdmitted(char thisChar) {
		this.password.add(thisChar);

	}

	/**
	 * Checks if the values of the number of indexes given (coming from the last
	 * index), are of the same character type.
	 * 
	 * @param amount
	 * @return boolean
	 */
	boolean areSameType(int amount) {
		final int limitIndex = password.size() - amount;
		int lastIndex = password.size() - 1;

		if (lastIndex == SECOND_CHAR && amount == THREE_TO_CHECK) {
			return false;
		}

		for (int i = lastIndex; i > limitIndex; i--) {
			int beforeLastIndex = lastIndex - 1;
			char lastChar = password.get(lastIndex);
			char beforeLastChar = password.get(beforeLastIndex);
			boolean result = isSameType(lastChar, beforeLastChar);

			if (!result) {
				return false;
			}

			lastIndex--;

			if (lastIndex == 0 || beforeLastIndex == 0) {
				return result;
			}
		}
		return true;
	}

	/**
	 * Gets name of the type (Digit/Letter/Other) of the char given and returns this
	 * in a String.
	 * 
	 * @param index
	 * @return String
	 */
	String getCharType(int index) {
		char toCheck = password.get(index);

		if (Character.isDigit(toCheck)) {
			return "Digit";
		} else if (Character.isAlphabetic(toCheck)) {
			return "Letter";
		}
		return "Other";

	}

	/**
	 * If last char is a duplicate, it returns this value.
	 * 
	 * @return char
	 */
	char getDuplicate() {
		return password.get(password.size() - 1);
	}

	/**
	 * If the last two chars(the int representations) are a sequence, the next int
	 * in sequence will be given back as a char. 0 is returned if no forbiddenChar
	 * exists.
	 * 
	 * @return char
	 */
	char getForbiddenChar() {
		if (password.size() < MIN_LENGTH) {
			return 0;
		}

		final int lastCharInt = (int) password.get(password.size() - 1);
		final int beforeLastCharInt = (int) password.get(password.size() - 2);

		if (lastCharInt == beforeLastCharInt + 1) {

			return (char) (lastCharInt + 1);
		} else if (lastCharInt == beforeLastCharInt - 1) {

			return (char) (lastCharInt - 1);
		}

		return 0;
	}

	public int getLength() {
		return length;
	}

	public List<Character> getPassword() {
		return password;
	}

	/**
	 * Checks if two chars are of the same type (digit and alphabetic). Symbol is
	 * not of importance and not checked upon.
	 * 
	 * @param lastChar
	 * @param beforeLastChar
	 * @return boolean
	 */
	boolean isSameType(char lastChar, char beforeLastChar) {
		return (Character.isDigit(lastChar) && Character.isDigit(beforeLastChar))
				|| (Character.isAlphabetic(lastChar) && Character.isAlphabetic(beforeLastChar));
	}

	/**
	 * Checks if the two last chars are in sequence (in case they are both numbers
	 * or digits). For example in the case of ab, ba, 12, or 21 false is being
	 * returned.
	 * 
	 * @return boolean
	 */
	boolean isSequence() {
		if (password.size() < MIN_LENGTH) {
			return false;
		}

		final char lastValue = password.get(password.size() - 1);
		final char beforeLastValue = password.get(password.size() - 2);

		if (!Character.isAlphabetic(lastValue) && !Character.isDigit(lastValue)) {
			return false;
		}

		if ((int) lastValue == (int) beforeLastValue - 1 || (int) lastValue == (int) beforeLastValue + 1) {
			return true;
		}
		return false;

	}

	/**
	 * Checks if the value of the last index is a duplication of another value in
	 * the password.
	 * 
	 * @return boolean
	 */
	boolean lastIsDuplicate() {
		if (password.size() < MIN_LENGTH) {
			return false;
		}

		final int lastIndex = password.size() - 1;
		final char lastValue = password.get(lastIndex);

		for (int i = 0; i < password.size() - 1; i++) {
			if (Character.compare(password.get(i), lastValue) == 0) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Gives back the password in a binary string.
	 * 
	 * @return String
	 */
	public String toBinaryString() {
		StringBuilder binaryString = new StringBuilder();
		for (Character c : password) {
			String binary = Integer.toBinaryString(c);
			binaryString.append(String.format("%s, ", binary));
		}
		int withoutComma = binaryString.length() - 2;
		binaryString.setLength(withoutComma);

		return binaryString.toString();

	}

	/**
	 * Gives back the password in a byte array.
	 * 
	 * @return byte[]
	 */
	public byte[] toByteArray() {
		byte[] bytes = new byte[password.size()];

		for (int i = 0; i < bytes.length; i++) {
			Integer charInt = (int) password.get(i);
			bytes[i] = charInt.byteValue();
		}

		return bytes;
	}

	/**
	 * Gives back the password in a hex format.
	 * 
	 * @return String
	 */
	public String toHexString() {
		StringBuilder passwordString = new StringBuilder();
		for (Character c : password) {
			int item = (int) c;
			String hexString = Integer.toHexString(item);
			passwordString.append(String.format("%s\n", hexString));

		}
		return passwordString.toString();

	}

}
