// Plum Tree Garden
// BestCustomer.java

// simple app that stores customer names and purchases made within a restaurant.
// then displays the current best customer (based on the most amount spent at restaurant).


import java.util.*;
import javax.swing.*;
import java.awt.*;



// TODO 1: create class / constructor for class Customer
// 			- name and price as param  
// 1. getName - return customer name
// 2. getPrice - return customer price
// 3. toString() - return string of customer name and price and getPrice
public class Customer {

	// member variables - name & price
	String m_name;
	double m_price;
	
	// class constructor
	Customer(String name, double price)
	{
		m_name = name;
		m_price = price;
		
		System.out.println("");
		System.out.println("*** Customer Added *** - " + toString());
		System.out.println("");
	}
	
	// return name of customer
	public String getName() { return m_name; }
	
	// return price of customer
	public Double getPrice() { return m_price; }
	
	// return printed string of customer name and purchase
	public String toString() {
		
		String name_and_price = "Customer Name: " + getName() + ", Purchase Amount: $" + getPrice();
		
		return name_and_price;
	}
	
	
	public static void main(String[] args) 
	{
		
		Tester tester = new Tester();
		
		Restaurant restaurant = new Restaurant();
		restaurant.addSale(tester.m_cname, tester.m_camount);
		
		Customer customer = new Customer(tester.m_cname, tester.m_camount);

		tester.display();

	}


}


	// TODO 2: create class called restaurant
	// 1. addSale 
	//		- takes customer name 
	// 		- take purchase amount of the customer in the class restaurant and stores it into an array list.  
	// 2. BestCustomer 
	//		- that returns customer name who bought highest sale in the restaurant. 
	class Restaurant
	{
		static ArrayList<String> names = new ArrayList<String>();
		static ArrayList<Integer> sales = new ArrayList<Integer>();
		

		public void addSale(String name, int amount) 
		{ 
			names.add(name);
			sales.add(amount);
		}
		
		
		static public String BestCustomer() 
		{

			int bc = Collections.max(sales);
			int location = sales.indexOf(bc);
			String cust = names.get(location);
			
			return cust;
		}
		
	}
	
	
	// TODO 3:  Write a tester class 
	 
	// 1. prompts the user to enter name 
	// 2. prompts the user to enter purchase of the customers 
    // 3. display the name of the customer who bought highest sales in the restaurant 	
class Tester
{
	String m_cname;
	int m_camount;
	
	Tester()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please input customer name: ");
		m_cname = sc.nextLine();
	
		System.out.println("Please input purchase amount: ");
		m_camount = sc.nextInt();
	}
	
	public void display()
	{
		System.out.println("The customer with highest sale currently is: " + Restaurant.BestCustomer());
	}
	
	
}
