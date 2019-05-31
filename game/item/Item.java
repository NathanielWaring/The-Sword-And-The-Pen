package game.item;

import java.io.Serializable;
import java.util.Random;

import game.Game;

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int maxCondition;
	public int currentCondition;
	public String name;
	public int value;
	public final int itemCode;
	public static int itemTotal;
	public boolean equiped;
	public itemType type;
	protected static Random rand = new Random();
	public static Item[] itemList = new Item[2];
	public double weight;
	protected static char delimChar = Game.delimChar;
	protected static String delim = "";
	

	public static enum itemType {
		generic_item, weapon, armour, shield, food, potion, scroll, spellbook, money
	}

	public Item() {
		this("Unknown");
	}

	public Item(String name) {
		this(name, 1, 10);

	}

	public Item(String name, int curCond, int maxCond) {
		itemCode = ++itemTotal;
		this.name = name;
		
		
		this.currentCondition = curCond;
		this.maxCondition = maxCond;
		this.addTo();

	}
	public int[] checkCondition() {
		int[] condition = { currentCondition, maxCondition };
		return condition;
	}

	public String toString() {
		String toReturn = String.format("%s  ||( %d / %d )", name, currentCondition, maxCondition);
		return toReturn;
	}

	public void addTo() {
		Item temp[] = itemList;
		itemList = new Item[itemCode];
		for (int i = 0; i < itemTotal - 1; i++) {
			itemList[i] = temp[i];
		}
		Item.itemList[this.itemCode - 1] = this;
	}

	public static void printItems() {
		delim = "";
		for (int i = 0; i < 160; i++) {
			delim += delimChar;
		}
		System.out.println();;
		System.out.println(delim);
		String itemDelim = "" + delimChar;

		for (int i = 0; i < 72; i++) {
			itemDelim += " ";
		}
		itemDelim += "- ITEM LIST -";
		for (int i = 0; i < 73; i++) {
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
			System.out.println(delimChar + " (" + listRef + ") " + delimChar + " " + itemList[i] + " " + delimChar);
		}
		System.out.println(delim);

	}

}
