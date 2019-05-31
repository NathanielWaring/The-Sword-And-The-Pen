package game.item.shield;

import game.item.Item;

public class Shield extends Item {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int AR;
	public int bashDamage;
	public ShieldEffect shieldEffect;
	public ShieldType shieldType;

	public enum ShieldEffect {
		none, cure_light, light, darkness, damage_reduction, strength1, strength2, strength3, constitution1, constitution2, constitution3, dexterity1, dexterity2, dexterity3;
		
		public static ShieldEffect randomShieldEffect () {
			return ShieldEffect.values()[rand.nextInt(ShieldEffect.values().length)];
		}
	}

	public enum ShieldType {
		buckler, round, kite, full;
		public static ShieldType randomShieldType () {
			return ShieldType.values()[rand.nextInt(ShieldType.values().length)];
		}
	}

	public Shield() {
		this("Unknown");
	}

	public Shield(String name) {
		this(name, 1, 10);

	}

	public Shield(String name, int curCond, int maxCond) {
		this(name, curCond, maxCond, ShieldType.randomShieldType());

	}
	
	public Shield(String name, int curCond, int maxCond, ShieldType shieldType) {
		this(name, curCond, maxCond, 0, 0, shieldType, ShieldEffect.randomShieldEffect());


	}

	public Shield(String name, int curCond, int maxCond, int AR, int bashDamage, ShieldType shieldType,
			ShieldEffect shieldEffect) {
		super(name, curCond, maxCond);
		this.type = Item.itemType.shield;
		this.AR = AR;
		this.bashDamage = bashDamage;
		this.shieldEffect = shieldEffect;
		this.shieldType = shieldType;
	}

	public String toString() {
		String printEffect = this.shieldEffect.toString();
		
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
		String printType = this.shieldType.toString();
		counter = printType.length();
		while (counter < 15) {
			printType += " ";
			counter++;
		}

		return String.format("%s  "+ delimChar + " Condition: (%s/%s)\t" + delimChar + " Bash: %d / AR: %d \t" + delimChar + " Effect: %s \t" + delimChar + " Shield Type: %s",
				printName, printCurCond, printMaxCond, bashDamage, AR, printEffect, printType);
	}
	public static void printShields() {
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
		itemDelim += "- SHIELD LIST -";
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
			if (itemList[i].type == Item.itemType.shield) {
				System.out.println(delimChar + " (" + listRef + ") " + delimChar + " " + itemList[i] + " " + delimChar);
			}
		}
		System.out.println(delim);

	}

}


