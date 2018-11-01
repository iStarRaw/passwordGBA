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
		return areSameSortHelper(totalToCheck, currentIndex);
		
	}
	
	//TODO checken met versie thuis
	public boolean areSameSortHelper(int totalToCheck, int currentIndex) {
		//stopconditie
		if (totalToCheck == 0) {
			
		}
		
		
		return areSameSortHelper(totalToCheck, currentIndex);
		
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
