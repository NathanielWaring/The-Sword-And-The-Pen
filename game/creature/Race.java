
package game.creature;

import java.util.Random;

import game.creature.Gender;


public enum Race {
	custom, human, orc, elf, dwarf, halfling, gnome, kobold, ogre, undead, animal, ent, troll;
	public static String randomName(Race race, Gender gender) {

		String[] returnNames = null;
		switch (race) {
		case custom:
			break;
		case human:

			if (gender == Gender.male) {
				String[] tempNames = { "Henry", "John", "George", "Sam", "Bob", "Benjamin", "Jeffrey", "Jeremy",

						"Alexander" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Mary", "Charolotte", "Michelle", "Chloe", "Elsa", "Molly", "Cynthia",
						"Cleopatra" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Jesse", "Jamie", "Shai" };
				returnNames = tempNames;
			}
			break;

		case orc:

			if (gender == Gender.male) {
				String[] tempNames = { "Grok", "Gnoth", "Vorgat", "Urmog", "Azuk", "Olfin", "Largakh", "Durgash",
						"Yargol" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Borba", "Shaaram", "Garlub", "Darezha", "Shabon", "Yatzog", "Zaal",
						"Droka" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Urug", "Grut", "Yujar" };
				returnNames = tempNames;
			}
			break;
		case elf:

			if (gender == Gender.male) {
				String[] tempNames = { "Alluin", "Ethir", "Hadlathon", "Caraphinnor", "Gloron", "Pelon", "Lamaenor", "Fangon",
						"Abonnenor" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Morwen", "Gallaren", "Horneth", "Aeneth", "Húbel", "Bregedel", "Seron",
						"Fingaereth" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Ningannel", "Aduial", "Malfinben" };
				returnNames = tempNames;
			}
			break;
		case dwarf:

			if (gender == Gender.male) {
				String[] tempNames = { "Óin", "Fíli", "Gróin", "Durgon", "Frór", "Thrór", "Frerin", "Narvi",
						"Azaghâl" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Gordania", "Gwyndolyn", "Rhiannon", "Cambree", "Saraid", "Carroll", "Irwen ",
						"Brina" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Fibi", "Duach", "Padriac" };
				returnNames = tempNames;
			}
			break;
		case halfling:

			if (gender == Gender.male) {
				String[] tempNames = { "Mungo", "Meriadoc", "Bilbo", "Merimas", "Holfast", "Tolman", "Cottar", "Rudigar",
						"Odovacar" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Primula", "Hanna", "Mimosa", "Tanta", "Rose", "Dora", "Camellia",
						"Lobelia" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Aerid", "Gilly", "Merriak" };
				returnNames = tempNames;
			}
			break;
		case gnome:

			if (gender == Gender.male) {
				String[] tempNames = { "Klondirn", "Thiwumlock", "Larloflin", "Gnorlizz", "Tholdi", "Manbu", "Pinlen", "Tuttlack",
						"Pittlin" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Hidi", "Hissey", "Fanda", "Bipok", "Topa", "Dirafu", "Sidull",
						"Patli" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Timi", "Hufov", "Frizzik" };
				returnNames = tempNames;
			}
			break;
		case kobold:

			if (gender == Gender.male) {
				String[] tempNames = { "Henry", "John", "George", "Sam", "Bob", "Benjamin", "Jeffrey", "Jeremy",
						"Alexander" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Mary", "Charolotte", "Michelle", "Chloe", "Elsa", "Molly", "Cynthia",
						"Cleopatra" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Jesse", "Jamie", "Shai" };
				returnNames = tempNames;
			}
			break;
		case ogre:

			if (gender == Gender.male) {
				String[] tempNames = { "Henry", "John", "George", "Sam", "Bob", "Benjamin", "Jeffrey", "Jeremy",
						"Alexander" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Mary", "Charolotte", "Michelle", "Chloe", "Elsa", "Molly", "Cynthia",
						"Cleopatra" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Jesse", "Jamie", "Shai" };
				returnNames = tempNames;
			}
			break;
		case undead:

			if (gender == Gender.male) {
				String[] tempNames = { "Henry", "John", "George", "Sam", "Bob", "Benjamin", "Jeffrey", "Jeremy",
						"Alexander" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Mary", "Charolotte", "Michelle", "Chloe", "Elsa", "Molly", "Cynthia",
						"Cleopatra" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Jesse", "Jamie", "Shai" };
				returnNames = tempNames;
			}
			break;
		case animal:

			if (gender == Gender.male) {
				String[] tempNames = { "Henry", "John", "George", "Sam", "Bob", "Benjamin", "Jeffrey", "Jeremy",
						"Alexander" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Mary", "Charolotte", "Michelle", "Chloe", "Elsa", "Molly", "Cynthia",
						"Cleopatra" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Jesse", "Jamie", "Shai" };
				returnNames = tempNames;
			}
			break;
		case ent:

			if (gender == Gender.male) {
				String[] tempNames = { "Henry", "John", "George", "Sam", "Bob", "Benjamin", "Jeffrey", "Jeremy",
						"Alexander" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Mary", "Charolotte", "Michelle", "Chloe", "Elsa", "Molly", "Cynthia",
						"Cleopatra" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Jesse", "Jamie", "Shai" };
				returnNames = tempNames;
			}
			break;
		case troll:

			if (gender == Gender.male) {
				String[] tempNames = { "Henry", "John", "George", "Sam", "Bob", "Benjamin", "Jeffrey", "Jeremy",
						"Alexander" };
				returnNames = tempNames;
			} else if (gender == Gender.female) {
				String[] tempNames = { "Mary", "Charolotte", "Michelle", "Chloe", "Elsa", "Molly", "Cynthia",
						"Cleopatra" };
				returnNames = tempNames;
			} else {
				String[] tempNames = { "Jesse", "Jamie", "Shai" };
				returnNames = tempNames;
			}
			break;

		}
		if(returnNames.equals(null)) {
			String returnName = "CUSTOM";
			return returnName;
		}
		
		
		return returnNames[rand.nextInt(returnNames.length)];

	}

	private static Random rand = new Random();

	public static Race randomRace() {
		Race returnRace = Race.values()[rand.nextInt(Race.values().length - 1) + 1];

		return returnRace;

	}
	public String toString() {
		String theString;
		theString = this.name().substring(0,1).toUpperCase() + this.name().substring(1);
		return theString;
	}
}
