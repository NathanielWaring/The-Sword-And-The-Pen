package game.item.armour;

import game.item.Item;

public class Armour extends Item {
	private static final long serialVersionUID = 1L;
	public int AR;
	public ArmourEffect armourEffect;
	public Slot slot;
	public SubSlot subSlot;
	final static int numRingSlots = 5;
	final static int numAmuletSlots = 5;
	final static int numHandsSlots = 5;
	final static int numFeetSlots = 5;
	final static int numLegsSlots = 5;
	final static int numArmsSlots = 5;
	final static int numTorsoSlots = 5;
	final static int numNeckSlots = 5;
	final static int numHeadSlots = 5;
	final static int numBeltSlots = 5;

	public enum ArmourEffect {
		none, cure_light, cure_medium, cure_critical, damage1, damage2, damage3, light, darkness, damage_reduction, strength1, strength2, strength3, constitution1, constitution2, constitution3, dexterity1, dexterity2, dexterity3;
		public static ArmourEffect randomArmourEffect() {
			return ArmourEffect.values()[rand.nextInt(ArmourEffect.values().length)];
		}

	}

	public enum Slot {
		ring, amulet, hands, feet, legs, arms, torso, neck, head, belt;

		public static Slot randomSlot() {
			return Slot.values()[rand.nextInt(Slot.values().length)];
		}
	}

	public static enum SubSlot {
		ring, band, loop, finger_guard, signet_ring, pendant, amulet, brooch, medallion, charm, gloves, gauntlets, mittens, brass_knuckles, claws, shoes, greaves, boots, slippers, moccasins, pants, leggings, kilt, skirt, chaps, bracers, sleeves, bracellets, cuffs, armbands, shirt, breastplate, platemail, vest, aegis, choker, necklace, bow_tie, collar, scarf, helmet, great_helm, hat, cap, crown, belt, sash, cumberbun, gridle, codpiece;

		public static SubSlot randomSubSlot(Slot slot) {
			switch (slot) {
			case ring:
				return SubSlot.values()[rand.nextInt(numRingSlots)];
			case amulet:
				return SubSlot.values()[rand.nextInt(numAmuletSlots) + numRingSlots];
			case hands:
				return SubSlot.values()[rand.nextInt(numHandsSlots) + numAmuletSlots + numRingSlots];
			case feet:
				return SubSlot.values()[rand.nextInt(numFeetSlots) + numHandsSlots + numAmuletSlots + numRingSlots];
			case legs:
				return SubSlot.values()[rand.nextInt(numLegsSlots) + numFeetSlots + numHandsSlots + numAmuletSlots
						+ numRingSlots];
			case arms:
				return SubSlot.values()[rand.nextInt(numArmsSlots) + numLegsSlots + numFeetSlots + numHandsSlots
						+ numAmuletSlots + numRingSlots];
			case torso:
				return SubSlot.values()[rand.nextInt(numTorsoSlots) + numArmsSlots + numLegsSlots + numFeetSlots
						+ numHandsSlots + numAmuletSlots + numRingSlots];
			case neck:
				return SubSlot.values()[rand.nextInt(numNeckSlots) + numTorsoSlots + numArmsSlots + numLegsSlots
						+ numFeetSlots + numHandsSlots + numAmuletSlots + numRingSlots];
			case head:
				return SubSlot.values()[rand.nextInt(numHeadSlots) + numNeckSlots + numTorsoSlots + numArmsSlots
						+ numLegsSlots + numFeetSlots + numHandsSlots + numAmuletSlots + numRingSlots];
			case belt:
				return SubSlot.values()[rand.nextInt(numNeckSlots) + numHeadSlots + numNeckSlots + numTorsoSlots
						+ numArmsSlots + numLegsSlots + numFeetSlots + numHandsSlots + numAmuletSlots + numRingSlots];

			}
			return null;

			
		}
	}

	public static int setAR(Slot slot, ArmourEffect armourEffect, int baseAR) {

		return baseAR;

	}

