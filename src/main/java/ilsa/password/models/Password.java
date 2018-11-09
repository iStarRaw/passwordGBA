package ilsa.password.models;

import java.util.ArrayList;
import java.util.List;

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

	public boolean areSameSort(int indexesToCheck) {
		boolean sameSort = true;
		int lastIndex = password.size() - 1;

		return areSameSortHelper(indexesToCheck, lastIndex, sameSort, 1);

	}

	// TODO checken!!!!! ook met JUnit
	public boolean areSameSortHelper(int totalToCheck, int lastIndexToCheck, boolean sameSort, int count) {
		if (count == totalToCheck) {
			return sameSort;
		}

		char lastChar = password.get(lastIndexToCheck);
		char beforeLastChar = password.get(lastIndexToCheck - 1);

		if ((Character.isDigit(lastChar) && Character.isDigit(beforeLastChar)) || 
		    (Character.isLetter(lastChar) && Character.isLetter(beforeLastChar)) || 
		    (!Character.isDigit(lastChar) && !Character.isLetter(lastChar)) &&
		    (!Character.isDigit(beforeLastChar) && !Character.isLetter(beforeLastChar))) {

			boolean tempSort = true;

			if (sameSort && tempSort) {
				sameSort = true;
			}
			sameSort = false;
		}
		count++;

		return areSameSortHelper(totalToCheck, lastIndexToCheck - 1, sameSort, count);

	}

	public boolean lastIsDuplicate() {
		if (password.size() < 1) {
			return false;
		}

		for (int i = 0; i < password.size() - 1; i++) {
			if (password.get(i) == password.get(password.size() - 1)) {
				return true;
			}
		}
		return false;

	}

	public char getDuplicate() {
		return password.get(password.size() - 1);
	}

	// TODO met ranges werken van cbox???
	public String getSort(int index) {
		char toCheck = (char) index;

		if (Character.isDigit(toCheck)) {
			return "Digit";
		} else if (Character.isLetter(toCheck)) {
			return "Letter";
		}
		return "Symbol";

	}

	public boolean isSequence() {
		if (password.size() < 2) {
			return false;
		}

		int lastValue = password.get(password.size() - 1);
		int beforeLastValue = password.get(password.size() - 2);

		if (!Character.isLetter(lastValue) && !Character.isDigit(lastValue)) {
			return false;
		}
		
		if (lastValue == beforeLastValue - 1) {
			return true;
		}

		if (lastValue == beforeLastValue + 1) {
			return true;
		}

		return false;

	}

	public char getForbiddenChar() {
		int lastCharInt = (int)password.get(password.size() - 1);
		int beforeLastCharInt = (int)password.get(password.size() - 2);

		if (lastCharInt == beforeLastCharInt + 1) {
			
			return (char)(lastCharInt + 1);
		} else if (lastCharInt == beforeLastCharInt - 1) {
			
			return (char)(lastCharInt - 1);
		}

		return 0;
	}

	public byte[] toByteArray() {
		byte[] bytes = new byte[password.size()];

		for (int i = 0; i < bytes.length; i++) {
			Integer charInt = (int)password.get(i);
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
			int item = (int)c;
			String hexString1 = String.format("0x%02X", item);
			String hexString2 = String.format("%04X", item);
			String hexString3 = Integer.toHexString(item);
			passwordString.append(String.format("%s, %s, %s\n", hexString1, hexString2, hexString3));

		}
		return passwordString.toString();

	}

}
