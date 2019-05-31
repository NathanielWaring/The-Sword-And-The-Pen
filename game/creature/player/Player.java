package game.creature.player;

import java.io.Serializable;

import game.creature.Alignment;
import game.creature.Gender;
import game.creature.guild.Guild.GuildType;
import game.creature.Race;
import game.creature.Creature;

public class Player extends Creature implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int playerCode;
	protected static Player[] playerList;
	protected static int playerTotal;

	public Player() {
		this(Race.randomRace());
	}

	public Player(Race race) {
		this(race, Gender.randomGender());
	}

	public Player(Race race, Gender gender) {
		this(race, gender, Race.randomName(race, gender));
	}

	public Player(Race race, Gender gender, String name) {
		this(race, gender, name, GuildType.randomGuildType());
	}

	public Player(Race race, Gender gender, String name, GuildType mobGuild) {
		this(race, gender, name, mobGuild, Alignment.randomAlignment(), 1);
	}

	public Player(Race race, Gender gender, String name, GuildType mobGuild, Alignment alignment, int level) {
		super(race, gender, name, mobGuild, alignment, level);
		playerCode = ++playerTotal;
		this.addTo();
	}
	
	public Player(Race race, Gender gender, String customGender, String name, GuildType guild, Alignment alignment, int level) {
		this(race,gender,name,guild,alignment,level);
		this.customGender = customGender;
		
	}
	public Player(Race race, String customRace, Gender gender, String name, GuildType guild, Alignment alignment, int level) {
		this(race,gender,name,guild,alignment,level);
		this.customRace = customRace;
		
	}
	public Player(Race race, String customRace, Gender gender, String customGender, String name, GuildType guild, Alignment alignment, int level) {
		this(race,gender,name,guild,alignment,level);
		this.customGender = customGender;
		this.customRace = customRace;
		
	}
	

	public void addTo() {
		Player temp[] = playerList;
		playerList = new Player[playerCode];
		for (int i = 0; i < playerTotal - 1; i++) {
			playerList[i] = temp[i];
		}
		Player.playerList[this.playerCode - 1] = this;
	}
	
	public String toString() {
		
		

		String printName = this.getName();

		if (printName.length() > 19) {
			printName = printName.substring(0, 16) + "...";
		}

		int counter = this.getName().length();
		while (counter < 19) {
			printName += " ";
			counter++;
		}
		String printRace = this.race.name();
		counter = this.race.name().length();
		if (this.race.equals(Race.custom)) {
			printRace = this.customRace;
			counter = this.customRace.length();
		}
		printRace = printRace.substring(0, 1).toUpperCase() + printRace.substring(1);

		if (printRace.length() > 8) {
			printRace = printRace.substring(0, 5) + "...";
		}

		while (counter < 8) {
			printRace += " ";
			counter++;
		}
		String printGuild = this.guildType.name();
		printGuild = printGuild.substring(0, 1).toUpperCase() + printGuild.substring(1);
		if (printGuild.length() > 7) {
			printGuild = printGuild.substring(0, 4) + "...";
		}

		counter = this.guildType.name().length();
		while (counter < 7) {
			printGuild += " ";
			counter++;
		}

		String printStr, printDex, printCon, printInt, printWis, printCha, printSiz, printHpMax, printHpCur;
		printStr = "" + stats.getStrength();
		;
		if (printStr.length() < 3) {
			for (int i = printStr.length(); i < 3; i++) {
				printStr = " " + printStr;
			}
		}
		printDex = "" + stats.getDexterity();
		if (printDex.length() < 3) {
			for (int i = printDex.length(); i < 3; i++) {
				printDex = " " + printDex;
			}
		}
		printCon = "" + stats.getConstitution();
		if (printCon.length() < 3) {
			for (int i = printCon.length(); i < 3; i++) {
				printCon = " " + printCon;
			}
		}
		printInt = "" + stats.getIntelligence();
		if (printInt.length() < 3) {
			for (int i = printInt.length(); i < 3; i++) {
				printInt = " " + printInt;
			}
		}
		printWis = "" + stats.getWisdom();
		if (printWis.length() < 3) {
			for (int i = printWis.length(); i < 3; i++) {
				printWis = " " + printWis;
			}
		}
		printCha = "" + stats.getCharisma();
		if (printCha.length() < 3) {
			for (int i = printCha.length(); i < 3; i++) {
				printCha = " " + printCha;
			}
		}
		printSiz = "" + stats.getSize();
		if (printSiz.length() < 3) {
			for (int i = printSiz.length(); i < 3; i++) {
				printSiz = " " + printSiz;
			}
		}

		printHpCur = "" + stats.getHpCur();
		if (printHpCur.length() < 4) {
			for (int i = printHpCur.length(); i < 4; i++) {
				printHpCur = " " + printHpCur;
			}
		}
		printHpMax = "" + stats.getHpMax();
		if (printHpMax.length() < 4) {
			for (int i = printHpMax.length(); i < 4; i++) {
				printHpMax = " " + printHpMax;
			}
		}

		String printGender = "";
		switch (this.getGender()) {
		case male:
			printGender = " Male      ";
			break;
		case female:
			printGender = " Female    ";
			break;
		case non_binary:
			printGender = " Non-Binary";
			break;
		case custom:
			printGender = " " + this.customGender;
			if (this.customGender.length() > 11) {
				printGender = printGender.substring(0, 11);
			} else if (this.customGender.length() < 11) {
				while (printGender.length() < 11) {
					printGender += " ";
				}
				break;

			}

		}
		String printLevel = "" + level;
		if (printLevel.length() < 3) {
			for (int i = printLevel.length(); i < 3; i++) {
				printLevel += " ";
			}
		}

		
				String playerDelim = "" + getDelimChar();
		
				for (int i = 0; i < 72; i++) {
					playerDelim += " ";
				}
				playerDelim += "- CHARACTER -";
				for (int i = 0; i < 73; i++) {
					playerDelim += " ";
				}
				playerDelim += getDelimChar() + "\n";
				
				
				
				
				String returnString = Creature.getDelim() + "\n" + playerDelim + Creature.getDelim() + "\n" + Creature.getDelimChar() + printName + " " + getDelimChar() + " Level " + printLevel + " " + printGender + " " + printRace
				+ " " + printGuild;
		returnString += " " + getDelimChar() + " HP: (" + printHpCur + ")/(" + printHpMax + ")";
		returnString += " " + getDelimChar() + " STR: " + printStr;
		returnString += " " + getDelimChar() + " DEX: " + printDex;
		returnString += " " + getDelimChar() + " CON: " + printCon;
		returnString += " " + getDelimChar() + " INT: " + printInt;
		returnString += " " + getDelimChar() + " WIS: " + printWis;
		returnString += " " + getDelimChar() + " CHA: " + printCha;
		returnString += " " + getDelimChar() + " SIZ: " + printSiz + " " + Creature.getDelimChar() + "\n" + Creature.getDelim();

		return returnString;

	
	}

	public static void printPlayers() {
		System.out.println();
		System.out.println(getDelim());
		
		String playerDelim = "" + getDelimChar();
		
		for (int i = 0; i < 71; i++) {
			playerDelim += " ";
		}
		playerDelim += "- PLAYER LIST -";
		for (int i = 0; i < 72; i++) {
			playerDelim += " ";
		}
		playerDelim += getDelimChar();
		System.out.println(playerDelim);
		System.out.println(getDelim());
		for (int i = 0; i < playerTotal; i++) {
			String listRef = "" + playerList[i].playerCode;
			int counter = listRef.length();
			while (counter < 4) {
				listRef = "0" + listRef;
				counter++;
			}
			System.out.println(getDelimChar() + " (" + listRef + ") " + getDelimChar() + " " + playerList[i] + " " + getDelimChar());
		}
		System.out.println(getDelim());

	}
	public String nameString() {
		
		return new String (this.name.toString());
	}

}
