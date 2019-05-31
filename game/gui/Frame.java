package game.gui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static dropdownListener dropList;

	@SuppressWarnings("unused")
	public Frame() {
		UIManager.put("OptionPane.messageFont", new Font("Monospaced", Font.BOLD, 28));
		UIManager.put("OptionPane.buttonFont", new Font("Monospaced", Font.BOLD, 20));
		UIManager.put("TextField.font", new Font("Monospaced", Font.BOLD, 20));
		UIManager.put("OptionPane.font", new Font("Monospaced", Font.BOLD, 28));
		UIManager.put("ComboBox.font", new Font("Monospaced", Font.BOLD, 28));
		Color color = new Color(210, 180, 140);
		Color color2 = new Color(102, 0, 0);

		Border panelBorder = new LineBorder((Color.GRAY), 5);
		Border buttonBorder = new EtchedBorder(EtchedBorder.LOWERED);

		Choice dropdown = new Choice();
		Frame theFrame = new Frame();
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.setLocation(25, 25);
		panel1.setSize(450, 225);
		panel1.setBorder(panelBorder);
		panel1.add(dropdown);
		panel1.setBackground(color);
		panel1.setVisible(true);
		TextField text = new TextField();
		text.setBackground(color2);
		text.setText(
				"This is the description of the room, if it had one.  I wish i had a description rather than writing this random thing to fill out the size i want for the description.  wheee!");
		panel1.add(text);

		dropdown.add("first choice");
		dropdown.add("second choice");
		dropdown.add("third choice");
		dropdown.add("fourth choice");
		dropdown.setVisible(true);
		dropdownListener dropList = theFrame.new dropdownListener();
		dropdown.addItemListener(dropList);
		theFrame.add(panel1);
		theFrame.setVisible(true);
		theFrame.setSize(500, 500);
		theFrame.setBackground(color);

	}
	

	private class dropdownListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {
			Choice item = (Choice) event.getSource();
			String selected = (String) item.getSelectedItem();
			switch (selected) {
			case "first choice":
				
				break;
			case "second choice":
				break;
			case "third choice":
				break;
			case "fourth choice":
				break;
			}

		}

	}
}
