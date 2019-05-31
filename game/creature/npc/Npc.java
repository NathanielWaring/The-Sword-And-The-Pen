package game.creature.npc;

import game.creature.Alignment;
import game.creature.Gender;
import game.creature.guild.Guild.GuildType;
import game.creature.Race;
import game.creature.Creature;

public class Npc extends Creature {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int npcCode;
	protected static Npc[] npcList;
	protected static int npcTotal;

	public Npc() {
		this(Race.randomRace());
	}

	public Npc(Race race) {
		this(race, Gender.randomGender());
	}

	public Npc(Race race, Gender gender) {
		this(race, gender, Race.randomName(race, gender));
	}

	public Npc(Race race, Gender gender, String name) {
		this(race, gender, name, GuildType.randomGuildType());
	}

	public Npc(Race race, Gender gender, String name, GuildType mobGuild) {
		this(race, gender, name, mobGuild,Alignment.randomAlignment(), 1);
	}

	public Npc(Race race, Gender gender, String name, GuildType mobGuild, Alignment alignment, int level) {
		super(race, gender, name, mobGuild, alignment, level);
		npcCode = ++npcTotal;
		this.addTo();
	}

	public void addTo() {
		Npc temp[] = npcList;
		npcList = new Npc[npcCode];
		for (int i = 0; i < npcTotal - 1; i++) {
			npcList[i] = temp[i];
		}
		Npc.npcList[this.npcCode - 1] = this;
	}

	public static void printNpcs() {
		System.out.println();
		System.out.println(getDelim());
		
		String npcDelim = "" + getDelimChar();
		
		for (int i = 0; i < 73; i++) {
			npcDelim += " ";
		}
		npcDelim += "- NPC LIST -";
		for (int i = 0; i < 73; i++) {
			npcDelim += " ";
		}
		npcDelim += getDelimChar();
		System.out.println(npcDelim);
		System.out.println(getDelim());
		for (int i = 0; i < npcTotal; i++) {
			String listRef = "" + npcList[i].npcCode;
			int counter = listRef.length();
			while (counter < 4) {
				listRef = "0" + listRef;
				counter++;
			}
			System.out.println(getDelimChar() + " (" + listRef + ") " + getDelimChar() + " " + npcList[i] + " " + getDelimChar());
		}
		System.out.println(getDelim());

	}

}
