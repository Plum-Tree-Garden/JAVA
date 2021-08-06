// Plum Tree Garden
// TypingTutor.java


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TypingTutor implements KeyListener
{
	
	// define: Keyboard buttons stored as array
	public static String[] b = 
		{
			"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace",
			"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\", 
			"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "Enter",
			"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?", "\u2191",
			" ", "<", "\u2193", ">"
		};
	
	
	// define: hashmap where -> key = keyCode, value = button string
	public HashMap<Integer, String> map;
	

	// CLASS CONSTRUCTOR
	TypingTutor()
	{
				this.map = new HashMap<Integer,String>();
				
				// keyboard letters Q-P
				map.put(81, b[15]); map.put(87, b[16]); map.put(69, b[17]); map.put(82, b[18]); map.put(84, b[19]);
				map.put(89, b[20]); map.put(85, b[21]); map.put(73, b[22]); map.put(79, b[23]); map.put(80, b[24]);
				
				// keyboard letters A-L
				map.put(65, b[29]); map.put(83, b[30]); map.put(68, b[31]); map.put(70, b[32]); map.put(71, b[33]);
				map.put(72, b[34]); map.put(74, b[35]); map.put(75, b[36]); map.put(76, b[37]);
				
				// keyboard letters Z - M
				map.put(90, b[42]); map.put(88, b[43]); map.put(67, b[44]); map.put(86, b[45]); map.put(66, b[46]);
				map.put(78, b[47]); map.put(77, b[48]);
				
				// keyboard numbers
				map.put(49, b[1]); map.put(50, b[2]); map.put(51, b[3]); map.put(52, b[4]); map.put(53, b[5]);
				map.put(54, b[6]); map.put(55, b[7]); map.put(56, b[8]); map.put(57, b[9]); map.put(48, b[10]);
				
				// keyboard special characters
				map.put(192, b[0]);  map.put(45, b[11]); map.put(61, b[12]); map.put(8, b[13]);  map.put(9, b[14]);
				map.put(91, b[25]);  map.put(93, b[26]); map.put(92, b[27]); map.put(20, b[28]); map.put(59, b[38]);
				map.put(222, b[39]); map.put(10, b[40]); map.put(16, b[41]); map.put(44, b[49]); map.put(46, b[50]);
				map.put(47, b[51]);  map.put(38, b[52]); map.put(32, b[53]); map.put(37, b[54]); map.put(40, b[55]);
				map.put(39, b[56]);
				
				
		// 1; CREATE - main window frame
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(750, 550);
		mainFrame.setTitle("Typing Tutor");
		mainFrame.setLayout(null);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
			// 2; CREATE - label component for top of main window frame
			JLabel lbl_field = new JLabel("<html>Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed. <br> "
					+ "Note: Clicking the buttons with your mouse will not perform any action.</html>");
			lbl_field.setBounds(15, 10, 750, 30);
			
			
			// 3; CREATE - text area component for middle of main window frame
			JTextArea area_field = new JTextArea();  
			area_field.setBounds(15, 50, 700, 175);
			area_field.addKeyListener(this);
			
			
			// 4; CREATE - button panel to hold button components for bottom of main window frame
			JPanel button_panel = new JPanel();
			button_panel.setBounds(15, 250, 700, 250);
		
			button_panel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			
			// 5; ADD button components for panels			
			for(int i = 0; i < 14; i++)
			{
				keyBoard[i] = new JButton(b[i]);
				gbc.weightx = 1;
				gbc.gridx = i;
				gbc.gridy = 0;	
				gbc.ipady = 10;
				button_panel.add(keyBoard[i], gbc);
			}
			for(int i = 0; i < 14; i++)
			{
				keyBoard[i + 14] = new JButton(b[i + 14]);
				gbc.weightx = 1;
				gbc.gridx = i;
				gbc.gridy = 1;
				gbc.ipady = 10;
				button_panel.add(keyBoard[i + 14], gbc);
			}
			for(int i = 0; i < 13; i++)
			{
				keyBoard[i + 28] = new JButton(b[i + 28]);
				gbc.weightx = 1;
				gbc.gridx = i;
				gbc.gridy = 2;
				gbc.ipady = 10;
				button_panel.add(keyBoard[i + 28], gbc);
			}
			for(int i = 0; i < 11; i++)
			{
				keyBoard[i + 41] = new JButton(b[i + 41]);
				gbc.weightx = 1;
				gbc.gridx = i;
				gbc.gridy = 3;
				gbc.ipady = 10;
				button_panel.add(keyBoard[i + 41], gbc);
			}
			
			keyBoard[52] = new JButton(b[52]);
			gbc.weightx = 1;
			gbc.gridx = 12;
			gbc.gridy = 3;
			gbc.ipady = 10;
			button_panel.add(keyBoard[52], gbc);
			
			keyBoard[53] = new JButton(b[53]);
			gbc.weightx = 1;
			gbc.gridx = 3;
			gbc.gridy = 4;
			gbc.ipady = 10;
			gbc.gridwidth = 5;
			button_panel.add(keyBoard[53], gbc);
			
			for(int i = 0; i < 3; i++)
			{
				keyBoard[i + 54] = new JButton(b[i + 54]);
				gbc.weightx = 1;
				gbc.gridx = i + 11;
				gbc.gridy = 4;
				gbc.ipady = 10;
				gbc.gridwidth = 1;
				if(i == 2)
				{
					gbc.insets = new Insets(0,0,0,50);
				}
				button_panel.add(keyBoard[i + 54], gbc);
			}
		
				
		// 6; ADD - panels to main window frame
		mainFrame.getContentPane().add(lbl_field);
		mainFrame.getContentPane().add(area_field);
		mainFrame.getContentPane().add(button_panel);
		
		mainFrame.setVisible(true);
		
	}
	
	
	// 7; DEFINE KEY LISTENERS
	
	// define: jbuttons for keyboard grid
	public static JButton[] keyBoard = new JButton[b.length];
	

	@Override
	public void keyTyped(KeyEvent e) {}

	
	// define: event when key is pressed
	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		String keyString = this.map.get(key);

		// IF KEYBOARD STRING == HASH STRING
		// convert arry to list -> retrieve indexOf -> set Jbutton background color
		if(keyString == map.get(key))
		{
			int keyIndex = Arrays.asList(b).indexOf(keyString);
			keyBoard[keyIndex].setBackground(Color.BLUE);
		}

	}
	
	
	// define: event when key is released
	@Override
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		String keyString = this.map.get(key);
		
		// IF HASHMAP BUTTON RELEASED -> SET BACKGROUND COLOR OF BUTTON TO NULL
		if(keyString == map.get(key))
		{
			int keyIndex = Arrays.asList(b).indexOf(keyString);
			keyBoard[keyIndex].setBackground(null);
		}
	
	}

}
