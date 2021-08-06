// Plum Tree Garden
// distinct.java
// when provided with multiple integers, displays only distinct numbers on output


package jac_assignment_one;

import java.util.*;


public class DistinctNumbers {

	public static void main(String[] args) 
	{
		// define: Hashset, Scanner and array of int[10]
		HashSet<Integer> set = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
    
    
		// request input, store as string, split to array of strings
		System.out.print("Input Array of int: ");
		String user_input = sc.nextLine();
		String[] str = user_input.split(" ");
    
    
		// convert array of string to int and prevent duplicate values using hashset
		for(int i = 0; i < str.length; i++)
		{
			int temp = Integer.parseInt(str[i]);
        
			if(!set.contains(temp))
			{
				arr[i] = temp;
				set.add(temp);
			}
		}
    
    
		// display distinct numbers
		System.out.println("Distinct Numbers: " + set.size());
		
		
		// display numbers
		System.out.print("Numbers: ");
		for(int i = 0; i < set.size(); i++)
		{
            System.out.print(arr[i] + " ");
		}
	}
}
