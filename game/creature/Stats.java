package game.creature;

import java.io.Serializable;
import java.util.Random;

import game.creature.guild.Guild.GuildType;

public class Stats implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int strength;
	protected int dexterity;
	protected int constitution;
	protected int intelligence;
	protected int wisdom;
	protected int charisma;
	protected int size;
	protected int hpMax;
	protected int hpCur;
	static Random rand;

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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
		this.hpMax = hpCur;
	}

	public static Stats statGenerator(Race race, GuildType guild, int level) {
		rand = new Random();
		Stats statGen = new Stats();

		statGen.strength = 6 + (rand.nextInt(6) + 1) + (level / 6);
		statGen.dexterity = 6 + (rand.nextInt(6) + 1) + ((level + 1) / 6);
		statGen.constitution = 6 + (rand.nextInt(6) + 1) + ((level + 2) / 6);
		statGen.intelligence = 6 + (rand.nextInt(6) + 1) + ((level + 3) / 6);
		statGen.wisdom = 6 + (rand.nextInt(6) + 1) + ((level + 4)/ 6);
		statGen.charisma = 6 + (rand.nextInt(6) + 1) + ((level + 5) / 6);
		statGen.size = 10;
		switch (race) {
		case human:
			statGen.size = 10;
			break;
		case orc:
			statGen.strength += 2;
			statGen.wisdom -= 2;
			statGen.size = 12;
			break;
		case elf:
			statGen.dexterity += 2;
			statGen.constitution -= 2;
			statGen.size = 10;
			break;
		case dwarf:
			statGen.constitution += 2;
			statGen.charisma -= 2;
			statGen.size = 8;
			break;

		case halfling:
			statGen.dexterity += 2;
			statGen.strength -= 2;
			statGen.size = 6;
			break;

		case gnome:
			statGen.intelligence += 2;
			statGen.strength -= 2;
			statGen.size = 6;
			break;

		case kobold:
			statGen.dexterity += 2;
			statGen.charisma -= 2;
			statGen.size = 6;
			break;

		case ogre:
			statGen.strength += 4;
			statGen.constitution += 2;
			statGen.dexterity -= 2;
			statGen.intelligence -= 4;
			statGen.size = 14;
			break;

		case undead:
			statGen.size = 6 + (rand.nextInt(5) * 2);
			break;

		case animal:
			int animalMod = rand.nextInt(6);
			statGen.strength = 6 + 2 * animalMod;
			statGen.dexterity = 16 - 2 * animalMod;
			statGen.constitution = 8 + animalMod;
			statGen.intelligence = 4;
			statGen.wisdom = 10;
			statGen.charisma = 15 - animalMod;
			statGen.size = 4 + 2 * animalMod;

			break;

		case ent:
			statGen.strength += 4;
			statGen.dexterity -= 8;
			statGen.wisdom += 4;
			statGen.size = 16;
			break;

		case troll:
			statGen.constitution += 6;
			statGen.strength += 4;
			statGen.wisdom -= 4;
			statGen.intelligence -= 4;
			statGen.charisma -= 2;
			statGen.size = 16;
			break;
		case custom:
			break;
		default:
			break;
		}

		switch (guild) {
		case fighter:
			statGen.strength += 2;
			statGen.intelligence -= 1;
			statGen.wisdom -= 1;
			break;
		case mage:
			statGen.intelligence += 2;
			statGen.constitution -= 1;
			statGen.strength -= 1;
			break;
		case cleric:
			statGen.wisdom += 2;
			statGen.strength -= 1;
			statGen.dexterity -= 1;
			break;
		case thief:
			statGen.dexterity += 2;
			statGen.charisma -= 1;
			statGen.wisdom -= 1;
			break;
		case ranger:
			statGen.dexterity += 2;
			statGen.wisdom -= 1;
			statGen.charisma -= 1;
			break;
		case bard:
			statGen.charisma += 2;
			statGen.constitution -= 1;
			statGen.strength -= 1;
			break;
		case monk:
			statGen.dexterity += 2;
			statGen.intelligence -= 1;
			statGen.charisma -= 1;
			break;
		default:
			break;
		}

		if (statGen.strength < 2)
			statGen.strength = 2;
		if (statGen.dexterity < 2)
			statGen.dexterity = 2;
		if (statGen.constitution < 2)
			statGen.constitution = 2;
		if (statGen.intelligence < 2)
			statGen.intelligence = 2;
		if (statGen.wisdom < 2)
			statGen.wisdom = 2;
		if (statGen.charisma < 2)
			statGen.charisma = 2;

		statGen.hpMax = 10;
		for (int i = 0; i < level; i++)
			statGen.hpMax += (2 + rand.nextInt(statGen.size) + ((statGen.constitution - 10) / 2));
		statGen.hpCur = statGen.hpMax;

		return statGen;

	}
	public void levelUp(int newLevel) {
		this.strength += (newLevel / 6) - ((newLevel -1) / 6);
		this.dexterity += ((newLevel + 1) / 6) - ((newLevel) / 6);
		this.constitution += ((newLevel + 2) / 6) - ((newLevel + 1) / 6);
		this.intelligence += ((newLevel + 3) / 6) - ((newLevel + 2) / 6);
		this.wisdom += ((newLevel + 4) / 6) - ((newLevel + 3) / 6);
		this.charisma += ((newLevel + 5) / 6) - ((newLevel + 4) / 6);
		this.hpMax += (2 + rand.nextInt(this.size) + ((this.constitution - 10) / 2));
		this.hpCur = this.hpMax;
	}

}
