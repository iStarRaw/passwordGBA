package ilsa.password.models;

public class Password {
	private int length;
	private int[] password;


	public Password(int length) {
		this.length = length;
		this.password = new int[length];
	}

	public int getLength() {
		return length;
	}

	public int[] getPassword() {
		return password;
	}
	
	
	@Override
	public String toString() {
		StringBuilder passwordString = new StringBuilder();
		for (int i = 0; i < password.length; i++) {
			passwordString.append(Character.toString((char) i));
		}
		return passwordString.toString();
	}

	
	

}
