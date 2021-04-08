/*
Name: Raul J. Rivera Ortiz
Course: CSC 122 001
Project #4
Project description:
		This program is an update of program 3, the difference is that the game asks for the player's name and 
		then creates a new file that contains the record of all the player's movements and results in their games. 
		In addition, the game has bug support and informs the user if the name of the new created file already exists. 
		It also creates arrays for the movements and a last array where it attaches the values of the results.
Purpose:
	1. Become familiar manipulating a file.
	2. Become familiar with exceptions in the code to throw a failure.
	3. Become familiar with arrays.
	4. Entertain the user.
	
What the update of the program does?:

	The program ask for the name of the player.
	Save the name of the player in the variable 'name'.
	Convert the username to a text document and assign it to another variable.
	
	Create a new instance in memory of the File class.
		If the File is new, will be created.
		Else print File Already exist.
		
	Provides method to write string directly to the file.
	Implements all of the print methods found in PrintStream .
	
	Creating of the arrays for the moves of the player. 
	Print the number of games in the new file.
	Print the number of wins in the new file.
	Print the number of losses in the new file.
	Print the number of ties in the new file.
	
	Create a record array.
	Print the array in the new file.
	
	And the final message:
		Thanks for playing Rock, Paper, Scissors!
		
How you tested the program:
	First, I wrote my code on a Notepad++.
	Then, I save the file in a folder that I made and call it Java-projects.
	Then, I opened the Command Prompt and moved it to the same Path with the command: cd
	Then I compiled the file with the command: javac GameRecord.java and
	a new file was created with the same name but with the class extension.
	Then I ran the program with the command: java GameRecord 
	Then I check the new file created from my game called, Raul.txt.
	Then I open the new file in the directory Java-Proyects to check the records of the player.
		
Limitations if any in the program:
	If my move is diferent of rock, paper or scissors the game ask for the valid move but
	the invalid move is saved into my array.
*/

import java.util.Scanner; //Import the Scanner class.
import java.io.File; // Import class for manipulate a file.
import java.io.FileWriter; //For writing streams of characters.
import java.io.IOException; //Is an exception in the code to throw a failure in Input & Output operations. 
import java.io.PrintWriter; //Enables to write formatted data to an underlying Writer.
import java.util.Arrays; //Contains several static methods to compare, sort, and search in arrays. 

