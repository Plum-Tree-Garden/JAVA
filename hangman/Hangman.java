// Plum Tree Garden
// Hangman.java

// Simple game of hangman with 20 pre-defined words chosen at random.

import java.util.*;

public class Hangman {

	public static void main(String[] args) {
		
		// define 20 words
		String dictionary[] = { "when", "i", "was", "a", "young",
				"boy", "who", "was", "honest", "and",
				"they", "had", "more", "self", "control",
				"if", "we", "were", "tempted", "would" };
		
		
		// set random generation for call to string array of 20
		Random r = new Random();
		int lowest = 0;
		int highest = 19;
		int result = r.nextInt(highest-lowest) + lowest;
		
		
		// define / display word / length
		String randomResult = dictionary[result];
		int wordLength = randomResult.length();

	    
		// define an array of characters to hold the question word and the users answer
		char[] question = new char[randomResult.length()];
	    char[] answer = new char[randomResult.length()];
	      
	        // copy string character by character into array
	        for (int i = 0; i < randomResult.length(); i++) {
	            question[i] = randomResult.charAt(i);
	            answer[i] = '_'; 
	        }

			// display current array of guessed characters
	        System.out.println("");
			System.out.println("Guess This Word!: ");
	        for(int i = 0; i < randomResult.length(); i++)
	        {
	        	System.out.print(answer[i] + " ");
	        	
	        }
	        System.out.println("");
	        
	        
	        // define while loop that will only end when user guesses all correct letters
	        int letterCount = 0;
	        while(letterCount != wordLength)
	        {
	        	System.out.println("");
	        	Scanner sc = new Scanner(System.in);
	        	System.out.print("Guess a character: ");
	        	char c = sc.next().charAt(0);
	        	
	        	// loop through answer character array and compare to letter input
	        	// end loop if the amount of correct characters input == amount of chars in answer
	        	for(int i = 0; i < randomResult.length(); i++)
	        	{
	        		if(c == question[i])
	        		{
	        			answer[i] = c;
	        			letterCount++;
	        		}
	        	}
	        	
	        	// display current status of char solution
	        	System.out.println("");
	        	for(int i = 0; i < randomResult.length(); i++)
	        	{
	        		System.out.print(answer[i] + " ");
	        	}
	        	
	        	// display congrats message upon solution
	        	System.out.println("");
	        	if(letterCount == wordLength)
	        	{
	        		System.out.println("Yay you guessed it");
	        	}
	        	
	        }
	}

}
