// Plum Tree Garden
// Printer.java
//  simple gui that prepares document to print

import java.awt.*;
import javax.swing.*;


public class QuestionSeven 
{
	public static void main(String[] args) 
	{
		// 1; CREATE - main window frame
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(625, 250);
		mainFrame.setTitle("Printer");
		mainFrame.setLayout(null);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
			// 2; TOP LEVEL UI - component label added directly to frame
			JLabel label_top = new JLabel("Printer: MyPrinter");
			label_top.setBounds(50, 20, 100, 15);
			
			
			// 3; MID LEVEL UI - panel and components added directly to frame
			JTextField txt_mid_first = new JTextField();
			txt_mid_first.setBounds(50, 50, 75, 100);
			
			
			JPanel box_mid_second = new JPanel();
			box_mid_second.setBounds(125, 50, 75, 100);
			box_mid_second.setLayout(new GridLayout(3, 1));
			
				box_mid_second.add(new JCheckBox("Image", false));
				box_mid_second.add(new JCheckBox("Test", false));			
				box_mid_second.add(new JCheckBox("Code", false));
			
				
			JTextField txt_mid_third = new JTextField();
			txt_mid_third.setBounds(200, 50, 50, 100);

			
			JPanel radio_mid_fourth = new JPanel();
			radio_mid_fourth.setBounds(250, 50, 100, 100);
			radio_mid_fourth.setLayout(new GridLayout(3, 1));
			
				radio_mid_fourth.add(new JRadioButton("Selection"));
				radio_mid_fourth.add(new JRadioButton("All"));			
				radio_mid_fourth.add(new JRadioButton("Applet"));
			
				
			JTextField txt_mid_fifth = new JTextField();
			txt_mid_fifth.setBounds(350, 50, 75, 100);			
			
			
			// 4; BOTTOM LEVEL UI - panel and components
			JPanel bottom_panel = new JPanel();
			bottom_panel.setBounds(70, 165, 325, 30);
			bottom_panel.setLayout(new GridLayout(1,3));
			
				bottom_panel.add(new JLabel("Print Quality:"));
				
				String[] combo_string = {"High"};
				JComboBox combo_bot = new JComboBox(combo_string);
				bottom_panel.add(combo_bot);
				
				JCheckBox cb_bot = new JCheckBox("Print to File", false);
				cb_bot.setHorizontalAlignment(cb_bot.RIGHT);
				bottom_panel.add(cb_bot);
				
				
			// 5; RIGHT SIDE - panels and components
			JPanel button_panel = new JPanel();
			button_panel.setBounds(450, 5, 125, 200);
			button_panel.setLayout(new GridLayout(4,1, 0, 5));
			
				button_panel.add(new JButton("OK"));
				button_panel.add(new JButton("Cancel"));
				button_panel.add(new JButton("Setup..."));
				button_panel.add(new JButton("Help"));
				
				
		// 6; ADD - panels and components to main window frame
		mainFrame.add(label_top);
		mainFrame.add(txt_mid_first);
	    mainFrame.getContentPane().add(box_mid_second);
	    mainFrame.add(txt_mid_third);
		mainFrame.getContentPane().add(radio_mid_fourth);
		mainFrame.add(txt_mid_fifth);
		mainFrame.getContentPane().add(bottom_panel);
		mainFrame.getContentPane().add(button_panel);
		
		mainFrame.setVisible(true);
	}

}
