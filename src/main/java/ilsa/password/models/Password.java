package ilsa.password.models;

import java.util.ArrayList;
import java.util.List;

public class Password {
	private int length;
	private List<Integer> password;
	private boolean hasDuplicates;

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
	
	public boolean hasDuplicates() {
		this.hasDuplicates = duplicatesExist();
		return hasDuplicates;
	}

	// check with junit
	private boolean duplicatesExist() {
		if (password.size() < 2) {
			return false;
		}

		int occurrences = 0;
		for (int i = 0; i < password.size(); i++) {
			if (password.get(password.size() - 1) == password.get(i)) {
				occurrences++;
			}
			if (occurrences == 2) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder passwordString = new StringBuilder();
		for (int i = 0; i < password.size(); i++) {
			passwordString.append(Character.toString((char) i));
		}
		return passwordString.toString();
	}

}
