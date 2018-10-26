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

	// TODO check with junit
	// TODO lijst maken met duplicates zodat ik snel kan vinden
	private boolean duplicatesExist() {
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
	
	// TODO
	public int findDuplicate() {
		
		int lastIndex = 0;
		for (int i = 0; i < password.size() - 1; i++) {
			if (password.get(i) == password.get(password.size() - 1)) {
				lastIndex = i;
			}
		}
		//last index of duplicate
		return 0;
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
	

	@Override
	public String toString() {
		StringBuilder passwordString = new StringBuilder();
		for (int i = 0; i < password.size(); i++) {
			passwordString.append(Character.toString((char) i));
		}
		return passwordString.toString();
	}

	//TODO wat doe ik met al deze sameSort methodes...geen mogelijkheid tot recursie of wel...???
	
	public boolean firstTwoLetter() {
		try {
			if (Character.isLetter(password.get(password.size() - 3)) && Character.isLetter(password.get(password.size() - 2))) {
				return true;
			}
			return false;

		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public boolean firstTwoDigit() {
		try {
			if (Character.isDigit(password.get(password.size() - 3)) && Character.isDigit(password.get(password.size() - 2))) {
				return true;
			}
			return false;

		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean firstTwoSymbol() {
		try {
			if (firstTwoDigit() && firstTwoLetter()) {
				return true;
			}
			return false;

		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public boolean isSymbol(int index) {
		//TODO
		return false;
	}
	

}
