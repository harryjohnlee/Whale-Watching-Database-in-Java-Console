import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class WhaleDatabase {

	public static void main(String[] args) {
		//this is the method identified as "main"
		
		ArrayList<String> whales = new ArrayList<String>();		
		ArrayList<String> whalesLog = new ArrayList<String>();
		ArrayList<String> qty = new ArrayList<String>();
		ArrayList<String> location = new ArrayList<String>();
		
//	    whales.add("Sperm Whale");
//	    whales.add("Orca Whale");
//	    whales.add("Blue Whale");
//	    whales.add("Gray Whale");
//	    whales.add("Narwhal");
//	    whales.add("Beluga Whale");
//	    whales.add("Bowhead Whale");
	   
		//this is adding the different types of whales to the array list to test formatting in early development, without having to add them in testing.
		
	    int listLength = whales.size() -1;
	    //This makes the list length one less because due to the indexing it will start at 0, causing a blank space when displayed it also stores the integer value as listLength,
		
		createFile(listLength,whales,whalesLog,qty,location);
		//As soon as the program is run, the method that is named CREATEFILE will run
		
		save(listLength, whales, whalesLog,qty,location);
		//this runs save as soon as the program is run
		
		home(listLength, whales, whalesLog,qty,location);
		//this runs the public static Home method as soon as the program is run
		
	
		
		
	}
	public static void home(int listLength, ArrayList<String> whales,ArrayList<String> whalesLog,ArrayList<String> qty,ArrayList<String> location ) {
		//this is the importing the variables across the different methods
		Scanner keyboardInput = new Scanner(System.in);
		//adds the keyboard scanner
		System.out.println("             Whale Watching Data");
		//prints the heading line
		System.out.println("--ADD--REMOVE--SEARCH--VIEW ALL--SAVE--CHANGE-");
		//prints the menu options for the user to choose
		String ID = keyboardInput.nextLine();
		//saying that the keyboard input by the user is made into a string known as ID
		
		
		if (ID.equalsIgnoreCase("ADD")==true) {
			add(whales,listLength,whalesLog,qty,location);

		}
		//if the keyboard user input equals specifically ADD, then run the method ADD and import the same variables as in ADD, this can either be upper or lower case
			
		
		else if (ID.equalsIgnoreCase("REMOVE")==true) {
			remove(whales,listLength, whalesLog,qty,location);
		}
		//if the keyboard user input equals specifically REMOVE, then run the method REMOVE and import the same variables as in REMOVE, this can either be upper or lower case	
		
		else if (ID.equalsIgnoreCase("SEARCH")==true) {
			search(whales,listLength, whalesLog,qty,location);
		}
		//if the keyboard user input equals specifically SEARCH, then run the method SEARCH and import the same variables as in SEARCH, this can either be upper or lower case	
			
		else if (ID.equalsIgnoreCase("VIEW ALL")==true) {
			viewAll(whales,listLength,whalesLog,qty,location);
		}
		//if the keyboard user input equals specifically VIEW ALL, then run the method VIEW ALL and import the same variables as in VIEW ALL, this can either be upper or lower case
		else if (ID.equalsIgnoreCase("SAVE")==true) {
			save(listLength, whales, whalesLog,qty,location);
		}
		//if the keyboard user input equals specifically SAVE, then run the method SAVE and import the same variables as in SAVE, this can either be upper or lower case
		else if (ID.equalsIgnoreCase("CHANGE")==true) {
			change(listLength, whales, whalesLog,qty,location);
		}
		//if the keyboard user input equals specifically CHANGE, then run the method CHANGE and import the same variables as in CHANGE, this can either be upper or lower case
		
		else {
			System.out.println("This is not a valid menu option, please try again.");
			home(listLength, whales, whalesLog,qty,location);
		}
		// if the keyboard input is anything other than the above options, print problem message and then run the method HOME and import the variables
		
			
		
	}
	public static void search(ArrayList<String> whales , int listLength, ArrayList<String> whalesLog,ArrayList<String> qty,ArrayList<String> location) {
		//this is the search method that is importing different Arraylist variables and is being called across other methods.
				Scanner keyboardInput = new Scanner(System.in);
				System.out.println("Welcome to the whale database,type a species of whale to search (eg. Sperm Whale), alternatively use RETURN to go back: ");
				String ID = keyboardInput.nextLine();
				
				for (int i = 0; i < whales.size(); i++) {
					//everything in this for loop is looping over the number of items within the arraylist Whales, using the size of the  Whales list to know when to stop iterating
				
					if (ID.equalsIgnoreCase(whales.get(i))== true) {
						// states that if the ID (which is the keyboard input) is the same as the variable gotten from the list of whales that "i" has been through, then carry out the if statement
						
						System.out.println("This is a stored whale type");
						System.out.println(String.format("%-20s %-20s %-20s %-20s%n",(i+1) , whales.get(i), qty.get(i) , location.get(i)));
						//print out the stored list of whales with the string formatting, then display its details using getters
						home(listLength, whales, whalesLog,qty,location);
						break;
					}
					else if (ID.equalsIgnoreCase("RETURN")== true) {
						home(listLength, whales, whalesLog,qty,location);
						//if return is typed then go back to the home menu 
						break;
					} 
					
					
					else if (i ==listLength) {                        
						// if i is equal to the listLength (which is the whales.size -1) then the loop knows it is not stored in the database and can 
						// show the user that it was unable to be found
						System.out.println("This is not a stored whale type");
						search(whales,listLength, whalesLog,qty,location);
						//reload the search method again
						break;
					}
				}
		
	}
	public static void add(ArrayList<String> whales, int listLength, ArrayList<String> whalesLog,ArrayList<String> qty,ArrayList<String> location) {
		//add
				java.util.Date date=new java.util.Date();
				//this creates a new variable which stores the date and time when called, the variable is labelled "date"
				
				Scanner keyboardInput = new Scanner(System.in);
				System.out.println("Type in here to add the name of your new whale discovery: ");
				String ID = keyboardInput.nextLine();
				whales.add(ID);
				//this section stores a user input as a variable called ID, this is then added to the ArrayList whales using the add method
				System.out.println("Type in here the quantity of "+ ID +" spotted in the area");
				String quantity = keyboardInput.nextLine();
				qty.add(quantity);
				//this section stores a user input as a variable called quantity, this is then added to the ArrayList qty using the add method
				System.out.println("Type in here which ocean "+ ID +" was spotted in");
				String location1 = keyboardInput.nextLine();
				location.add(location1);
				//this section stores a user input as a variable called location1, this is then added to the ArrayList location using the add method

				
				whalesLog.add("Database Addition made on " + date + " | "+ ID + " | " + quantity + " | " + location1);
				// adds all the variables created within the method to a structured list, this then adds to the whalesLog
				home(listLength, whales, whalesLog,qty,location);
				save(listLength, whales, whalesLog,qty,location);
				
				
				
		
	}
	public static void remove(ArrayList<String> whales, int listLength,ArrayList<String> whalesLog,ArrayList<String> qty,ArrayList<String> location) {
		//remove
				java.util.Date date=new java.util.Date();
				
		
				Scanner keyboardInput = new Scanner(System.in);
				System.out.println("Type in here the name of the whale you'd like to remove, OR type RETURN to go back to the menu: ");
				String delete = keyboardInput.nextLine();
				
				
				for (int i = 0; i < whales.size(); i++) {
					//iterates over the list of whales incrementing 1 at a time  until reaching the amount stored in the whales ArrayList, 
						
				if (whales.get(i).contains(delete)== true) {
					//if the delete variable matches the iteration within the whales arraylist, remove that line of data, 
					whales.remove(i);
					qty.remove(i);
					location.remove(i);
					//remove all three items of each ArrayList within the line of (i)
					whalesLog.add(delete + " was removed from the database on  " + date);
					//update the log with the date and the name of the whale species that was deleted 
					System.out.println(delete + " was removed from the database on  " + date);
					home(listLength, whales, whalesLog,qty,location);
					
					break;
					
				}
				else if (delete.equalsIgnoreCase("RETURN")== true) {
					
					home(listLength, whales, whalesLog,qty,location);
					break;
					//if return is typed, take user to home method
					
				} 
				
				
				else if (i == listLength) {
					System.out.println("This is not a stored whale type");
					remove(whales,listLength, whalesLog,qty,location);
					break;
				}
				//if user types anything other than a stored whale or return then user is told it is not a stored whale type
				
				}
				
		
	}
	public static void viewAll(ArrayList<String> whales , int listLength,ArrayList<String> whalesLog,ArrayList<String> qty,ArrayList<String> location) {
		//view all
				
				System.out.println("Database List View");
				System.out.println("------------------");
				System.out.println(String.format("%-20s %-20s %-20s %-20s%n","Unique ID", "Name of species","Quantity","Location spotted"));
				//print subheadings in string format
				
				for (int i = 0; i < whales.size(); i++) {
				
				System.out.println(String.format("%-20s %-20s %-20s %-20s%n",(i+1) , whales.get(i), qty.get(i) , location.get(i)));
					//loop over the arraylists, print out the columns in correctly formatting with the unique id
				}
				Scanner keyboardInput = new Scanner(System.in);
				System.out.println("Type RETURN to go back");
				String ID = keyboardInput.nextLine();
					//create a string called ID out of the keyboard input 
					if (ID.equalsIgnoreCase("RETURN")== true) {
						home(listLength, whales, whalesLog,qty,location);
					}
					//if return is typed, take user to home method
					else {
						System.out.println("This is not a valid option");
						System.out.println("");
						viewAll(whales,listLength, whalesLog,qty,location );
						//if anything other than return is typed then re-run the viewAll method
					}
				
			}
	public static void createFile(int listLength, ArrayList<String> whales,ArrayList<String> whalesLog,ArrayList<String> qty,ArrayList<String> location ) {
		
		PrintWriter fileData = null;
		// file is empty
		try {
			File newFile = new File ("Whale-Database.txt");
			//Creates the new file with the name Whale-Database with default path
			fileData = new PrintWriter(newFile);
			//states that the file data is being written to this specific file
			fileData.println("The International Whale Spotting Database");
			fileData.println("__________________________________________________________________________________");
			fileData.println(String.format("%-20s %-20s %-20s %-20s%n","Unique ID", "Name of species","Quantity","Location spotted"));
			for (int i = 0; i < whales.size(); i++) {
				
				fileData.println(String.format("%-20s %-20s %-20s %-20s",(i+1) , whales.get(i), qty.get(i) , location.get(i)));
			}
			//loops over all arraylists printing column by column to finally print all the results
			
			
			fileData.close(); 
			//must be used after finished writing to file
			
			
				if (newFile.createNewFile()) {
				System.out.println("The file: " + newFile.getName() + " has been created");
				//displayed if file is created correctly 
				}
			}
			
		catch (IOException e) {
			System.out.println("An error has occured");
				e.printStackTrace();
				}
		//error will not crash programme but will display a recognisable error message to user
		
		
		try {
			File newLogFile = new File ("Whale-Database-Log.txt");
			fileData = new PrintWriter(newLogFile);
			fileData.println("Whale Database Log Activity");
			fileData.println("______________________________");
			//creates the log file similar to the whales-database file
			
			for (int i = 0; i < whalesLog.size(); i++) {
				
				fileData.println (whalesLog.get(i));
				//displays all the logs saved to the arraylist whalesLog
			}
			
			
			fileData.close(); 
			
			
				if (newLogFile.createNewFile()) {
				System.out.println("The file: " + newLogFile.getName() + " has been created");
				//message tells user if the file was created ok
				}
			}
			
		catch (IOException e) {
			System.out.println("An error has occured whilst logging");
				e.printStackTrace();
				}
		//error message in case something goes wrong
			
		
		
	}
	public static void save(int listLength, ArrayList<String> whales,ArrayList<String> whalesLog,ArrayList<String> qty,ArrayList<String> location ) {
		String newFile = "Whale-Database.txt";
		PrintWriter fileData = null;
		
		try {
			fileData = new PrintWriter("Whale-Database.txt");
			//writes over the existing text file to update
			System.out.println("File has successfully been written to.");
			System.out.println("--------------------------------------");
			
			
		}catch (IOException e) {
				System.out.println("An error has occured");
					e.printStackTrace();
					//error message handling message is displayed incase of issues with file
					
					}
		
		
	
		fileData.close();
		createFile(listLength, whales, whalesLog,qty,location);
		home(listLength, whales,whalesLog,qty,location);
	}
	public static void change(int listLength, ArrayList<String> whales,ArrayList<String> whalesLog,ArrayList<String> qty,ArrayList<String> location ) {
		java.util.Date date=new java.util.Date();	
		Scanner keyboardInput = new Scanner(System.in);
		System.out.println("Type in here the name of the whale you'd like to change the quantity of, type RETURN to go back to the main menu");
		String search = keyboardInput.nextLine();
		
		
		for (int i = 0; i < whales.size(); i++) {
				
		if (whales.get(i).contains(search)== true) {
			
			System.out.println("Type the new quantity of " + whales.get(i) + "'s in the area");
			String quantityChange = keyboardInput.nextLine();
			qty.set(i, quantityChange);
			// this section of code takes a user input from the scanner and creates it into a string, this string is now the new value which will replace (i) within the .set() method
			// (i) is the same line of input that the whale name is on
			
			
			whalesLog.add(whales.get(i) + " was changed to  " + quantityChange + " on " + date);
			home(listLength, whales, whalesLog,qty,location);
			
		}
		else if (search.equalsIgnoreCase("RETURN")== true) {
			
			home(listLength, whales, whalesLog,qty,location);
			//if return is typed, take user to home method	
			
		} 
		
		
		else if (i ==listLength) {
			System.out.println("This is not a stored whale type");
			change(listLength, whales, whalesLog,qty,location);
		}
		
		}
		
		
	}
		
	
	
}

