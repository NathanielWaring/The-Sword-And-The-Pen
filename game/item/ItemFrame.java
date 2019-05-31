package game.item;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import game.gui.MenuFrame;

public class ItemFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	public ItemFrame() {
		this.setVisible(true);
		this.setPreferredSize(new Dimension(100,800));
		
		JPanel itemPanel = new JPanel();
		
		itemPanel.setBackground(game.gui.MenuFrame.getColor_beige());
		itemPanel.setBorder(new LineBorder(Color.BLACK));
		itemPanel.setVisible(true);
		itemPanel.setPreferredSize(this.getPreferredSize());
		this.add(itemPanel);
		
		
		
	}
	
	
	
	
	
	
	
	
}
