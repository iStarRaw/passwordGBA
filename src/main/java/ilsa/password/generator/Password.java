package ilsa.password.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dictu
 *
 */
public class Password {
	private int length;
	private List<Character> password;

	public Password(int length) {
		this.length = length;
		this.password = new ArrayList<>();
	}

	public List<Character> getPassword() {
		return password;
	}

	public int getLength() {
		return length;
	}

	/**
	 * Adds a char to the password.
	 * 
	 * @param thisChar
	 */
	public void addThisChar(char thisChar) {
		this.password.add(thisChar);
	}

	/**
	 * Checks if the values of the number of indexes given, are of the same sort.
	 * 
	 * @param amount
	 * @return boolean
	 */
	public boolean areSameSort(int amount) {
		int limitIndex = password.size() - amount;
		int lastIndex = password.size() - 1;

		if (lastIndex == 1 && amount == 3) {
			return false;
		}

		for (int i = lastIndex; i > limitIndex; i--) {
			int beforeLastIndex = lastIndex - 1;
			char lastChar = password.get(lastIndex);
			char beforeLastChar = password.get(beforeLastIndex);
			boolean result = isSameSort(lastChar, beforeLastChar);

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
	 * Checks if two chars are of the same sort (digit and alphabetic). Symbol is
	 * not of importance and not checked upon.
	 * 
	 * @param lastChar
	 * @param beforeLastChar
	 * @return boolean
	 */
	private boolean isSameSort(char lastChar, char beforeLastChar) {
		return ((Character.isDigit(lastChar) && Character.isDigit(beforeLastChar))
				|| (Character.isAlphabetic(lastChar) && Character.isAlphabetic(beforeLastChar)));
	}

	/**
	 * Checks if the value of the last index is a duplication of another value in
	 * the password.
	 * 
	 * @return boolean
	 */
	public boolean lastIsDuplicate() {
		if (password.size() < 2) {
			return false;
		}

		char lastValue = password.get(password.size() - 1);
		for (int i = 0; i < password.size() - 1; i++) {
			if (Character.compare(password.get(i), lastValue) == 0) {
				return true;
			}
		}
		return false;

	}

	/**
	 * If last char is a duplicate, it returns this value.
	 * 
	 * @return char
	 */
	public char getDuplicate() {
		return password.get(password.size() - 1);
	}

	/**
	 * Gets name of the sort (Digit/Letter/Other) of the char given and returns this
	 * in a String.
	 * 
	 * @param index
	 * @return String
	 */
	public String getCharSort(int index) {
		char toCheck = password.get(index);

		if (Character.isDigit(toCheck)) {
			return "Digit";
		} else if (Character.isAlphabetic(toCheck)) {
			return "Letter";
		}
		return "Other";

	}

	/**
	 * Checks if the two last chars are in sequence (in case they are both numbers
	 * or digits). For example in the case of ab, ba, 12, or 21 false is being
	 * returned.
	 * 
	 * @return boolean
	 */
	public boolean isSequence() {
		if (password.size() < 1) {
			return false;
		}

		char lastValue = password.get(password.size() - 1);
		char beforeLastValue = password.get(password.size() - 2);

		if (!Character.isAlphabetic(lastValue) && !Character.isDigit(lastValue)) {
			return false;
		}

		if ((int) lastValue == (int) beforeLastValue - 1) {
			return true;
		}

		if ((int) lastValue == (int) beforeLastValue + 1) {
			return true;
		}

		return false;

	}

	/**
	 * If the last two chars(the int representations) are a sequence, the next int
	 * in sequence will be given back as a char. 0 is returned if no
	 * forbiddenChar exists.
	 * 
	 * @return char
	 */
	public char getForbiddenChar() {
		if (password.size() < 1) {
			return 0;
		}

		int lastCharInt = (int) password.get(password.size() - 1);
		int beforeLastCharInt = (int) password.get(password.size() - 2);

		if (lastCharInt == beforeLastCharInt + 1) {

			return (char) (lastCharInt + 1);
		} else if (lastCharInt == beforeLastCharInt - 1) {

			return (char) (lastCharInt - 1);
		}

		return 0;
	}

	public byte[] toByteArray() {
		byte[] bytes = new byte[password.size()];

		for (int i = 0; i < bytes.length; i++) {
			Integer charInt = (int) password.get(i);
			bytes[i] = charInt.byteValue();
		}

		return bytes;
	}

	public String toBinaryString() {
		StringBuilder binaryString = new StringBuilder();
		for (Character c : password) {

			String binary = Integer.toBinaryString(c);
			binaryString.append(String.format("%s, ", binary));

		}
		return binaryString.toString();

	}

	public String toHexString() {
		StringBuilder passwordString = new StringBuilder();
		for (Character c : password) {
			int item = (int) c;
			String hexString = Integer.toHexString(item);
			passwordString.append(String.format("%s\n", hexString));

		}
		return passwordString.toString();

	}

	/**
	 * Password will be generated with the length given.
	 * @param length
	 * @return List
	 */
	public static Password generate(int length) {
		PasswordGenerator pg = new PasswordGenerator(length);
		return pg.getPassword();
	}

}
