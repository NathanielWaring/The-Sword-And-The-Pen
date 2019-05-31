package game.creature.guild;

import java.util.Random;

import game.creature.ability.Ability;

public class Guild {
	public enum GuildType {
	fighter,
	mage,
	cleric,
	thief,
	ranger,
	monk,
	bard;
		
		public static GuildType randomGuildType() {
			Random rand = new Random();
			GuildType returnGuild = Guild.GuildType.values()[rand.nextInt(7)];

			return returnGuild;
		}
		public String toString() {
			String theString;
			theString = this.name().substring(0,1).toUpperCase() + this.name().substring(1);
			return theString;
		}
	}

	protected int guildLevel,attackBonus,arBonus,hitBonus,dodgeBonus,maxLevel;
	public String guildName,guildDesc;
	protected GuildType guildType;
	protected Ability ability1, ability2, ability3, ability4, ability5;
	protected int[][] bonusTree = new int[Guild.defaultMaxLevel()][4];

	Guild() {
		this(Guild.GuildType.randomGuildType());
	}

	Guild(GuildType guildType) {
		this(guildType, "UNKNOWN");
	}

	Guild(GuildType guildType, String guildName) {
		this(guildType, guildName, 1);
	}

	Guild(GuildType guildType, String guildName, int guildLevel) {
		this(guildType, guildName, guildLevel, defaultMaxLevel());
	}

	Guild(GuildType guildType, String guildName, int guildLevel, int maxLevel) {
		this(guildType, guildName, guildLevel, maxLevel, 0, 0, 0, 0);
	}

	Guild(GuildType guildType, String guildName, int guildLevel, int maxLevel, int damBonus, int hitBonus, int arBonus,
			int dodgeBonus) {
		this.guildType = guildType;
		this.guildName = guildName;
		this.guildLevel = guildLevel;
		this.maxLevel = maxLevel;
		this.attackBonus = damBonus;
		this.hitBonus = hitBonus;
		this.arBonus = arBonus;
		this.dodgeBonus = dodgeBonus;

	}

	protected static int defaultMaxLevel() {
		return 20;
	}



	public int getGuildLevel() {
		return guildLevel;
	}

	public int getDamBonus() {
		return attackBonus;
	}

	public int getArBonus() {
		return arBonus;
	}

	public int getHitBonus() {
		return hitBonus;
	}

