import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class P3Driver_ZS949996 {
	
	public static int searchTracker = 0;//this keeps the index of the array of orders
	public static int quantTrackerR = 0;
	public static int quantTrackerB = 0;
	public static int quantTrackerS = 0;
	public static ProductR[] productsR = new ProductR[100]; // nobody is going to order  more than 100 things so the array is set to 100
	public static ProductB[] productsB = new ProductB[100];
	public static ProductS[] productsS = new ProductS[100];
	public static int[] PRQuant = new int[100];
	public static int[] PBQuant = new int[100];
	public static int[] PSQuant = new int[100];
	public static Date[] dates = new Date[100];//the array of dates
	public static char golbalTempType;
	public static Order[] listOfOrders = new Order[100];//the array of orders
	static int temp=0;//needed for a bug fix
	
	
	/**
	 * This method is my project 1 modified slightly to take in a string "MM/DD/YYYY" and turn those into 
	 * variables month, day, and year create a new object of Date class and return that object
	 * 
	 * 
	 * @return Date, this method returns an object of class date.
	 */
	public static Date inputDate()
	{
		Scanner keyboard = new Scanner (System.in);
	    //Initializing variables
		int month = 0;
		int day = 0;
		int year = 0;
		//int ABSyear = 0;
		String yearChecker;
		String yearFinal;
		//String monthName;
		boolean leapYear = false;
		
		
		String wholedate;
		System.out.println("Please type the date of purchase: MM/DD/YYYY");
		wholedate = keyboard.nextLine();
		String[] dateArray = wholedate.split("/");
		
		month = Integer.parseInt(dateArray[0]);
		day = Integer.parseInt(dateArray[1]);
		year = Integer.parseInt(dateArray[2]);
		
		//inputing month and checking if month is valid
		//System.out.println("Please type the month of purchase (a whole number from 1-12).");
		//month = keyboard.nextInt();
		while (month < 0 || month > 12){
			System.out.println("That is not a valid month, please type a number between 1 and 12.");
			month = keyboard.nextInt();
		}
		
		
		//this section inputs the day 
		//System.out.println("Please type the day of purchase (a whole number from 1-31 depending on the month).");
		//day = keyboard.nextInt();
		
		
		//System.out.println("Please type the year of purchase (any whole number).");
		//year = keyboard.nextInt();
		//keyboard.nextLine();//this gets rid of the enter that is put in the buffer after the nextInt
		
		yearChecker = Integer.toString(year);//I've done this to use the .length method
		yearFinal = Integer.toString(year);// same here
		
		
		
		//this makes it so that any number can be inputed for the year and still receive an output
		/*if (year < 0)
		{
			ABSyear = Math.abs(year);
		}
		else
			ABSyear = year;*/
		
		
		
		//for positive years depending on the length of input
		if (yearChecker.length() == 1)
		{
			yearFinal = "200" + yearFinal;
		}
		else if (yearChecker.length() == 2)
		{
			yearFinal = "20" + yearFinal;
		}
		else if (yearChecker.length() == 3)
		{
			yearFinal = "2" + yearFinal;
		}
		
		
		//determining if the year is a leap year
		if (year%400 == 0){
			leapYear = true;
		}
		else if (year%100 == 0){
			leapYear = false;
		}
		else if (year%4 == 0){
			leapYear = true;
		}
		else {
			leapYear = false;
		}
		
		/* This section checks if the day in a given month is valid this has to run after the leap year check.
		 * This is so that February 29 can be inputed only on leap years 
		 * The nextLine's are there for the weird buffer thing that happens when inputing integers
		 * */
		if (month == 1 || month == 3 ||month == 5 || month == 7 || month == 8 || month == 10 || month == 12) //for months that are 31 days long
		{
			while (day < 1 || day > 31)
			{
				System.out.println("That is not a valid day, please try again.");
				day = keyboard.nextInt();
				keyboard.nextLine();
			}
		}
		else if (month == 4 || month == 6 || month == 9 || month == 11) //for months that are 30 days long
		{
			while (day < 1 || day > 30)
			{
				System.out.println("That is not a valid day, please try again.");
				day = keyboard.nextInt();
				keyboard.nextLine();
			}
		}
		else if (month == 2 && leapYear == true)// for leap years on February
		{
			while (day < 1 || day > 29)
			{
				System.out.println("That is not a valid day, please try again.");
				day = keyboard.nextInt();
				keyboard.nextLine();
			}
		}
		else if (month == 2) //for February normally
		{
			if (day == 29)
				System.out.println("That isn't a leap year.");
				while (day < 1 || day > 28)
			{
				System.out.println("That is not a valid day, please try again.");
				day = keyboard.nextInt();
				keyboard.nextLine();
			}
		}
		else if (month == 0)
		{
			System.out.println("That is not a valid day, please try again.");
			day = keyboard.nextInt();
		}
		else
			System.out.println("An error has occured I applogize");
		
		
		//dates[searchTracker] = new Date(month, day, Integer.parseInt(yearFinal));
		Date newDate = new Date(month, day, Integer.parseInt(yearFinal));
		//System.out.println("Hash Code: " + newDate.hashCode());
		return newDate;

		
	}
	
	
	/**
	 * All this does is print the options of what the user can do
	 */
	public static void menu()  
	{
		System.out.println("(I)nventory");
		System.out.println("(O)rder");
		System.out.println("(R)eview");
		System.out.println("(E)xit");
	}
	
	
	/**
	 * This method makes sure that the user has inputed one the four valid choices
	 * 
	 * @return String, this returns a string of a valid choice.
	 */
	public static String checkInput()
	{
		Scanner keyboard = new Scanner (System.in);
		
		String input = keyboard.nextLine(); //forces the user to input one of those 8 options
		while (!input.equals("I") && !input.equals("O") && !input.equals("R") && !input.equals("E") &&
           	   !input.equals("i") && !input.equals("o") && !input.equals("r") && !input.equals("e"))
		{
			System.out.println("Invalid choice");
			input = keyboard.nextLine();
		}
		
		return input;
	}
	
	
	/**
	 * This prints the inventory in a nice way with semicolons replaced with spaces and a dollar sign in front of the price
	 */
	//buffered reader taken from "Java File Input/Output - It's way Easier Than You Think" from coding with John
	public static void showInventory()
	{
		String file = "Inventory.txt";//the file we are reading
		try {//needed to put in a try catch
			BufferedReader br = new BufferedReader(new FileReader(file));//setting up the buffered reader
			
			String[] tempArray;
			String line;
			/* A bit of a round about way of doing this but I wanted to remove the 
			 * semicolons and replace with spaces and add dollar signs so this is what I did */
			while((line = br.readLine()) != null) 
			{
				tempArray = line.split(";");
				System.out.println(tempArray[0]+ " " + tempArray[1]+ " $" + tempArray[2] + " " + tempArray[3]);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * This checks if the user has inputed a positive integer by using the CheckIfInt() method to return an int
	 * 
	 * 
	 * @return Int, returns a positive integer 
	 * @see CheckIfInt(), this calls the CheckIfInt() method
	 */
	public static int positiveChecker()//makes the user input a positive integer
	{
		Scanner keyboard = new Scanner (System.in);//keyboard
		
		int input = CheckIfInt();//makes the user input an integer
		while (input < 0)//runs while the input is less than 0
		{
			System.out.println("please type a positive number.");
			input = CheckIfInt();
		}
		
		return input;//returns the positive integer
	}
	
	
	/**
	 * This checks if the user has inputed something that contains an int by using hasNextInt()
	 * 
	 * @return this returns an integer that the method forced the user to give
	 */
	public static int CheckIfInt()
	{
		Scanner keyboard = new Scanner(System.in);//creates keyboard
		
		int i = 0;// the integer variable which will store the user input
		boolean repeat = true;// the repeat variable
		while (repeat == true)//runs until the user inputs an integer
		{
			if (keyboard.hasNextInt())//checks if the the input has an integer in it
			{
				i = keyboard.nextInt();//if it does then i = the integer
				repeat = false;//stops the loop
			}
			else//if the input doesn't have an integer then the user is forced to input again
			{
				System.out.println("Invalid input, please type a whole number.");
				keyboard.next();
			}
		}
		
		return i;//returns the integer
	}
	
	
	/**
	 * This first reads the file Inventoty.txt  it then turns each Item separated by a semicolon into a temporary array
	 * It then checks if what the user inputed is contained within the string of any names or index 1 of the temporary array
	 * If it is true then The order is sorted depending upon they type or index 3.
	 * After that happens we create a new object using the values in the temporary array we then add this object to a
	 * Global array called ProductsR, ProductsB, or ProductsS depending on the type
	 * Finally we return this object
	 * 
	 * @return Product this returns one of the product objects depending upon what type it was
	 */
	public static Product SearchNames()
	{
		Scanner keyboard = new Scanner (System.in);//keyboard
		
		System.out.println("What would you like to order?");//prompting the user to what they want to buy
		String input = keyboard.nextLine();//inputing what the user inputed
		String file = "Inventory.txt";//the inventory file
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));// the reader
			
			String[] tempArray; //the array that where I split each line
			String line;
			//int linecounter = 0;//for debugging cause this was annoying
			boolean foundItem = false;
			
			while(foundItem == false)//to force the user to input something in stock
			{
				foundItem = false;
				while((line = br.readLine()) != null) //this stops the loop after there is no more data in the text file
				{
					tempArray = line.split(";");// makes the array
					
					//System.out.println("Debug: Line " + linecounter + " - Checking " + tempArray[1]);

					String productType = "";//initialization needed
					if (tempArray[1].toLowerCase().contains(input.toLowerCase()))//if substring is not found then it will = -1
					{
						productType = tempArray[3].toUpperCase();//sets the type = product type
						char type = tempArray[3].charAt(0);//this worked in my brain so I kept it even though it's kind of redundant
						//Sorts all the products into each type then creates an object for each one
						if (productType.equals("R"))
						{
						return productsR[searchTracker] = new ProductR(tempArray[1], Double.parseDouble(tempArray[2]), type);
						
						}
						else if (productType.equals("B"))
						{
						return productsB[searchTracker] = new ProductB(tempArray[1], Double.parseDouble(tempArray[2]), type);
						}
						else if (productType.equals("S"))
						{
						return productsS[searchTracker] = new ProductS(tempArray[1], Double.parseDouble(tempArray[2]), type);
						} 
						/*
						 * The searchTracker doesn't update until the last line so if more than one thing match the last one in the 
						 * last index in the inventory is the one put into the array making it so that the user doesn't order two
						 * things when they input something, a quirk of this is that then the user enters a empty string which is 
						 * present in all lines of the text file the last line is inputed into the array
						 */
						foundItem = true;//ensures the loop doesn't become infinite
					}
					//linecounter++;//debug var
				}
				
				if (foundItem == false)// look to comments at top regarding this
				{
					System.out.println("Sorry we do not have anything with that name in stock please type something "
							 + "we do have in stock.");
					input = keyboard.nextLine();//redo input
				}
				
			}
		} catch (IOException e) {//this is needed or an error was given
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;//needed so the method doesn't yell at me.
	}
	
	
	/**
	 * This just writes the toString() of order class for each object to the output file
	 * 
	 */
	public static void WriteOrderToFile()//writes what the review order looks like to a text file
	{
		String outfile = "orders.txt";//what file we are writing to 
		
		temp=searchTracker;
		try {
			PrintWriter br = new PrintWriter(new FileWriter(outfile));// creating a buffered writer
			
			for (int i = 0; i < listOfOrders.length; i++) {//loops for however many objects are in listOfOrders
			    Order order = listOfOrders[i];//order = whatever index i is from listOfOrders
			    if (order != null) {//so it doesn't write the empty indexes
			    	searchTracker=i;
			        br.println(order.toString());//writing the toString to the file
			        
			        
			    }
			}
			br.close();
			searchTracker=temp;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Thingiohefio");
		}
		
	}
	
	
	/*
	 * I was going to make is so that the program wouldn't crash when you inputed a non-integer value for date, but time crunch
	 * 
	 * public static int checkDate(String str)
	{
		Scanner keyboard = new Scanner(System.in);
		int number = 0;
		boolean validInput = false;
		
		while (validInput == false)
		{
			 try 
			 {
				 number = Integer.parseInt(str);
	             validInput = true; // Exit the loop if parsing is successful
	         } 
			 catch (NumberFormatException e){}
			 
			 if (validInput == false)
			 {
				 System.out.println("Invalid input. Please enter a valid integer.");
				 number = CheckIfInt();
			 }
			 
		}
		return number;
	}*/
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean exit = false;//repeat variable
		
		while (exit == false)//loop
		{
			menu();//prints menu
			String input = checkInput();//gets an input that is valid
			
			if (input.equals("i") || input.equals("I"))//shows inventory
			{
				showInventory();
			}
			else if (input.equals("o") || input.equals("O"))//orders a item from the inventory
			{
				Product p = SearchNames();
				System.out.println("Enter quantity:");
				int quantity = positiveChecker();
				
				/*listOfOrders[searchTracker] = new Order(p, quantity, inputDate());
				searchTracker++;*/
				
				Date orderDate = inputDate();
				
				if (orderDate != null) {
				    listOfOrders[searchTracker] = new Order(p, quantity, orderDate);
				    searchTracker++;
				} else {
				    System.out.println("Error creating order. Date is null.");
				}
			}
			else if (input.equals("r") || input.equals("R"))//prints all items ordered
			{
				/*
				 * I had an error that I could not figure out so I spent about 40 minutes with the TA's assistant
				 * in my lab section and they said that this would work even though it isn't a great solution
				 * I had an error where the date at of an order at index searchTrackerwas listed as null for 
				 * productS orders all other's worked, so the TA change the code to this, I don't fully understand 
				 * how it works but what I gather is that listOfOrders is incremented by 1 higher than it should be 
				 * when trying to print it so the TA's assistant made searchTracker=i and then reset it so that while
				 * in the loop it would be at the correct index.
				 */
				temp=searchTracker;//needed for bugfix
				for (int i = 0; i < listOfOrders.length; i++) {
				    Order order = listOfOrders[i];
				    if (order != null) {//so that the empty index's aren't printed
				    	searchTracker=i;
				        System.out.println(order.toString());
				    }
				}
				searchTracker=temp;
			}
			else if (input.equals("e") || input.equals("E"))//writes to the output file then terminates the program
			{
				WriteOrderToFile();//writes to the file
				System.out.println("Thank you for your vist, your order has been saved:)");
				exit = true;//ends the loop which ends the program
			}
			else 
			{
				System.out.println("Error code #0001");//to ensure that it doesn't break
			}
		}
	}
}
