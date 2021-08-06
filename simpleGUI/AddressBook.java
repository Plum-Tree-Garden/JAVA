// Plum Tree Garden
// AddressBook.java

import java.awt.*;
import javax.swing.*;


public class QuestionSix 
{
	public static void main(String[] args) 
	{	
		// create main frame window
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(700, 350);
		mainFrame.setTitle("Address Book");
		mainFrame.setLayout(null);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
			// top row label fields
			JPanel lbl_panel = new JPanel();
			//lbl_panel.setBackground(Color.red);
			lbl_panel.setBounds(30, 15, 75, 100);
			lbl_panel.setLayout(new GridLayout(2,1));
			
				lbl_panel.add(new JLabel("First Name: "));
				lbl_panel.add(new JLabel("Last Name:  "));
		
				
			// top row text fields	
			JPanel txt_panel = new JPanel();
			txt_panel.setBounds(125, 15, 525, 100);
			txt_panel.setLayout(new GridLayout(2,1));
				
				txt_panel.add(new JTextField(" "));
				txt_panel.add(new JTextField(" "));
		
		
			// mid row multi fields
			JPanel multi_panel = new JPanel();
			multi_panel.setBounds(30, 150, 620, 50);
			multi_panel.setLayout(new GridLayout(1,6));
			
				multi_panel.add(new JLabel("City:"));	
				multi_panel.add(new JTextField(""));
				multi_panel.add(new JLabel("Province:"));
				multi_panel.add(new JComboBox());
				multi_panel.add(new JLabel("Postal Code:"));
				multi_panel.add(new JTextField(""));		
			
			
			// bottom row fields
			JPanel button_panel = new JPanel();
			button_panel.setBounds(30, 225, 620, 50);
			button_panel.setLayout(new GridLayout(1,6));
			
				button_panel.add(new JButton("Add"));
				button_panel.add(new JButton("First"));
				button_panel.add(new JButton("Next"));
				button_panel.add(new JButton("Previous"));
				button_panel.add(new JButton("Last"));
				button_panel.add(new JButton("Update"));
			
		// add panels to main frame		
		mainFrame.getContentPane().add(lbl_panel);
		mainFrame.getContentPane().add(txt_panel);
		mainFrame.getContentPane().add(multi_panel);
		mainFrame.getContentPane().add(button_panel);
		
		mainFrame.setVisible(true);
	}

}
