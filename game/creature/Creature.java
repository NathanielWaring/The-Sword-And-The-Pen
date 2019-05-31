package game.creature;

import java.io.Serializable;
import java.util.Random;

import game.Game;
import game.creature.Alignment;
import game.creature.Gender;
import game.creature.guild.Guild.GuildType;
import game.gui.MainBox;
import game.creature.Race;
import game.creature.Stats;

public class Creature implements Serializable {
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected static Creature[] creatureList = new Creature[2];
	protected static Random rand = new Random();;
	protected static char delimChar = Game.delimChar;
	protected static String delim = Game.delim;
	protected Stats stats;
	protected Alignment alignment;
	protected Race race;
	protected String name;
	protected GuildType guildType;
	protected Inventory inventory;
	protected int level, hpMax, hpCur, tempHp;
	protected Gender gender;
	protected String customGender;
	protected static Creature[] getCreatureList() {
		return creatureList;
	}

	public static void setCreatureList(Creature[] creatureList) {
		Creature.creatureList = creatureList;
	}

	public static Random getRand() {
		return rand;
	}

	public static void setRand(Random rand) {
		Creature.rand = rand;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GuildType getGuildType() {
		return guildType;
	}

	public void setGuildType(GuildType guildType) {
		this.guildType = guildType;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public int getHpCur() {
		return hpCur;
	}

	public void setHpCur(int hpCur) {
		this.hpCur = hpCur;
	}

	public int getTempHp() {
		return tempHp;
	}

	public void setTempHp(int tempHp) {
		this.tempHp = tempHp;
	}

	public String getCustomGender() {
		return customGender;
	}

	public void setCustomGender(String customGender) {
		this.customGender = customGender;
	}

	public int getPlayerCode() {
		return playerCode;
	}

	public void setPlayerCode(int playerCode) {
		this.playerCode = playerCode;
	}

	public int getMobCode() {
		return mobCode;
	}

	public void setMobCode(int mobCode) {
		this.mobCode = mobCode;
	}

	public String getCustomRace() {
		return customRace;
	}

	public void setCustomRace(String customRace) {
		this.customRace = customRace;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int playerCode;
	public int mobCode;

	protected String customRace;

	public Creature() {
		this(Race.randomRace());

	}

	public Creature(Race race) {
		this(race, Gender.randomGender());
	}

	public Creature(Race race, Gender gender) {
		this(race, gender, Race.randomName(race, gender));
	}

	public Creature(Race race, Gender gender, String name) {
		this(race, gender, name, GuildType.randomGuildType());
	}

	public Creature(Race race, Gender gender, String name, GuildType guild) {
		this(race, gender, name, guild, Alignment.randomAlignment(), 1);

	}

	public Creature(Race race, Gender gender, String name, GuildType guild, Alignment alignment, int level) {

		this.name = name;
		this.race = race;
		this.guildType = guild;
		this.setGender(gender);
		if (level > 40)
			level = 40;
		this.stats = Stats.statGenerator(race, guild, level);
		this.level = level;

		setDelim("");
		for (int i = 0; i < MainBox.getNumCharacters(); i++) {
			setDelim(getDelim() + getDelimChar());		
		}

	}

	public Creature(Race race, Gender gender, String customGender, String name, GuildType guild, Alignment alignment,
			int level) {
		this(race, gender, name, guild, alignment, level);
		this.customGender = customGender;

	}

	public Creature(Race race, String customRace, Gender gender, String name, GuildType guild, Alignment alignment,
			int level) {
		this(race, gender, name, guild, alignment, level);
		this.customRace = customRace;

	}

	public Creature(Race race, String customRace, Gender gender, String customGender, String name, GuildType guild,
			Alignment alignment, int level) {
		this(race, gender, name, guild, alignment, level);
		this.customGender = customGender;
		this.customRace = customRace;

	}

	public void newInv() {
		this.inventory = new Inventory();
	}

	public void newInv(int money) {
		this.inventory = new Inventory(money);
	}

	public void newInv(int money, int invSize) {
		this.inventory = new Inventory(money, invSize);
	}

	public String toString() {
		String printName = this.name;

		if (printName.length() > 19) {
			printName = printName.substring(0, 16) + "...";
		}

		int counter = this.name.length();
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

		String returnString = printName + " " + getDelimChar() + " Level " + printLevel + " " + printGender + " "
				+ printRace + " " + printGuild;
		returnString += " " + getDelimChar() + " HP: (" + printHpCur + ")/(" + printHpMax + ")";
		returnString += " " + getDelimChar() + " STR: " + printStr;
		returnString += " " + getDelimChar() + " DEX: " + printDex;
		returnString += " " + getDelimChar() + " CON: " + printCon;
		returnString += " " + getDelimChar() + " INT: " + printInt;
		returnString += " " + getDelimChar() + " WIS: " + printWis;
		returnString += " " + getDelimChar() + " CHA: " + printCha;
		returnString += " " + getDelimChar() + " SIZ: " + printSiz + " ";

		return returnString;

	}

	public static String getDelim() {
		return delim;
	}

	public static void setDelim(String delim) {
		Creature.delim = delim;
	}

	public static char getDelimChar() {
		return delimChar;
	}

	public static void setDelimChar(char delimChar) {
		Creature.delimChar = delimChar;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