	public static String randomName(SubSlot slot, ArmourEffect armourEffect) {
		String[] returnName = new String[2];
		
		returnName[0] = "" + slot.name().substring(0,1).toUpperCase() + slot.name().substring(1);

		switch (armourEffect) {

		case none:
			returnName[1] = "";
			break;
		case cure_light:
			returnName[1] = " of Minor Restoration";
			break;
		case cure_critical:
			returnName[1] = " of Medium Restoration";
			break;
		case cure_medium:
			returnName[1] = " of Major Restoration";
			break;
		case damage1:
			returnName[1] = " of Minor Damage";
			break;
		case damage2:
			returnName[1] = " of Medium Damage";
			break;
		case damage3:
			returnName[1] = " of Major Damage";
			break;
		case light:
			returnName[1] = " of Light";
			break;
		case darkness:
			returnName[1] = " of Darkness";
			break;
		case damage_reduction:
			returnName[1] = " of Protection";
			break;
		case strength1:
			returnName[1] = " of Minor Strength";
			break;
		case strength2:
			returnName[1] = " of Medium Strength";
			break;
		case strength3:
			returnName[1] = " of Major Strength";
			break;
		case constitution1:
			returnName[1] = " of Minor Constitution";
			break;
		case constitution2:
			returnName[1] = " of Medium Constitution";
			break;
		case constitution3:
			returnName[1] = " of Major Constitution";
			break;
		case dexterity1:
			returnName[1] = " of Minor Dexterity";
			break;
		case dexterity2:
			returnName[1] = " of Medium Dexterity";
			break;
		case dexterity3:
			returnName[1] = " of Major Dexterity";
			break;

		default:
			break;

		}
		String returnNameFinal = returnName[0] + returnName[1];

		return returnNameFinal;

	}

	public Armour() {
		this("Unknown");
	}
	
	public Armour(Slot slot) {
		this("Unknown", 1, 10, slot);
	}

	public Armour(String name) {
		this(name, 1, 10);
	}

	public Armour(String name, int curCond, int maxCond) {
		this(name, curCond, maxCond, Slot.randomSlot());

	}

	public Armour(String name, int curCond, int maxCond, Slot slot) {
		this(name, curCond, maxCond, slot, SubSlot.randomSubSlot(slot));

	}
	public Armour(String name, int curCond, int maxCond, Slot slot, SubSlot subSlot) {
		this(name, curCond, maxCond, slot, subSlot, ArmourEffect.randomArmourEffect(), -1);

	}

	public Armour(String name, int curCond, int maxCond, Slot slot, SubSlot subSlot, ArmourEffect effect, int bonusAR) {
		super(name, curCond, maxCond);

		this.armourEffect = effect;
		this.slot = slot;
		this.type = Item.itemType.armour;
		this.subSlot = subSlot;
		if (this.name.equals("Unknown")) {
			String tempName = Armour.randomName(subSlot, effect);
			this.name = tempName;
			
				
				
			
		}
		Armour.setAR(slot, effect, bonusAR);

	}

	public String toString() {
		String printEffect = this.armourEffect.toString();

		int counter = printEffect.length();

		while (counter < 15) {
			printEffect += " ";
			counter++;
		}
		String printName = this.name;

		if (printName.length() > 30) {
			printName = printName.substring(0, 27) + "...";
		}

		counter = this.name.length();

		while (counter < 30) {
			printName += " ";
			counter++;
		}
		String printCurCond = "" + currentCondition;
		String printMaxCond = "" + maxCondition;
		counter = printCurCond.length();
		while (counter < 3) {

			printCurCond = " " + printCurCond;
			counter++;
		}
		counter = printMaxCond.length();
		while (counter < 3) {

			printMaxCond = " " + printMaxCond;
			counter++;
		}
		String printType = this.slot.toString();
		counter = printType.length();
		while (counter < 15) {
			printType += " ";
			counter++;
		}

		return String.format(
				"%s  " + delimChar + " Condition: (%s/%s)\t" + delimChar + " Armour Rating: %d \t" + delimChar
						+ " Effect: %s \t" + delimChar + " Armour Slot: %s",
				printName, printCurCond, printMaxCond, AR, printEffect, printType);
	}

	public static void printArmour() {
		delim = "";
		for (int i = 0; i < 160; i++) {
			delim += delimChar;
		}
		System.out.println();
		;
		System.out.println(delim);
		String itemDelim = "" + delimChar;

		for (int i = 0; i < 71; i++) {
			itemDelim += " ";
		}
		itemDelim += "- ARMOUR LIST -";
		for (int i = 0; i < 72; i++) {
			itemDelim += " ";
		}
		itemDelim += delimChar;
		System.out.println(itemDelim);
		;
		System.out.println(delim);
		for (int i = 0; i < itemTotal; i++) {
			String listRef = "" + itemList[i].itemCode;
			int counter = listRef.length();
			while (counter < 4) {
				listRef = "0" + listRef;
				counter++;
			}
			if (itemList[i].type == Item.itemType.armour) {
				System.out.println(delimChar + " (" + listRef + ") " + delimChar + " " + itemList[i] + " " + delimChar);
			}
		}
		System.out.println(delim);

	}

}
