// Plum Tree Garden
// IncomeTax.java

// based on US Income Tax Rates this file takes into account: income bracket, taxable income, filing status and marginal tax rate
// this calculator quantifies total income tax owed for a year given; input: filing status and income bracket 


import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;


public class IncomeTax {
	
	// MARGINAL TAX RATES, FILING STATUS & INCOME BRACKETS
	final double marginalTaxRates[] = {.10, .15, .25, .28, .33, .35};
	
	final String filingStatus[] = {"Single", "Married-joint", "Married-seperate", "Head of Household"};
	
	final int singleIncome[] = {8350, 33950, 82250, 171550, 372950};
	final int mJointIncome[] = {16700, 67900, 137050, 208850, 372950};
	final int mSeperateIncome[] = {8350, 33950, 68525, 104425, 186475};
	final int hohIncome[] = {11950, 45500, 117450, 190200, 372950};
	
	

	// TODO:
	// 1. prompts the user to enter filing status
	// 2. prompts the user to enter taxable incomes
	// 3. calculate the tax. 
	
	// income tax class constructor
	IncomeTax() 
	{
		
		// 1; CREATE - main window frame
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(500, 550);
		mainFrame.setTitle("US Income Tax Rate - Calculator");
		mainFrame.setLayout(null);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// top row label fields
		JPanel filingStatus_panel = new JPanel();
		filingStatus_panel.setBounds(30, 50, 400, 50);
		filingStatus_panel.setLayout(new GridLayout(1,2));

			filingStatus_panel.add(new JLabel("Filing Status"));
			
		
			JComboBox combo = new JComboBox(filingStatus);   
			filingStatus_panel.add(combo);
			
		
		// mid row multi fields
		JPanel income_panel = new JPanel();
		income_panel.setBounds(30, 175, 400, 50);
		income_panel.setLayout(new GridLayout(1,2));
	
			income_panel.add(new JLabel("Income Bracket"));
			JTextField income = new JTextField("");
			income_panel.add(income);
			
			
		// panel for  quantified taxRate
		JPanel bot_panel = new JPanel();
		bot_panel.setBounds(30, 400, 400, 50);
		bot_panel.setLayout(new GridLayout(1,2));

			bot_panel.add(new JLabel("Quantified tax rate owing: "));
			JTextField taxRate = new JTextField("");
			bot_panel.add(taxRate);
			
			// panel for submit to quantify 
			JPanel submit_panel = new JPanel();
			submit_panel.setBounds(30, 275, 400, 50);
			submit_panel.setLayout(new GridLayout(1,1));
			
			    JButton submit = new JButton("Submit");
			    submit.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		            	// income bracket
		            	int incomeBracket = Integer.parseInt(income.getText());
		            	
		            	// filing status
		            	int combo_index = combo.getSelectedIndex();
		                
		            	// marginal tax rate
		            	double marginalRate = 0;
		            	switch(combo_index)
		            	{
		            	case 0: 
		            		
		            		if(incomeBracket <= singleIncome[0]) { marginalRate = marginalTaxRates[0]; }
		            		if(incomeBracket > singleIncome[0] && incomeBracket <= singleIncome[1]) { marginalRate = marginalTaxRates[1]; }
		            		if(incomeBracket > singleIncome[1] && incomeBracket <= singleIncome[2]) { marginalRate = marginalTaxRates[2]; }
		            		if(incomeBracket > singleIncome[2] && incomeBracket <= singleIncome[3]) { marginalRate = marginalTaxRates[3]; }
		            		if(incomeBracket > singleIncome[3] && incomeBracket <= singleIncome[4]) { marginalRate = marginalTaxRates[4]; }
		            		if(incomeBracket > singleIncome[4]) { marginalRate = marginalTaxRates[5]; }	
		            		break;
		            	
		            	case 1:

		            		if(incomeBracket <= mJointIncome[0]) { marginalRate = marginalTaxRates[0]; }
		            		if(incomeBracket > mJointIncome[0] && incomeBracket <= mJointIncome[1]) { marginalRate = marginalTaxRates[1]; }
		            		if(incomeBracket > mJointIncome[1] && incomeBracket <= mJointIncome[2]) { marginalRate = marginalTaxRates[2]; }
		            		if(incomeBracket > mJointIncome[2] && incomeBracket <= mJointIncome[3]) { marginalRate = marginalTaxRates[3]; }
		            		if(incomeBracket > mJointIncome[3] && incomeBracket <= mJointIncome[4]) { marginalRate = marginalTaxRates[4]; }
		            		if(incomeBracket > mJointIncome[4]) { marginalRate = marginalTaxRates[5]; }		  
		            		break;
		            		
		            	case 2:

		            		if(incomeBracket <= mSeperateIncome[0]) { marginalRate = marginalTaxRates[0]; }
		            		if(incomeBracket > mSeperateIncome[0] && incomeBracket <= mSeperateIncome[1]) { marginalRate = marginalTaxRates[1]; }
		            		if(incomeBracket > mSeperateIncome[1] && incomeBracket <= mSeperateIncome[2]) { marginalRate = marginalTaxRates[2]; }
		            		if(incomeBracket > mSeperateIncome[2] && incomeBracket <= mSeperateIncome[3]) { marginalRate = marginalTaxRates[3]; }
		            		if(incomeBracket > mSeperateIncome[3] && incomeBracket <= mSeperateIncome[4]) { marginalRate = marginalTaxRates[4]; }
		            		if(incomeBracket > mSeperateIncome[4]) { marginalRate = marginalTaxRates[5]; }		
		            		
		            		break;
		            		
		            	case 3:
		            		   
		            		if(incomeBracket <= hohIncome[0]) { marginalRate = marginalTaxRates[0]; }
		            		if(incomeBracket > hohIncome[0] && incomeBracket <= hohIncome[1]) { marginalRate = marginalTaxRates[1]; }
		            		if(incomeBracket > hohIncome[1] && incomeBracket <= hohIncome[2]) { marginalRate = marginalTaxRates[2]; }
		            		if(incomeBracket > hohIncome[2] && incomeBracket <= hohIncome[3]) { marginalRate = marginalTaxRates[3]; }
		            		if(incomeBracket > hohIncome[3] && incomeBracket <= hohIncome[4]) { marginalRate = marginalTaxRates[4]; }
		            		if(incomeBracket > hohIncome[4]) { marginalRate = marginalTaxRates[5]; }		
		            		
		            		break;
		            	}
		            	
		            
		            	// quantify tax rate
		            	DecimalFormat df = new DecimalFormat("#.##");
		            	Double total_income = Double.valueOf(incomeBracket);
		            	double total_tax = marginalRate * total_income;
		            	String outputTax = df.format(total_tax);
		            	
		            	// output on text field
		            	taxRate.setText(outputTax);
		            }
		        });
				
			    submit_panel.add(submit);
			
		// 6; ADD - panels to main window frame
		mainFrame.getContentPane().add(filingStatus_panel);
		mainFrame.getContentPane().add(income_panel);
		mainFrame.getContentPane().add(submit_panel);
		mainFrame.getContentPane().add(bot_panel);
		
		mainFrame.setVisible(true);
		
	}

	public static void main(String[] args) 
	{
		// construct income tax object
		IncomeTax incomeTax = new IncomeTax();	
	}
}
