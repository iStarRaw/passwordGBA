package ilsa.password.models;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


public class Password {
	private int length;
	private List<Integer> password; // omzetten naar bytes

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

	public boolean areSameSortHelper(int totalToCheck, int lastIndexToCheck, boolean sameSort, int count) {
		if (count == totalToCheck) {
			System.out.println("In stopconditie");
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

	// TODO check with junit
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
		// TODO Auto-generated method stub
		return false;
	}

	public int getForbiddenInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder passwordString = new StringBuilder();
		for (Integer number : password) {

//			String thisString = Character.toString((char)(int)number);

			String hexString = Integer.toHexString(number);
			System.out.println(hexString);
			
			
//			byte[] bytes = Hex.decodeHex(hexString.toCharArray());
//			System.out.println(new String(bytes, "UTF-8"));
			
			

		    String[] list=hexString.split("(?<=\\G.{2})");
	        ByteBuffer buffer= ByteBuffer.allocate(list.length);
	        System.out.println(list.length);
	        for(String str: list)
	            buffer.put((byte)Integer.parseInt(str,16));

	        buffer.array();

			passwordString.append(hexString);

		}
		return passwordString.toString();
	}

}
