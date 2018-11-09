package ilsa.password.models;

import java.util.ArrayList;
import java.util.List;

public class Password {
	private int length;
	private List<Integer> password;

	public Password(int length) {
		this.length = length;
		this.password = new ArrayList<>();
	}

	public List<Integer> getPassword() {
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

	// TODO check with JUnit
	public boolean areSameSortHelper(int totalToCheck, int lastIndexToCheck, boolean sameSort, int count) {
		if (count == totalToCheck) {
//			System.out.println("In stopconditie");
			return sameSort;
		}

		char lastChar = (char) Integer.parseInt(String.valueOf(password.get(lastIndexToCheck)));
		char charToComp = (char) Integer.parseInt(String.valueOf(password.get(lastIndexToCheck - 1)));

		if (Character.isDigit(lastChar) && Character.isDigit(charToComp)
				|| Character.isLetter(lastChar) && Character.isLetter(charToComp)
				|| !Character.isDigit(lastChar) && !Character.isLetter(lastChar) && !Character.isDigit(charToComp)
						&& !Character.isLetter(charToComp)) {

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

	public int getDuplicate() {
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

		if (lastValue == beforeLastValue - 1) {
			return true;
		}

		if (lastValue == beforeLastValue + 1) {
			return true;
		}

		return false;

	}

	public int getForbiddenInt() {
		int lastValue = password.get(password.size() - 1);
		int beforeLastValue = password.get(password.size() - 2);

		if (lastValue == beforeLastValue + 1) {
			return lastValue + 1;
		} else if (lastValue == beforeLastValue - 1) {
			return lastValue - 1;
		}

		return 0;
	}

	public byte[] toByteArray() {
		byte[] bytes = new byte[password.size()];

		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = password.get(i).byteValue();
		}

		return bytes;
	}

	public String toBinaryString() {
		StringBuilder binaryString = new StringBuilder();
		for (Integer number : password) {

			String binary = Integer.toBinaryString(number);
			binaryString.append(String.format("%s, ", binary));

		}
		return binaryString.toString();

	}

	public String toHexString() {
		StringBuilder passwordString = new StringBuilder();
		for (Integer number : password) {

			String hexString = Integer.toHexString(number);
			passwordString.append(String.format("%s\n", hexString));

		}
		return passwordString.toString();

	}

}
