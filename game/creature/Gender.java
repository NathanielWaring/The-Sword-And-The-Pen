package game.creature;

import java.util.Random;

public enum Gender {
	custom, male, female, non_binary;
	

	public static Gender randomGender() {
		Random rand = new Random();
		Gender returnGender;
		int randInt = rand.nextInt(100);
		if (randInt < 60) {
			returnGender = Gender.male;

		} else if (randInt < 98) {
			returnGender = Gender.female;
		} else {

			returnGender = Gender.non_binary;
		}

		return returnGender;

	}
	public String toString() {
		String theString;
		theString = this.name().substring(0,1).toUpperCase() + this.name().substring(1);
		return theString;
	}
}
