package game.creature;

import java.io.Serializable;

import game.Game;
import game.item.Item;

public class Inventory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String delim = "";
	private static char delimChar = Game.delimChar;
	private int invSize = 10;
	private int openSlot = 0;
	protected int money = 0;
	private boolean fullInv = false;
	public Item[] invList;

	public Inventory() {
		this(0);

	}

	public Inventory(int money) {
		this(money, 10);
	}

	public Inventory(int money, int invSize) {
		this.invSize = invSize;
		this.invList = new Item[invSize];
		this.money = money;

	}

	public boolean addItem(Item item) {
		if (fullInv) {
			return false;
		} else {
			this.invList[openSlot++] = item;
			if (openSlot > invSize) {
				fullInv = true;
			}
			return true;
		}
	}

	public boolean setSize(int newSize) {
		if (this.invSize > newSize) {
			return false;
		} else {
			Item[] temp = this.invList;
			this.invList = new Item[newSize];
			for (int i = 0; i < temp.length; i++) {
				this.invList[i] = temp[i];

			}
			return true;
		}

	}

	public String toString() {

		String returnString = "";
		delim = "";
		for (int i = 0; i < 76; i++) {
			delim += " " + delimChar;
		}
		returnString += delim + "\n";
		String itemDelim = "";

		for (int i = 0; i < 71; i++) {
			itemDelim += " ";
		}
		itemDelim += "- INVENTORY -";
		for (int i = 0; i < 72; i++) {
			itemDelim += " ";
		}
		returnString += itemDelim + "\n";

		returnString += delim + "\n";

		for (int i = 0; i < this.openSlot; i++) {
			char equipChar = ' ';
			if (this.invList[i].equiped) {
				equipChar = '@';
			}
			String listRef = "" + this.invList[i].itemCode;
			int counter = listRef.length();
			while (counter < 4) {
				listRef = "0" + listRef;
				counter++;
			}
			returnString += "" + delimChar + equipChar + "(" + listRef + ")" + equipChar + delimChar + " " + this.invList[i]
					+ " " + delimChar + "\n";
		}
		returnString += delim + "\n";

		return returnString;

	}

	public void printInv() {
		for (int i = 0; i < 160; i++) {
			delim += delimChar;
		}
		System.out.println();
		;
		System.out.println(delim);
		String itemDelim = "" + delimChar;

		for (int i = 0; i < 72; i++) {
			itemDelim += " ";
		}
		itemDelim += "- INVENTORY -";
		for (int i = 0; i < 73; i++) {
			itemDelim += " ";
		}
		itemDelim += delimChar;
		System.out.println(itemDelim);
		;
		System.out.println(delim);

		for (int i = 0; i < this.openSlot; i++) {
			char equipChar = ' ';
			if (this.invList[i].equiped) {
				equipChar = '@';
			}
			String listRef = "" + this.invList[i].itemCode;
			int counter = listRef.length();
			while (counter < 4) {
				listRef = "0" + listRef;
				counter++;
			}
			System.out.println("" + delimChar + equipChar + "(" + listRef + ")" + equipChar + delimChar + " "
					+ this.invList[i] + " " + delimChar);
		}
		System.out.println(delim);

	}

}