// Plum Tree Garden
// Calculator.java

import java.awt.*;
import javax.swing.*;


public class QuestionFive 
{

	public static void main(String[] args) 
	{
		// 1; CREATE - main window frame
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(300, 350);
		mainFrame.setTitle("Calculator");
		mainFrame.setLayout(null);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
			// 2; CREATE - text component for main window frame
			JTextField txt_field = new JTextField();
			txt_field.setBounds(0, 0, 285,30);

	
			// 3; CREATE panel to hold button components
			JPanel button_panel = new JPanel();
			button_panel.setBounds(0, 30, 285, 280);
			button_panel.setLayout(new GridLayout(4,4));
		
			
				// 4; ADD button components for panels
				button_panel.add(new JButton("7"));
				button_panel.add(new JButton("8"));
				button_panel.add(new JButton("9"));
				button_panel.add(new JButton("/"));
				button_panel.add(new JButton("4"));
				button_panel.add(new JButton("5"));
				button_panel.add(new JButton("6"));
				button_panel.add(new JButton("*"));
				button_panel.add(new JButton("1"));
				button_panel.add(new JButton("2"));
				button_panel.add(new JButton("3"));
				button_panel.add(new JButton("-"));
				button_panel.add(new JButton("0"));
				button_panel.add(new JButton("."));
				button_panel.add(new JButton("="));
				button_panel.add(new JButton("+"));
	
				
		// 5; ADD - panels to main window frame
		mainFrame.getContentPane().add(txt_field);
		mainFrame.getContentPane().add(button_panel);
		
		mainFrame.setVisible(true);
	}

}
