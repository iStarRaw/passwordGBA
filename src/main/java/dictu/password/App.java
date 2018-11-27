package dictu.password;

import dictu.password.generator.Password;

/**
 * @author Dictu: Application that generates a password for the GBA-network.
 *         Takes into account the conditions in the Logical Design at:
 *         https://www.rvig.nl/documenten/richtlijnen/2015/02/27/wachtwoord-netwerk
 *
 */
public class App {

	public static void main(String[] args) {
		int length = 8;

		Password pwd = Password.generate(length);
		System.out.println(pwd.toHexString());

	}

}
