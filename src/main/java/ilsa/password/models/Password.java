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
		if (password.size() < 2) {
			return false;
		}

		for (int i = 0; i < password.size() - 1; i++) {
			if (password.get(i) == password.get(password.size() - 1)) {
				return true;
			}
		}
		return false;
	}

//	public boolean checkSameSort(int fromIndex, int toIndex, boolean isSame) {
//		// stop conditie
//		while (fromIndex != toIndex) {
//			// hier de inhoud vd functie: same sort uitvinden
//			
//			
//			return isSame;
//			
//			// opnieuw aanroepen
//			checkSameSort(fromIndex - 1, toIndex);
//		}
//
//	}

	@Override
	public String toString() {
		StringBuilder passwordString = new StringBuilder();
		for (int i = 0; i < password.size(); i++) {
			passwordString.append(Character.toString((char) i));
		}
		return passwordString.toString();
	}

}
