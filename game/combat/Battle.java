package game.combat;

import game.Game;
import game.creature.monster.Monster;
import game.creature.player.Player;
import game.gui.MenuFrame;

public class Battle {
	Player thePlayer;
	Monster theMonster;
	Monster[] monsterQueue;
	int roundNumber;
	boolean done;
	public Battle(Monster monster) {
		this(MenuFrame.getCurrentGame().thePlayer, monster, null);
		
	}
	
	public Battle(Player player, Monster monster) {
	this(player,monster,null);
	
	}
	public Battle(Player player, Monster monster, Monster[] monsters) {
		this.thePlayer = player;
		this.theMonster = monster;
		this.monsterQueue = monsters;
	}
	
	


}
