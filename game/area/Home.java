package game.area;

import game.area.room.Room;
import game.creature.Alignment;
import game.creature.Creature;
import game.creature.Gender;
import game.creature.Race;
import game.creature.guild.Guild;
import game.creature.monster.Monster;
import game.item.Item;
import game.item.weapon.Weapon.DamType;
import game.item.weapon.dagger.Dagger;
import game.item.weapon.dagger.Dagger.DaggerType;

public class Home extends Area {

	public Home() {
		this(10, 10, 6, 15);
	}

	public Home(int x, int y, int z, int numRooms) {
		super(x, y, z, numRooms);
		// room 0 - starting room //
		Room newRoom;
		Creature newCreature;
		Item newItem;
		newRoom = new Room(true, false, false, false, false, false, false, false, false, false);
		newRoom.setLoc(5, 5, 2);
		newRoom.setDesc("This small room has no windows and only one door. "
				+ "In the middle there is a bed, if you can call it that. "
				+ "It is a pile of hay with a burlap blanket draped accross.");
		this.addRoom(newRoom);
		this.areaMap[5][5][2] = true;
		// room 1 - alley east of starting room //
		newRoom = new Room(false, true, true, true, false, false, false, false, false, false);
		newRoom.setLoc(6, 5, 2);
		newRoom.setDesc("You are in an alley which leads to the north and south."
				+ "  To your north is a busy road, with all manner of people hurrying by."
				+ "  To your west is the doorway to a small room."
				+ "  You can see the alley comes to a dead end a little way to the south.");
		this.addRoom(newRoom);

		this.areaMap[6][5][2] = true;
		// room 2 - one north of end of alley //
		newRoom = new Room(false, false, true, true, false, false, false, false, false, false);
		newRoom.setLoc(6, 4, 2);
		newRoom.setDesc("You are getting near the southern end of the alley.  "
				+ "The sounds coming from the road to your north is no longer audible, "
				+ "and has been replaced by a gentle moaning comnig from the south.");
		this.addRoom(newRoom);
		this.areaMap[6][4][2] = true;
		// room 3 - end of alley //
		newRoom = new Room(false, false, true, false, false, false, false, false, false, false);
		newRoom.setLoc(6, 3, 2);
		newRoom.setDesc("You have come to the end of the alley, and found yourself face to face with a lankey orc, "
				+ "who is holding his arm and moaing.  His arm is wrapped in a bandage that is stained red accross the middle."
				+ "  As you approach he scrambles to his feat and pulls out a sharp looking knife");
		newCreature = new Monster(Race.orc, Gender.male, "Ug-Nak", Guild.GuildType.thief, Alignment.CHAOTIC_NEUTRAL, 1);
		newItem = new Dagger("Sharp Knife", 3, 10, 1, 6, 0, DamType.none, false, DaggerType.knife);
		newCreature.getInventory().addItem(newItem);
		newRoom.addToCreatureList(newCreature);
		this.addRoom(newRoom);
		this.areaMap[6][3][2] = true;
		// room 4 - intersection of road and alley //
		newRoom = new Room(true, true, false, true, false, false, false, false, false, false);
		newRoom.setLoc(6, 6, 2);
		newRoom.setDesc("You are standing on the main road of a small village."
				+ "  The road leads to an inn to the east, and to a gate leading beyond it's walls to the west."
				+ "  To the south is a dark and dirty looking alley.");
		this.addRoom(newRoom);
		this.areaMap[6][6][2] = true;
		// room 5 - one from the east end of road //
		newRoom = new Room(true, true, true, false, false, false, false, false, false, false);
		newRoom.setLoc(7, 6, 2);
		newRoom.setDesc("You are standing on the main road of a small village."
				+ "  The road leads to an inn to the east, and to a gate leading beyond it's walls to the west."
				+ "  To the north lies a green house with a blue front door.");
		this.addRoom(newRoom);
		this.areaMap[7][6][2] = true;
		// room 6 -east end of road //
		newRoom = new Room(true, true, true, false, false, false, false, false, false, false);
		newRoom.setLoc(8, 6, 2);
		newRoom.setDesc("You are standing on the main road of a small village."
				+ "  The road ends to your east at the entrance to a large inn. "
				+ " Far in the distance is a gate leading beyond it's walls to the west."
				+ "  To the north lies a brown house with a white front door.");
		this.addRoom(newRoom);
		this.areaMap[8][6][2] = true;
		// room 7 - inn //
		newRoom = new Room(false, true, true, true, false, false, false, false, true, false);
		newRoom.setLoc(9, 6, 2);
		newRoom.setDesc("You are standing in the main hall of the inn.  To your north and south are rooms, "
				+ "and a staircase leads up to a second floor.  "
				+ "There is a desk with a pleasant looking human behind it.  ");
		this.addRoom(newRoom);
		this.areaMap[9][6][2] = true;

		this.roomList[0].setToEast(this.roomList[1]);
		this.roomList[1].setToWest(this.roomList[0]);
		this.roomList[1].setToSouth(this.roomList[2]);
		this.roomList[2].setToNorth(this.roomList[1]);
		this.roomList[2].setToSouth(this.roomList[3]);
		this.roomList[3].setToNorth(this.roomList[2]);
		this.roomList[4].setToSouth(this.roomList[1]);
		this.roomList[1].setToNorth(this.roomList[4]);
		this.roomList[4].setToEast(this.roomList[5]);
		this.roomList[5].setToWest(this.roomList[4]);
		this.roomList[5].setToEast(this.roomList[6]);
		this.roomList[6].setToWest(this.roomList[5]);
		
		
		
	}

}
