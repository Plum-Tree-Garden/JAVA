// Plum Tree Garden
// simpleAllignment.java
// simple gui that re-alligns data input


import java.awt.*;
import javax.swing.*;


public class QuestionFour 
{

	public static void main(String[] args) 
	{
		// 1; CREATE - main window frame
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(475, 200);
		mainFrame.setTitle("Align");
		mainFrame.setLayout(null);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
			// 2; CREATE - panels for components
			JPanel checkBox_panel = new JPanel();
			checkBox_panel.setBounds(15, 30, 150, 100);
			checkBox_panel.setLayout(new GridLayout(2, 1));
			
			JPanel label_panel = new JPanel();
			label_panel.setBounds(175, 30, 50, 100);
			label_panel.setLayout(new GridLayout(2,1));
			
			JPanel text_panel = new JPanel();
			text_panel.setBounds(235, 30, 75, 100);
			text_panel.setLayout(new GridLayout(2,1));
			
			JPanel button_panel = new JPanel();
			button_panel.setBounds(325, 15, 115, 135);
			button_panel.setLayout(new GridLayout(3,1));
		
			
				// 3; CREATE AND ADD - components for panels
				checkBox_panel.add(new JCheckBox("Snap To Grid", false));
				checkBox_panel.add(new JCheckBox("Show Grid", false));
		
				label_panel.add(new JLabel("X:"));
				label_panel.add(new JLabel("Y:"));
				
				text_panel.add(new JTextField(" 8"));
				text_panel.add(new JTextField(" 8"));
			
				button_panel.add(new JButton("OK"));
				button_panel.add(new JButton("Cancel"));
				button_panel.add(new JButton("Help"));
				
				
		// 4; ADD- panels to main window frame
		mainFrame.getContentPane().add(checkBox_panel);
		mainFrame.getContentPane().add(label_panel);
		mainFrame.getContentPane().add(text_panel);
		mainFrame.getContentPane().add(button_panel);
		mainFrame.setVisible(true);
	}

}
