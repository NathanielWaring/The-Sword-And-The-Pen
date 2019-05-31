package game.area.room;

public enum Direction {
east, west, north, south, northwest, northeast, southwest, southeast, up, down;
	public boolean isVisible = false;;
	public int dirNum;
	public int leadsTo;

	public Direction opposite(Direction dir) {
		Direction opp = null;
		
		switch (dir) {
		case east:
			opp = west;
			break;
		case down:
			opp = up;
			break;
		case north:
			opp = south;
			break;
		case northeast:
			opp = southwest;
			break;
		case northwest:
			opp = southeast;
			break;
		case south:
			opp = north;
			break;
		case southeast:
			opp = northwest;
			break;
		case southwest:
			opp = northeast;
			break;
		case up:
			opp = down;
			break;
		case west:
			opp = east;
			break;
		default:
			opp = null;
			break;
			
		}
		
		
		
		return opp;
	}
	
	
}
