package game.creature.monster;

import game.creature.Alignment;
import game.creature.Gender;
import game.creature.guild.Guild.GuildType;
import game.creature.Race;
import game.creature.Creature;

public class Monster extends Creature {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int mobCode;
	protected static Monster[] mobList;
	protected static int mobTotal;

	public Monster() {
		this(Race.randomRace());
	}

	public Monster(Race race) {
		this(race, Gender.randomGender());
	}

	public Monster(Race race, Gender gender) {
		this(race, gender, Race.randomName(race, gender));
	}

	public Monster(Race race, Gender gender, String name) {
		this(race, gender, name, GuildType.randomGuildType());
	}

	public Monster(Race race, Gender gender, String name, GuildType mobGuild) {
		this(race, gender, name, mobGuild,Alignment.randomAlignment(), 1);
	}

	public Monster(Race race, Gender gender, String name, GuildType mobGuild, Alignment alignment, int level) {
		super(race, gender, name, mobGuild, alignment, level);
		mobCode = ++mobTotal;
		this.addTo();
	}
	
	public Monster(Race race, Gender gender, String customGender, String name, GuildType guild, Alignment alignment, int level) {
		this(race,gender,name,guild,alignment,level);
		this.customGender = customGender;
		
	}
	public Monster(Race race, String customRace, Gender gender, String name, GuildType guild, Alignment alignment, int level) {
		this(race,gender,name,guild,alignment,level);
		this.customRace = customRace;
		
	}
	public Monster(Race race, String customRace, Gender gender, String customGender, String name, GuildType guild, Alignment alignment, int level) {
		this(race,gender,name,guild,alignment,level);
		this.customGender = customGender;
		this.customRace = customRace;
		
	}
	
	
	
	
	
	

	public void addTo() {
		Monster temp[] = mobList;
		mobList = new Monster[mobCode];
		for (int i = 0; i < mobTotal - 1; i++) {
			mobList[i] = temp[i];
		}
		Monster.mobList[this.mobCode - 1] = this;
	}

	public static void printMonsters() {
		System.out.println();
		System.out.println(getDelim());
		String mobDelim = "" + getDelimChar();
		
		for (int i = 0; i < 71; i++) {
			mobDelim += " ";
		}
		mobDelim += "- MONSTER LIST -";
		for (int i = 0; i < 71; i++) {
			mobDelim += " ";
		}
		mobDelim += getDelimChar();
		System.out.println(mobDelim);;
		System.out.println(getDelim());
		
		for (int i = 0; i < mobTotal; i++) {
			String listRef = "" + mobList[i].mobCode;
			int counter = listRef.length();
			while (counter < 4) {
				listRef = "0" + listRef;
				counter++;
			}
			System.out.println(getDelimChar() + " (" + listRef + ") " + getDelimChar() + " " + mobList[i] + " " + getDelimChar());
		}
		System.out.println(getDelim());

	}

}
