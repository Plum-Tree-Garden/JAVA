// PlumTreeGarden
// FC_Converter.java
// converts Fahrenheit to Celsius


import java.util.*;


public class FC
{
	public static void main(String[] args) 
	{
		// scan user input for temperature in Farenheit
		Scanner sc = new Scanner(System.in);
		System.out.print("Input Temperature as degrees in Farenheit: ");
		double farenheit = sc.nextDouble();
		
	
		// convert farenheit to celsius
		double celsius = ((farenheit - 32) * 5) / 9;
		
	
		// display temperature in Celsius by 2 decimal places
		System.out.println("The Temperature as degrees in Celsius is: " + String.format("%.2f", celsius));
	}
}
