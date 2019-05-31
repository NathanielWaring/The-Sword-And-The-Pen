package game.creature;

import java.util.Random;

public enum Alignment {
	LAWFUL_GOOD{
		public String toString() {
			String theString = "Lawful Good";
			return theString;
		}
	}
	, NEUTRAL_GOOD{
		public String toString() {
			String theString = "Neutral Good";
			return theString;
		}
	}
	, CHAOTIC_GOOD{
		public String toString() {
			String theString = "Chaotic Good";
			return theString;
		}
	}
	,LAWFUL_NEUTRAL{
		public String toString() {
			String theString = "Lawful Neutral";
			return theString;
		}
	}
	, TRUE_NEUTRAL{
		public String toString() {
			String theString = "True Neutral";
			return theString;
		}
	}
	, CHAOTIC_NEUTRAL{
		public String toString() {
			String theString = "Chaotic Neutral";
			return theString;
		}
	}
	,LAWFUL_EVIL{
		public String toString() {
			String theString = "Lawful Evil";
			return theString;
		}
	}
	, NEUTRAL_EVIL{
		public String toString() {
			String theString = "Neutral Evil";
			return theString;
		}
	}
	, CHAOTIC_EVIL{
		public String toString() {
			String theString = "Chaotic Evil";
			return theString;
		}
	}
	;
	public static Alignment randomAlignment() {
		Random rand = new Random();
		Alignment returnAlignment = Alignment.values()[rand.nextInt(Alignment.values().length)];

		return returnAlignment;

	}
}