public class GameRecord { //Open class GameRopasc.
  public static void main(String[] args) throws IOException { //Start main method.  
		
		Scanner in = new Scanner(System.in); //Initialize the Scanner.
		System.out.println("\nWelcome to Rock, Paper, Scissors!\n"); //Print a welcome message.
		
		System.out.print("Please enter your name for save your games record: "); //Ask the name of the player.
		String name = in.nextLine(); //Save the name of the player in the variable 'name'.
		String filename = name+".txt"; // Convert the username to a text document and assign it to another variable.
		
		File f = new File(filename); //Will create a new instance in memory of the File class.
		
		if (f.createNewFile()) { // If the File is new, will be created.
			System.out.println("File created: "+f.getName()); // Print File created...
		}
		else System.out.println("File Already exist"); // Else print File Already exist.
		System.out.println("Absolute Path: "+ f.getAbsolutePath()); //Print the path of the file
		System.out.println(); //Print a space between lines.
		
		FileWriter myWriter = new FileWriter(f); //Provides method to write string directly to the file.
		
		int count = 0; //Create a count variable to show the numbers of games.
		int wins = 0; //Create a wins variable to show the number of wins.
		int losses = 0; //Create a losses variable to show the number of losses.
		int ties = 0; //Create a ties variable to show the number of ties.	
		
		PrintWriter printRecord = new PrintWriter(myWriter); //This class implements all of the print methods found in PrintStream .
		printRecord.println("Hello "+ name + ", this is the Record of your Games:"); //Print a message in the new file.
		printRecord.println(); //Print a space between lines into the new file.
		
		while(true) { //Use a while(true) loop and only break the loop if the user wants to quit.	
		
			System.out.print("What is your move? To make a move, enter rock, paper, or scissors. \nTo quit the game, enter quit. "); //Print a question for start the game.
			String myMove = in.nextLine(); //Create a String variable myMove and get the user's move through user input.						
				
			if(myMove.equals("quit")) { //Check if the user wants to quit the game.
				break; //Finish thw while loop.
			} //Close if statement.
		
			if(!myMove.equals("rock") && !myMove.equals("paper") && !myMove.equals("scissors")) { //Check if the user's move is valid (rock, paper, or scissors).
				System.out.println("\nYour move isn't valid!"); //Print your move isn't valid!
			} else { //Else.
				
				int rand = (int)(Math.random()*3); //Get a random number in between 0 and 3 and convert it to an integer so that the possibilities are 0, 1, or 2.							
				String opponentMove = ""; //Convert the random number to a string using conditionals and print the opponent's move.
				
				if(rand == 0) { //Check if rand is equal to 0.
					opponentMove = "rock"; //Assign variable opponentMove to the string rock.
				} else if(rand == 1) { //Else if check rand is equal to 1.
					opponentMove = "paper"; //Assign variable opponentMove to the string paper.
				} else { //Else.
					opponentMove = "scissors"; //Assign variable opponentMove to the string scissors.
				} //Close else statement.
				System.out.println("Opponent move: " + opponentMove); //Print Opponent move.
					
				//Print the results of the game: tie, lose, win
				if(myMove.equals(opponentMove)) { //Check if myMove is equal to the opponentMove.
					System.out.println("\nIt's a tie!"); //Print It's a tie!
					ties++; //Increments the value of the variable ties by one.
					count++; //Increments the value of the variable count by one.
				} else if((myMove.equals("rock") && opponentMove.equals("scissors")) || (myMove.equals("scissors") && opponentMove.equals("paper")) || (myMove.equals("paper") && opponentMove.equals("rock"))) {
				//Else check if myMove is rock and the opponentMove is scissors or myMove is scissors and the opponentMove is paper or myMove is paper and the opponentMove is rock.
					System.out.println("\nYou won!"); //Print you won!
					wins++; //Increments the value of the variable wins by one.
					count++; //Increments the value of the variable count by one.
				} else { //Else.
					System.out.println("\nYou lost!"); //Print you lost!
					losses++; //Increments the value of the variable losses by one.
					count++; //Increments the value of the variable count by one.
				} //Close else statement.
			} //Close else statemnt.
			
			
			System.out.println("You play "+count+" games!"); //Print the number of games.
			System.out.println("You have won "+wins+" games!"); //Print the number of wins.
			System.out.println("You have lost "+losses+" games!"); //Print the number of losses.
			System.out.println("You have tie "+ties+" games!\n"); //Print the number of ties.
									
			String myArray[] = new String[1]; //Creating of my array.								
			myArray[0] = myMove; //Asign the move of the player into the array.
			
			System.out.println(Arrays.toString(myArray)); //Print the move of the player into the array.
						
			printRecord.println("Your move was:"); // Print Your move was.. in the new file.
			printRecord.println(Arrays.toString(myArray)); //Print the move of the player into the array in the new file.
			printRecord.println(); //Print a space between lines into the new file.
					
		} //Close while loop.
				
		printRecord.println("You play "+count+" games!"); //Print the number of games in the new file.
		printRecord.println("You have won "+wins+" games!"); //Print the number of wins in the new file.
		printRecord.println("You have lost "+losses+" games!"); //Print the number of losses in the new file.
		printRecord.println("You have tie "+ties+" games!\n"); //Print the number of ties in the new file.
		
		if(wins > losses) { //Check if the user won more games than lost games.
			System.out.println("\nYou won more games than you lost!"); //Print You won more games than you lost!
			printRecord.println("You won more games than you lost!");
		} else if(wins < losses) { //Else Check if the user won less games than lost games.
			System.out.println("\nYou lost more games than you won!"); //Print You lost more games than you won!
			printRecord.println("You lost more games than you won!");
		} else { //Else.
			System.out.println("\nYou won and lost an equal number of games!"); //Print You won and lost an equal number of games!
			printRecord.println("You won and lost an equal number of games!");
		} //Close else statement.
				
		printRecord.println("\nThe record of your games into an Array is:\n"); //Print a message in the new file.

		int[] record = {count, wins, losses, ties}; // Create a record array.
		
		for (int i=0; i<record.length; i++) { // Loop for show the values into the array.
			printRecord.print(record[i]+" "); //Print the array in the new file.
		}	
								
		printRecord.close(); //Close printRecord.
		System.out.println("Thanks for playing Rock, Paper, Scissors!"); //Print a final message for the user
		
  } //Close method main.
} //Close class GameRopasc.

