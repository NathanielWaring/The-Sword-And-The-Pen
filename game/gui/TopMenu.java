package game.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TopMenu extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private JMenu[] topMenus;
	private JMenuItem[][] menuItems;
	
	private String topMenuNames[] = {"File","Character","Map"};
	private String[] fileItemNames = {"New","Save","Load","Exit"};
	private String[] characterItemNames = {"Inventory","Stats","Skills"};
	private String[] mapItemNames = {"Show Map","Explore","3rd","4th","5th","6th","7th"};
	
	private String[][] menuItemNames = {fileItemNames,characterItemNames,mapItemNames};
	public TopMenu() {
		int longest = 0;
		for(String[] s: menuItemNames) {
			System.out.println(s.length);
			if (s.length>longest) {
				longest = s.length;
				
			}
		}
		topMenus = new JMenu[topMenuNames.length];
		menuItems = new JMenuItem[topMenus.length][longest];
		for(int i = 0;i < topMenuNames.length;i++) {
			topMenus[i] = new JMenu(topMenuNames[i]);
			for (int j = 0;j<menuItemNames[i].length;j++) {
				menuItems[i][j]= new JMenuItem(menuItemNames[i][j]);
				topMenus[i].add(menuItems[i][j]);
				this.add(topMenus[i]);
			}
			topMenus[i].setVisible(true);
			
		}
	}

}