	public int getDodgeBonus() {
		return dodgeBonus;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public String getGuildName() {
		return guildName;
	}

	public String getDesc() {
		return guildDesc;
	}

	public GuildType getGuildType() {
		return guildType;
	}

	public int[][] getBonusTree() {
		return bonusTree;
	}

	public void update(int guildLevel) {
		switch (this.guildType) {
		case fighter:
			int[][] figherBonuses = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 5 },
					{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 2, 5 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 5 },
					{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 2, 5 } };

			this.setBonusTree(figherBonuses);
			this.ability1 = new Ability(Ability.AbilityType.attack, "Slash", 1 + (guildLevel / 4), 6, guildLevel, 1, 20,
					1, false);
			this.ability2 = new Ability(Ability.AbilityType.attack, "Bleeding Cut", 2 + (guildLevel / 3), -4,
					2 * guildLevel, 5, 30, 5, false);
			this.ability3 = new Ability(Ability.AbilityType.buff, "Keen Eye", Ability.BuffType.accuracy.ordinal(), 30,
					5 * guildLevel, 60, 40, 10, false);
			this.ability4 = new Ability(Ability.AbilityType.attack, "Whirlwind", guildLevel, 8, 2 * guildLevel, 5, 50,
					15, true);
			this.ability5 = new Ability(Ability.AbilityType.buff, "Giant's Strength", Ability.BuffType.damage.ordinal(),
					40, 100, 120, 60, 20, true);

		case mage:
			int[][] mageBonuses = { { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2 },
					{ 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2 } };

			this.setBonusTree(mageBonuses);
			this.ability1 = new Ability(Ability.AbilityType.attack, "Magic Missile", guildLevel, 4, 2, 1, 20, 1, false);
			this.ability2 = new Ability(Ability.AbilityType.attack, "Lightning Bolt", 3, 6, 4 * guildLevel, 1, 30, 5,
					false);
			this.ability3 = new Ability(Ability.AbilityType.buff, "Mirror Image", Ability.BuffType.evasion.ordinal(),
					30, 4 * guildLevel, 60, 40, 10, false);
			this.ability4 = new Ability(Ability.AbilityType.attack, "Fireball", 2 * guildLevel, 6, 2 + guildLevel, 1,
					50, 15, true);
			this.ability5 = new Ability(Ability.AbilityType.buff, "Stone Skin", Ability.BuffType.protection.ordinal(),
					40, 100, 120, 60, 20, true);

		case cleric:
			int[][] clericBonuses = { { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 2, 5 },
					{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 2, 5 },
					{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 2, 5 },
					{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 2, 5 } };
			this.setBonusTree(clericBonuses);

			this.ability1 = new Ability(Ability.AbilityType.heal, "Cure light Wounds", guildLevel, 4, guildLevel / 2, 1,
					20, 1, false);
			this.ability2 = new Ability(Ability.AbilityType.attack, "Wrath of the Gods", (guildLevel + 1) / 2, 6,
					guildLevel / 2, 1, 30, 5, false);
			this.ability3 = new Ability(Ability.AbilityType.heal, "Cure medium Wounds", 2 * guildLevel, 6, 10, 1, 40,
					10, false);
			this.ability4 = new Ability(Ability.AbilityType.heal, "Cure critical Wounds", 3 * guildLevel, 8, 20, 1, 50,
					15, false);
			this.ability5 = new Ability(Ability.AbilityType.heal, "Healing Wind", guildLevel, 4, guildLevel / 2, 120,
					60, 20, true);

		case thief:
			int[][] thiefBonuses = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 5 },
					{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 2, 5 },
					{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 2, 5 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 5 } };
			this.setBonusTree(thiefBonuses);
			this.ability1 = new Ability(Ability.AbilityType.attack, "Stab", (guildLevel + 1) / 2, 6, guildLevel, 1, 20,
					1, false);
			this.ability2 = new Ability(Ability.AbilityType.attack, "Poisoned Blade", 2 + (guildLevel / 3), -4,
					2 * guildLevel, 5, 30, 5, false);
			this.ability3 = new Ability(Ability.AbilityType.buff, "Damage of the underworld",
					Ability.BuffType.damage.ordinal(), 30, 5 * guildLevel, 60, 40, 10, false);
			this.ability4 = new Ability(Ability.AbilityType.attack, "Backstab", guildLevel * 2, 8, 20, 5, 50, 15,
					false);
			this.ability5 = new Ability(Ability.AbilityType.buff, "Cat's Eye", Ability.BuffType.accuracy.ordinal(), 40,
					100, 120, 60, 20, true);

		case ranger:
			int[][] rangerBonuses = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 5 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 5 },
					{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 2, 5 },
					{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 2, 5 } };
			this.setBonusTree(rangerBonuses);
			this.ability1 = new Ability(Ability.AbilityType.attack, "Aimed Shot", (guildLevel + 1) / 2, 6, guildLevel,
					1, 20, 1, false);
			this.ability2 = new Ability(Ability.AbilityType.attack, "Multi Shot", 2 + (guildLevel / 3), 1,
					2 * guildLevel, 5, 30, 5, true);
			this.ability3 = new Ability(Ability.AbilityType.buff, "Mark of the Archer",
					Ability.BuffType.accuracy.ordinal(), 30, 5 * guildLevel, 60, 40, 10, false);
			this.ability4 = new Ability(Ability.AbilityType.attack, "Power Shot", guildLevel * 2, 8, 20, 5, 50, 15,
					false);
			this.ability5 = new Ability(Ability.AbilityType.buff, "Heart of the Bear",
					Ability.BuffType.hitpoints.ordinal(), 40, 100, 120, 60, 20, true);
		case monk:
			int[][] monkBonuses = {

					{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 2, 5 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 5 },
					{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 2, 5 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 5 } };
			this.setBonusTree(monkBonuses);
			this.ability1 = new Ability(Ability.AbilityType.attack, "Fist of Fury", (guildLevel + 1) / 2, 6, guildLevel,
					1, 20, 1, false);
			this.ability2 = new Ability(Ability.AbilityType.attack, "Dragon Kick", 2 + (guildLevel / 3), -4,
					2 * guildLevel, 5, 30, 5, false);
			this.ability3 = new Ability(Ability.AbilityType.heal, "Lay on Hands", 1, 6, guildLevel, 10, 40, 10, false);
			this.ability4 = new Ability(Ability.AbilityType.attack, "Wu Shu Finger Hold", guildLevel * 2, 8, 20, 5, 50,
					15, false);
			this.ability5 = new Ability(Ability.AbilityType.buff, "Tiger's Grace", Ability.BuffType.evasion.ordinal(),
					40, 100, 120, 60, 20, true);
		case bard:
			int[][] bardBonuses = { { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 2, 5 },
					{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 2, 5 },
					{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 2, 5 },
					{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 2, 5 } };
			this.setBonusTree(bardBonuses);
			this.ability1 = new Ability(Ability.AbilityType.attack, "Lunge", (guildLevel + 1) / 2, 6, guildLevel, 1, 20,
					1, false);
			this.ability2 = new Ability(Ability.AbilityType.buff, "Parry", Ability.BuffType.evasion.ordinal(), 30,
					5 * guildLevel, 50, 30, 5, false);
			this.ability3 = new Ability(Ability.AbilityType.heal, "Campfire Tune", guildLevel / 2, 4, 5, 1, 40, 10,
					true);
			this.ability4 = new Ability(Ability.AbilityType.attack, "Remise", guildLevel * 2, 8, 20, 5, 50, 15, false);
			this.ability5 = new Ability(Ability.AbilityType.buff, "War Chant", Ability.BuffType.all.ordinal(), 10, 100,
					120, 60, 20, true);

		}
	}

	public void setBonusTree(int[][] bonusTree) {
		this.bonusTree = bonusTree;
	}

	public void setDesc(String guildDesc) {
		this.guildDesc = guildDesc;
	}

	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public void setGuildType(GuildType guildType) {
		this.guildType = guildType;
	}

	public void setGuildLevel(int guildLevel) {
		this.guildLevel = guildLevel;
	}

	public void setDamBonus(int damBonus) {
		this.attackBonus = damBonus;
	}

	public void setArBonus(int arBonus) {
		this.arBonus = arBonus;
	}

	public void setHitBonus(int hitBonus) {
		this.hitBonus = hitBonus;
	}

	public void setDodgeBonus(int dodgeBonus) {
		this.dodgeBonus = dodgeBonus;
	}

}