/*

Microsoft Windows [Version 10.0.19041.867]
(c) 2020 Microsoft Corporation. All rights reserved.

C:\Users\Owner>cd C:\Users\Owner\Java-projects

C:\Users\Owner\Java-projects>javac GameRecord.java

C:\Users\Owner\Java-projects>java GameRecord

Welcome to Rock, Paper, Scissors!

Please enter your name for save your games record: Raul
File created: Raul.txt
Absolute Path: C:\Users\Owner\Java-projects\Raul.txt

What is your move? To make a move, enter rock, paper, or scissors.
To quit the game, enter quit. rock
Opponent move: rock

It's a tie!
You play 1 games!
You have won 0 games!
You have lost 0 games!
You have tie 1 games!

[rock]
What is your move? To make a move, enter rock, paper, or scissors.
To quit the game, enter quit. paper
Opponent move: rock

You won!
You play 2 games!
You have won 1 games!
You have lost 0 games!
You have tie 1 games!

[paper]
What is your move? To make a move, enter rock, paper, or scissors.
To quit the game, enter quit. scissors
Opponent move: scissors

It's a tie!
You play 3 games!
You have won 1 games!
You have lost 0 games!
You have tie 2 games!

[scissors]
What is your move? To make a move, enter rock, paper, or scissors.
To quit the game, enter quit. paper
Opponent move: rock

You won!
You play 4 games!
You have won 2 games!
You have lost 0 games!
You have tie 2 games!

[paper]
What is your move? To make a move, enter rock, paper, or scissors.
To quit the game, enter quit. rock\

Your move isn't valid!
You play 4 games!
You have won 2 games!
You have lost 0 games!
You have tie 2 games!

[rock\]
What is your move? To make a move, enter rock, paper, or scissors.
To quit the game, enter quit. rock
Opponent move: rock

It's a tie!
You play 5 games!
You have won 2 games!
You have lost 0 games!
You have tie 3 games!

[rock]
What is your move? To make a move, enter rock, paper, or scissors.
To quit the game, enter quit. paper
Opponent move: rock

You won!
You play 6 games!
You have won 3 games!
You have lost 0 games!
You have tie 3 games!

[paper]
What is your move? To make a move, enter rock, paper, or scissors.
To quit the game, enter quit. quit

You won more games than you lost!
Thanks for playing Rock, Paper, Scissors!

C:\Users\Owner\Java-projects>dir
 Volume in drive C has no label.
 Volume Serial Number is 9242-0A43

 Directory of C:\Users\Owner\Java-projects

03/15/2021  12:39 AM    <DIR>          .
03/15/2021  12:39 AM    <DIR>          ..
02/04/2021  01:02 AM             1,279 Diamond.class
02/04/2021  01:06 AM            11,880 Diamond.java
03/15/2021  12:38 AM             3,742 GameRecord.class     (java compile)
03/15/2021  12:36 AM            10,044 GameRecord.java      (java file)
03/06/2021  12:45 AM             2,405 GameRopasc.class    
02/16/2021  05:49 PM             1,984 GameRps.class
02/16/2021  01:45 AM             3,735 GameRps.java
01/20/2021  11:17 PM               417 Hello.class
08/16/2019  10:35 AM               119 Hello.java
01/22/2021  07:20 PM               573 HelloWorld.class
01/22/2021  07:18 PM             3,692 HelloWorld.java
03/10/2021  12:39 PM               686 MyName.class
03/10/2021  12:39 PM               483 MyName.java
02/15/2021  03:09 PM             1,032 RandomNum.class
02/15/2021  03:08 PM               779 RandomNum.java
03/15/2021  12:40 AM               418 Raul.txt             (new file created by the game)
03/05/2021  02:32 PM             1,917 RecordTest.class
02/24/2021  11:55 AM             1,005 RecordTest.java
01/29/2021  11:59 PM               591 Stars.class
01/29/2021  11:59 PM               274 Stars.java
              20 File(s)         47,055 bytes
               2 Dir(s)  915,842,392,064 bytes free

C:\Users\Owner\Java-projects>

*/

//Raul - Notepad

/*

Hello Raul, this is the Record of your Games:

Your move was:
[rock]

Your move was:
[paper]

Your move was:
[scissors]

Your move was:
[paper]

Your move was:
[rock\]

Your move was:
[rock]

Your move was:
[paper]

You play 6 games!
You have won 3 games!
You have lost 0 games!
You have tie 3 games!

You won more games than you lost!

The record of your games into an Array is:

6 3 0 3 

*/