package game.creature.ability;

import java.util.Random;

public class Ability {

	public enum AbilityType {
		attack, buff, heal;
		public static AbilityType randomAbilityType() {
			Random rand = new Random();
			AbilityType returnAbilityType = AbilityType.values()[rand.nextInt(AbilityType.values().length)];

			return returnAbilityType;
		}
	}
	public enum BuffType {
		protection, evasion, damage, accuracy, hitpoints, all;
		
		
	}

	public String abilityName;
	protected String abilityDesc;
	protected AbilityType abilityType;
	protected boolean isArea;
	protected int abilityCost;
	protected int abilityLevelReq;
	// damage //
	protected int damageDiceType;
	protected int damageDiceNumber;
	protected int damageBonus;
	protected int damageDuration;
	// buff //
	
	protected int buffAmount;
	protected int buffDispelResistance;
	protected int buffDuration;
	protected BuffType buffType;
	// heal //
	protected int healDiceType;
	protected int healDiceNumber;
	protected int healBonus;
	protected int healDuration;
	

	public Ability() {
		this(AbilityType.randomAbilityType());
	}

	public Ability(AbilityType abilityType) {
		this(abilityType, "UNKNOWN", 1, 1, 1, 1, 1, 1, false);
	}

	public Ability(AbilityType abilityType, String abilityName, int atribute1, int atribute2, int atribute3,
			int atribute4, int atribute5, int atribute6, boolean isArea) {
		this.abilityType = abilityType;
		this.abilityName = abilityName;
		this.abilityCost = atribute5;
		this.abilityLevelReq = atribute6;
		this.isArea = isArea;
		switch (this.abilityType) {
		case attack:
			this.damageDiceNumber = atribute1;
			this.damageDiceType = atribute2;
			this.damageBonus = atribute3;
			this.damageDuration = atribute4;
			break;
		case buff:
			switch(atribute1) {
			case 0:
				this.buffType = BuffType.protection;
				break;
			case 1:
				this.buffType = BuffType.evasion;
				break;
			case 2:
				this.buffType = BuffType.damage;
				break;
			case 3:
				this.buffType = BuffType.accuracy;
				break;
			case 4:
				this.buffType = BuffType.hitpoints;
				break;
			case 5:
				this.buffType = BuffType.all;
				break;
			default:
				break;
			}
			
			this.buffAmount = atribute2;
			this.buffDispelResistance = atribute3;
			this.buffDuration = atribute4;
			break;
		case heal:
			this.healDiceNumber = atribute1;
			this.healDiceType = atribute2;
			this.healBonus = atribute3;
			this.healDuration = atribute4;
			break;

		default:
			break;

		}

	}

}
