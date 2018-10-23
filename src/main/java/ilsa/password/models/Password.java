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

	@Override
	public String toString() {
		StringBuilder passwordString = new StringBuilder();
		for (int i = 0; i < password.size(); i++) {
			passwordString.append(Character.toString((char) i));
		}
		return passwordString.toString();
	}

	
	

}
