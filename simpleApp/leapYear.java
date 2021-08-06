// Plum Tree Garden
// leapYear.java
// displays leap years between 2 given dates


package jac_assignment_one;

import java.util.*;


public class Question_One 
{
	public static void main(String[] args) 
	{
		// min / max / current year in which leap years are calculated as well as count for newline
		final int minYear = 101;
		final int maxYear = 2500;
		int year = minYear;
		int count = 0;
		
		
		// define calender with method to derive leap years
		GregorianCalendar calendar = new GregorianCalendar();
		
		
		// display leap years between min and max year using 8 dates per line 
		System.out.println("Leap years between " + minYear + " and " + maxYear + ":");
		
		while(year != maxYear)
		{
		    if(calendar.isLeapYear(year))
		    {
		        System.out.print(year + " ");
		        count++;
		        year++;
		        
		        
		        if(count % 8 == 0)
		        {
		            System.out.print("\n" + year + " ");
		            count++;
		            year++;
		        }
		        
		    }
		    else
		    {
		        year++;
		    }
		    
		}
		
	}
}
