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
	
	
	public boolean areSameSort(int totalToCheck, int currentIndex) {
		boolean sameSort = false;
		return areSameSortHelper(totalToCheck, currentIndex, sameSort, 0);
		
	}
	
	//TODO checken met versie thuis
	public boolean areSameSortHelper(int totalToCheck, int currentIndex, boolean sameSort, int count) {
		
		//stopconditie
		if (count == totalToCheck) {
			return sameSort;
		}
		
		while (totalToCheck != 0) {
			char someChar = (char)Integer.parseInt(String.valueOf(password.get(currentIndex)));
			char charToComp = (char)Integer.parseInt(String.valueOf(password.get(currentIndex - 1)));
			
			if (Character.isDigit(someChar) && Character.isDigit(charToComp) ||
					Character.isLetter(someChar) && Character.isLetter(charToComp) ||
					!Character.isDigit(someChar) && !Character.isLetter(someChar) && !Character.isDigit(charToComp) && !Character.isLetter(charToComp)) {
				sameSort = true;
			}
			count++;
			
		}
		return areSameSortHelper(totalToCheck, currentIndex - 1, sameSort, count);
		
	}
	
	
	

	// TODO check with junit
	// TODO lijst maken met duplicates zodat ik snel kan vinden
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
		for (int i = 0; i < password.size(); i++) {
			passwordString.append(Character.toString((char) i));
		}
		return passwordString.toString();
	}
	

}
