package game.area.dungeon;
import game.area.room.Room;
import game.area.room.Direction;

public class Dungeon1 extends Dungeon {
	
  public Dungeon1() {
	  super(10, 10,10);
    Room[] dungeonMap = new Room[numRooms];
    Room room = new Room();
    room.setDir(Direction.north, 1);
    room.setDir(Direction.south, 2);
    room.setDir(Direction.east, 3);
    
    dungeonMap[0] = room;
    room = new Room();
    room.setDir(Direction.south, 0);
    room.setDir(Direction.east, 4);
    
    dungeonMap[1] = room;
    
    room = new Room();
    room.setDir(Direction.north, 0);
    room.setDir(Direction.west, 5);
    
    dungeonMap[2] = room;
    
    room = new Room();
    room.setDir(Direction.west, 0);
    room.setDir(Direction.north, 4);
    
    dungeonMap[3] = room;
    
    room = new Room();
    room.setDir(Direction.south, 3);
    room.setDir(Direction.west, 1);
    
    
    dungeonMap[4] = room;
    
    room = new Room();
    room.setDir(Direction.west, 2);
    
    dungeonMap[5] = room;
    
      
      
    
    
    
    
  }
  
  
  
  
  
}