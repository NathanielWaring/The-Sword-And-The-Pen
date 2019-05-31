package game;

import java.awt.HeadlessException;
import javax.swing.JApplet;
import game.gui.MenuFrame;

public class GameApplet extends JApplet {
	private static final long serialVersionUID = 1L;

	public GameApplet() throws HeadlessException {
		super();
		
	}
	public void init() {
	
		MenuFrame menu = new MenuFrame();
		menu.setVisible(true);
	}

}
