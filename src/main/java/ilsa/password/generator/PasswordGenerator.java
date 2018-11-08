package ilsa.password.generator;

import java.util.ArrayList;
import java.util.List;

import ilsa.password.models.CharacterBox;
import ilsa.password.models.Password;

public class PasswordGenerator {

	private Password password;
	private CharacterBox cbox;
	private List<Integer> duplicates;

	public PasswordGenerator(int length) {
		password = new Password(length);
		cbox = new CharacterBox();
		duplicates = new ArrayList<>();

		createPassword();
	}

	private void createPassword() {
		for (int i = 0; i < password.getLength(); i++) {
			addChar(i);

			System.out.printf("Index %d is: %d\n", i, password.getPassword().get(i));
		}
		System.out.println(password.toString());
	}

	
	
	private void addChar(int indexToAdd) {
//		System.out.println(Arrays.toString(cbox.getBox().toArray()));
		
		int duplicate = 0;
		boolean generateSame = false;
		boolean generateAll = false;
		String sort = "";
		int forbiddenInt = 0;

		// bij 0 en 1
		if (indexToAdd < 2) {
			password.getPassword().add(cbox.generateChar());

		} 
		
		//bij index 2
		else if (indexToAdd % 2 == 0) {

			if (password.lastIsDuplicate()) {
				duplicate = password.getDuplicate();
				duplicates.add(duplicate);
			}

			if (password.areSameSort(2)) {
				generateSame = true;
				sort = password.getSort(indexToAdd - 1);

				if (password.isSequence()) {
					forbiddenInt = password.getForbiddenInt();
				}
			}
			password.getPassword().add(cbox.generateChar(duplicates, sort, generateSame, forbiddenInt));

		} 
		
		//bij index 3
		else if (indexToAdd % 3 == 0) {

			if (password.lastIsDuplicate()) {
				duplicate = password.getDuplicate();
				duplicates.add(duplicate);
			}

			if (password.areSameSort(3)) {
				generateSame = false;
				sort = password.getSort(indexToAdd - 1);
				
			} else if (password.areSameSort(2)) {
				// laatste 2 checken
				generateSame = true;
				sort = password.getSort(indexToAdd - 1);

				if (password.isSequence()) {
					forbiddenInt = password.getForbiddenInt();
				}
			}
			
			password.getPassword().add(cbox.generateChar(duplicates, sort, generateSame, forbiddenInt));

		}
		
		//bij anders
		else if (indexToAdd > 4) {
			password.getPassword().add(cbox.generateChar(sort, generateSame, forbiddenInt));

		}

//		if (!password.isTwoBeforeSame() && !password.hasDuplicates()) {
		// pick from all possibilities
//		password.getPassword().add(cbox.generateChar());
//		} else if (password.hasDuplicates()) {
//			//pick from all without the duplicate
//			int duplicate = getDuplicate();
//			password.getPassword().add(cbox.generateWithout(duplicate));
//		}
//		
//		if (twoBeforeSame && threeBeforeSame()) {
//			if (password.hasDuplicates()) {
//				//pick from other sort without the duplicate
//			}
//			//pick from all possibilities
//			password.getPassword().add(cbox.generateFromAll());
//		}
//		
//		//condition that two of the same type are not allowed together
//		if (twoBeforeSame()) {
//			if (password.hasDuplicates()) {
//				//pick from all without the duplicate
//			}
//			if (sequenceExists()) {
//				//pick same sort without lastChar +1 or -1
//			}
//			//pick the same sort
//		}
//		
//		
//		//condition that four of the same type are not allowed together
//		if (threeBeforeSame()) {
//			//pick another
//		}

//		password.getPassword().add(cbox.generateChar());

		// box resetten of dingen bewaren?

	}

}
