// plum tree garden
// Craps.java

// game of craps without ui


import java.util.*;


public class Craps 
{
	// TODO 1:
	
	// define highest and lowest roll for dice
	int lowestRoll = 1;
	int highestRoll = 6;
	
	// define: (1)dice, (2)randomValue, (3)sum of dice 
	Random r = new Random();
	int dieX = r.nextInt(highestRoll - lowestRoll) + lowestRoll;
	int dieY = r.nextInt(highestRoll - lowestRoll) + lowestRoll;
	int sum = dieX + dieY;
	
	
	// class constructor
	Craps()
	{
		// display first dice roll
		System.out.println("You rolled " + dieX + " + " + dieY + " = " + sum);

		
		// TODO 2:
		if(sum == 7 || sum == 11) 
		{ 
			System.out.println("Congratulations, You win"); 
		}
		
		if(sum == 2 || sum == 3 || sum == 12) 
		{	
			System.out.println("Craps, Better Luck Next Time, You lose"); 
		}
		

		if(sum != 7 && sum != 11 && sum!= 2 && sum != 3 && sum != 12)
		{

			System.out.println("Point is (established) set to " + sum);
			
			// set while loop flags
			int establishedDieValue = sum;			
			int currentDieValue = 0;
			
			// continue loop until game concluded
			while(currentDieValue < establishedDieValue)
			{
				Random r2 = new Random();
				int dieA = r2.nextInt(highestRoll - lowestRoll) + lowestRoll;
				int dieB = r2.nextInt(highestRoll - lowestRoll) + lowestRoll;
				int tempDieValue = dieA + dieB;
				
				System.out.println("You rolled " + dieA + " + " + dieB + " = " + tempDieValue);
				
				// win if re-roll = established
				if(tempDieValue == establishedDieValue)
				{
					System.out.println("Congratulations, You Win");
					currentDieValue = tempDieValue;
				}
				
				// lose if re-roll greate than established
				if(tempDieValue > establishedDieValue)
				{
					System.out.println("Craps, Better Luck Next Time, You lose");
					currentDieValue = tempDieValue;
				}
				
				// re-reroll if re-reroll less than established value
				if(tempDieValue < establishedDieValue)
				{
					Random r3 = new Random();
					int dieI = r3.nextInt(highestRoll - lowestRoll) + lowestRoll;
					int dieJ = r3.nextInt(highestRoll - lowestRoll) + lowestRoll;
					int loopDieValue = dieA + dieB;
					currentDieValue = loopDieValue;
				}	
			}
		}
		
	// constructor end	
	}
	
	
	
	public static void main(String[] args) 
	{
		// construct Craps object
		Craps craps = new Craps();

	}
	
// class end
}
