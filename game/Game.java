package game;

import java.io.Serializable;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import game.creature.Alignment;
import game.creature.Gender;
import game.creature.Race;
import game.creature.guild.Guild;
import game.creature.guild.Guild.GuildType;
import game.creature.player.Player;
import game.item.Item;
import game.item.armour.Armour;
import game.item.armour.Armour.ArmourEffect;
import game.item.armour.Armour.Slot;
import game.item.armour.Armour.SubSlot;
import game.item.weapon.Weapon;
import game.mechanics.Tick;

public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final char delimChar = '#';
	public static final String delim = "#####";
	public Player thePlayer;
	public int gameID;
	private static String fileUrl = "gameSave.ser";
	public Tick tick;
	
	private static int gameTotal = 0;
	public static Game[] gameList = new Game[99];
	

	public Game() {
	
	}




	public void newGame() {
		//tick = new Tick();
		//tick.start();
		gameList[gameTotal] = this;
		gameID = gameTotal++;
		
		String name, customRace, customGender;
		Race race;
		Gender gender;
		Alignment alignment;
		GuildType guild;
		Race[] races = Race.values();
		Gender[] genders = Gender.values();
		Alignment[] alignments = Alignment.values();
		GuildType[] guilds = Guild.GuildType.values();
		name = JOptionPane.showInputDialog(null, "Enter name: ", "New Game", JOptionPane.QUESTION_MESSAGE);

		race = (Race) JOptionPane.showInputDialog(null, "Choose Race: ", "New Game",
				JOptionPane.QUESTION_MESSAGE, null, races, races[1]);
		if (race.equals(Race.custom)) {
			customRace = JOptionPane.showInputDialog(null, "Enter custom race: ", "New Game",
					JOptionPane.QUESTION_MESSAGE);
		} else {
			customRace = null;
		}

		gender = (Gender) JOptionPane.showInputDialog(null, "Choose Gender: ", "New Game",
				JOptionPane.QUESTION_MESSAGE, null, genders, genders[1]);
		if (gender.equals(Gender.custom)) {
			customGender = JOptionPane.showInputDialog(null, "Enter custom gender: ", "New Game",
					JOptionPane.QUESTION_MESSAGE);
		} else {
			customGender = null;
		}

		alignment = (Alignment) JOptionPane.showInputDialog(null, "Choose Race: ", "New Game",
				JOptionPane.QUESTION_MESSAGE, null, alignments, alignments[0]);
		guild = (GuildType) JOptionPane.showInputDialog(null, "Choose Guild: ", "New Game",
				JOptionPane.QUESTION_MESSAGE, null, guilds, guilds[0]);

		thePlayer = new Player(race, customRace, gender, customGender, name, guild, alignment, 1);
		thePlayer.newInv(10, 10);
		Item newItem = new Weapon();
		thePlayer.getInventory().addItem(newItem);
		newItem = new Armour("Unknown", 1, 10, Slot.head, SubSlot.randomSubSlot(Slot.head), ArmourEffect.none, 1);
		thePlayer.getInventory().addItem(newItem);
		newItem = new Armour("Unknown", 1, 10, Slot.torso, SubSlot.randomSubSlot(Slot.torso), ArmourEffect.none, 1);
		thePlayer.getInventory().addItem(newItem);
		newItem = new Armour("Unknown", 1, 10, Slot.legs, SubSlot.randomSubSlot(Slot.legs), ArmourEffect.none, 1);
		thePlayer.getInventory().addItem(newItem);
		newItem = new Armour("Unknown", 1, 10, Slot.feet, SubSlot.randomSubSlot(Slot.feet), ArmourEffect.none, 1);
		thePlayer.getInventory().addItem(newItem);
		
		Game.updateGamelist();

	}
	
	public void saveGame(int gameId) {

		FileOutputStream fileOout = null;
		ObjectOutputStream objectOut = null;

		try {

			fileOout = new FileOutputStream(getFileUrl()+gameId);
			objectOut = new ObjectOutputStream(fileOout);
			objectOut.writeObject(this);

			System.out.println("Done");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fileOout != null) {
				try {
					fileOout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (objectOut != null) {
				try {
					objectOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
		public static Game loadGame(String fileUrl) {
			Game gameOut = null;
			FileInputStream fileIn = null;
			ObjectInputStream objectIn = null;
			
			try {				
				fileIn = new FileInputStream(fileUrl);
				objectIn = new ObjectInputStream(fileIn);
				gameOut = (Game) objectIn.readObject();
				
			} catch (Exception e ){
				e.printStackTrace();
			} finally {
				
				if (fileIn!=null) {
					try {
						fileIn.close();
					} catch (IOException ie) {
						ie.printStackTrace();
					}
				}
				if (objectIn!=null) {
					try {
						objectIn.close();
					} catch (IOException ie) {
						ie.printStackTrace();
					}
				}				
			}
			
			return gameOut;
			
		}
		
		public static void updateGamelist() {
			
		}
		
		public static void loadGameList() {
			
			
			Game.gameList = null;
		}



		public static String getFileUrl() {
			return fileUrl;
		}



		public void setFileUrl(String fileUrl) {
			Game.fileUrl = fileUrl;
		}
		
	}
