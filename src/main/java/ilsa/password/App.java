package ilsa.password;

import ilsa.password.models.Password;

public class App {

	public static void main(String[] args) {
		
		Password password = new Password(8);
		
		for (int i = 0; i < password.getLength(); i++) {
			
			
			generateChar();
					
		}
			

	}

	private static void generateChar() {
		// TODO char pikken uit al beperkte groep chars
		
	}

}
