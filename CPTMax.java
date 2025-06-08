import arc.*;
import java.awt.Color;

public class CPTMax{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		//Before Menu
		con.setDrawColor(new Color(0, 0, 0));
		con.fillRect(0, 0, 1280, 720);
		
		con.setDrawColor(Color.BLACK);
		String strName;
		con.println("Welcome to Guess The Word. What is your name?");
		strName = con.readLine();
		System.out.println("Name: "+strName);
		con.clear();
		con.println("Hello, "+strName+"!");
		con.sleep(1500);
		con.clear();
		
		//If user finsihed a theme
		boolean blnFinishedTheme = false;
		int intFinishedTheme;
		
		//Menu
		boolean blnReturnToMenu = true;
		while(blnReturnToMenu == true){
			
			int intMenuOption = 0;
			if(blnFinishedTheme == true){
				intMenuOption = 1;
			}else{
				con.println(" GGGGG   UU   UU   EEEEE   SSSS    SSSS                       W     W   OOOOO    RRRRR   DDDD  ");
				con.println("GG   GG  UU   UU  E       SS   S  SS   S   TTTT H   H  EEEE   W     W  OO   OO  RR  RR  D   DD   ");
				con.println("G        UU   UU  EEEEEE   SS       SS      TT  H   H  E      W     W  OO   OO  R   RR  D   DD  ");
				con.println("GG GGGG  UU   UU  E          SS      SS     TT  HHHHH  EEEE   W  W  W  OO   OO  RRRRR   D   DD  ");
				con.println("GG   GG  UU   UU  E       SS  SS  SS  SS    TT  H   H  E      W W W W  OO   OO  R  R    D   DD ");
				con.println(" GGGG     UUUUU   EEEEEE   SSSS    SSSS     TT  H   H  EEEE    WW WW    OOOOO   R   RR  DDDDD \n");
				
				con.println("PLEASE ENTER A LETTER : \n(P)lay Game \n(V)iew Leaderboard \n(A)dd Theme \n(H)elp \n(Q)uit\n");
				
				if(con.getKey() == 80){
					intMenuOption = 1;
				}else if(con.currentKey() == 86){
					intMenuOption = 2;
				}else if(con.currentKey() == 65){
					intMenuOption = 3;
				}else if(con.currentKey() == 72){
					intMenuOption = 4;
				}else if(con.currentKey() == 81){
					intMenuOption = 5;
				}//secret menu
				else if(con.currentKey() == 83){
					intMenuOption = 6;
				}
				
				con.sleep(100);
				con.clear();
			
			}
			blnFinishedTheme = false;
			
			//Play game was selected
			if(intMenuOption == 1){
				con.println("Select Your Theme:");
				
			String strTheme = "";
			boolean blnResult;
			boolean blnValidTheme = true;
			while(blnValidTheme == true){
				//Open text files
				TextInputFile themes = new TextInputFile("themes.txt");
				int intNumOfThemes = 0;
				int intNumOfThemesMinusOne = 0;
				
				//find out number of themes, print themes too
				while(themes.eof() == false){
					strTheme = themes.readLine();
					con.println(strTheme);
					intNumOfThemes = intNumOfThemes + 1;
				}
				themes.close();
				
				//read selected theme
				con.println("Select your theme by typing in the theme name. Please include the '.txt' and ensure no typos.");
				strTheme = con.readLine();
				
				con.clear();
				
				con.println("You have selected the "+strTheme+" file for your theme. \nLoading file.");
				con.sleep(1500);
				
				blnResult = blnisValid(strTheme);
				if(blnResult == true){
					blnValidTheme = false;
				}else{
					con.clear();
					con.println("Invalid Theme.");
					con.sleep(1500);
					con.clear();
				}
				
			}
			TextInputFile selectedTheme = new TextInputFile(strTheme);
			String strWords;
			int intNumberOfWords = 0;
			while(selectedTheme.eof() == false){
				strWords = selectedTheme.readLine();
				intNumberOfWords = intNumberOfWords + 1;
			}
			System.out.println("There are: "+intNumberOfWords+" words in the "+strTheme+" file");
			selectedTheme.close();
			//close and reopen to have array
			selectedTheme = new TextInputFile(strTheme);
			
			//creating 2D array 
			String strFileWords[][];
			strFileWords = new String[intNumberOfWords][2];
			
			//input data into array
			int intRow;
			int intRand;
			System.out.println("Current array strFileWords[][], unsorted");
			for(intRow = 0; intRow < intNumberOfWords; intRow++){
				strFileWords[intRow][0] = selectedTheme.readLine();
				System.out.println(strFileWords[intRow][0]);
				intRand = (int)(Math.random()*100+1);
				strFileWords[intRow][1] = intRand + "";
				System.out.println(strFileWords[intRow][1]);
			}
			selectedTheme.close();
			
			System.out.println("Sorted in ascending order by random number: ");
			//Sorting array---------------------------------------------------------------------------------------------------------------------------------
			int intCount2;
			int intCount3;
			String strTempWord;
			String strTempNum;
			
			
			for(intCount2 = 0; intCount2 < intNumberOfWords-1; intCount2++){
				for(intCount3 = 0; intCount3 < intNumberOfWords-1; intCount3++){
					
					//Convert the random nums to integer and compare
					if(Integer.parseInt(strFileWords[intCount3][1]) > Integer.parseInt(strFileWords[intCount3+1][1])){
						//Swap here, swap thing then swap back
						//Swap name
						strTempWord = strFileWords[intCount3][0];
						strFileWords[intCount3][0] = strFileWords[intCount3+1][0];
						strFileWords[intCount3+1][0] = strTempWord;
						
						//Swap random numbers
						strTempNum = strFileWords[intCount3][1];
						strFileWords[intCount3][1] = strFileWords[intCount3+1][1];
						strFileWords[intCount3+1][1] = strTempNum;
						
					}
					
				}
			}
			for(intCount3 = 0; intCount3 < intNumberOfWords; intCount3++){
				System.out.println(strFileWords[intCount3][0] + "-" + strFileWords[intCount3][1]);
			}
			//-------------------------------------------------------------------------------------------------------------------------------
			
			con.sleep(1000);
			con.clear();
			con.println("Complete!");
			con.sleep(1000);
			con.clear();
			
			//Game
			
			//Animation for loading while instructions
			int intWait;
			for(intWait = 0; intWait < 2; intWait++){
				con.println("Starting game. \n\nInstructions: \nEach word will have a certain number of letters.\nYou may NOT guess more than one letter at a time. \nTry to guess the word before you run out of points!");
				con.sleep(450);
				con.clear();
				con.println("Starting game.. \n\nInstructions: \nEach word will have a certain number of letters.\nYou may NOT guess more than one letter at a time. \nTry to guess the word before you run out of points!");
				con.sleep(450);
				con.clear();
				con.println("Starting game... \n\nInstructions: \nEach word will have a certain number of letters.\nYou may NOT guess more than one letter at a time. \nTry to guess the word before you run out of points!");
				con.sleep(450);
				con.clear();
				con.println("Starting game \n\nInstructions: \nEach word will have a certain number of letters.\nYou may NOT guess more than one letter at a time. \nTry to guess the word before you run out of points!");
				con.sleep(450);
				con.clear();
			}
			con.clear();
			
			
			int intFile1 = -1;
			
			
			boolean blnRestart = true;
			
			while(blnRestart == true){
				//Declare variables 
				if(intFile1 <= intNumberOfWords-2){
					intFile1 = intFile1+1;
					System.out.println("Number of words: "+intNumberOfWords);
					System.out.println("Word you are on: "+intFile1);
				}else{
					con.println("You finished all the words in this theme! Would you like to return to: \n1. Menu\n2. Select Theme");
					intFinishedTheme = con.readInt();
					con.clear();
					if(intFinishedTheme == 2){
						blnFinishedTheme = true;
						break;
					}break;
				}
				
				String strWord = strFileWords[intFile1][0];
				String strGuess;
				int intCount;
				int intLength = strWord.length();
				int intPoints = intLength;
				
				//Cheat statitan gives 10 extra tries/points
				if(strName.equalsIgnoreCase("statitan")){
					intPoints = intPoints + 10;
				}
				
				int intWinCount = 0;
				
			
				//Create one array for the word
				String strWordArray[];
				strWordArray = new String[intLength];
				
				//Create one array for the guessed letters
				String strGuessed[];
				strGuessed = new String[intLength];
				
				//input the letters of the word into columns of an array
				for(intCount = 1; intCount <= intLength; intCount++){
					strWordArray[intCount-1] = strWord.substring(intCount-1, intCount);	
				}
				
				//Gameplay
				while(intPoints > 0){
					
					//Printing the underscores: Check if previous letters were guessed
					for(intCount = 0; intCount < intLength; intCount++){
						if(strGuessed[intCount] != null){
							System.out.println("This letter was guessed");
							con.print(strGuessed[intCount]);
						}else{
							con.print("_");
						}
					}
					
					//Ask for a guess
					con.println("\nYou have: "+intPoints+" points remaining.\nGuess a letter. ");
					strGuess = con.readLine();
					
					
					//Check if any letter matches the wordArray, then store the data in the spot
					int intWasThatGuessCorrect = 0;
					for(intCount = 0; intCount < intLength; intCount++){
						if(strGuess.equals(strWordArray[intCount])){
							System.out.print(strGuess);
							strGuessed[intCount] = strGuess;
							intWasThatGuessCorrect = 1;
						}else{
							System.out.print("_");
						}
					}
					
					//Check if that was a correct guess or not
					con.clear();
					if(intWasThatGuessCorrect == 0){
						System.out.println("That was a wrong guess.");
						con.println("WRONG! -1 point.");
						intPoints = intPoints - 1;
					}else if(intWasThatGuessCorrect == 1){
						con.println("CORRECT! Keep guessing.");
						System.out.println("That was an AWESOME guess.");
					}
					
					//Check if player won
					int intWinning = 0;
					for(intCount = 0; intCount < intLength; intCount++){
						if(strWordArray[intCount].equals(strGuessed[intCount])){
							System.out.print("g");
							intWinning += 1;
						}else{
							System.out.print("b");
						}
					}
					
					//If the amount of letters correct is equal to the word length, win
					if(intWinning == intLength){
						intWinCount = intWinning;
						break;
					}
					
				}
				//Win|| lose 
				String strAnswer = "";
				if(intWinCount == intLength){
					con.clear();
					con.println("You Win!");
					con.println("You gained: "+intPoints+" points. Added to leaderboard.");
					
					TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt", true);
					leaderboard.println(strName);
					
					leaderboard.println(intPoints);
					leaderboard.close();
					
					con.println("Play Again? Please type YES or NO.");
					strAnswer = con.readLine();
				}else if(intWinCount != intLength){
					con.clear();
					con.println("You Lose!");
					con.println("You have: "+intPoints+" points.");
					con.println("Play Again? Please type YES or NO.");
					strAnswer = con.readLine();
				}
				
				if(strAnswer.equalsIgnoreCase("yes")){
					blnRestart = true;
					con.clear();
				}else{
					blnRestart = false;
					con.clear();
					con.println("Would you like to quit the application? YES or NO");
					strAnswer = con.readLine();
					con.clear();
					if(strAnswer.equalsIgnoreCase("yes")){
						blnReturnToMenu = false;
						con.closeConsole();
					}
				}
			}
			
			}
			//Leaderboard option
			if(intMenuOption == 2){
				con.println("Leaderboard:\n");
				TextInputFile leaderboarder = new TextInputFile("leaderboard.txt");
				int intNumberOfRows = 0;
				String strReadNames;
				int intRow = 0;
				//Use null because null indicates theres nothing to read, if it is not null then keep reading
				while ((strReadNames = leaderboarder.readLine()) != null) {
					intNumberOfRows += 1;
				}
				
				leaderboarder.close();
				TextInputFile leaderboard2 = new TextInputFile("leaderboard.txt");
				System.out.println("There are "+intNumberOfRows+" rows of names on the leaderboard");
				int intNumberOfEntries = intNumberOfRows / 2;
				
				//creating 2D array 
				String strLeaderboard[][];
				strLeaderboard = new String[intNumberOfRows][2];
				
				//input data into array
				System.out.println("Current array strLeaderboard[][], unsorted");
				for(intRow = 0; intRow < intNumberOfEntries; intRow++){
					strLeaderboard[intRow][0] = leaderboard2.readLine();
					System.out.println(strLeaderboard[intRow][0]);
					strLeaderboard[intRow][1] = leaderboard2.readLine();
					System.out.println(strLeaderboard[intRow][1]);
				}
				leaderboard2.close();
				
				System.out.println("Sorted in descending order by score: ");
				//Sorting array---------------------------------------------------------------------------------------------------------------------------------
				int intCount4;
				int intCount5;
				String strTempName;
				String strTempScore;
				
				
				for(intCount4 = 0; intCount4 < intNumberOfEntries-1; intCount4++){
					for(intCount5 = 0; intCount5 < intNumberOfEntries-1; intCount5++){
						
						//Swapping
						if(Integer.parseInt(strLeaderboard[intCount5][1]) < Integer.parseInt(strLeaderboard[intCount5+1][1])){
						
							strTempName = strLeaderboard[intCount5][0];
							strLeaderboard[intCount5][0] = strLeaderboard[intCount5+1][0];
							strLeaderboard[intCount5+1][0] = strTempName;
							
							strTempScore = strLeaderboard[intCount5][1];
							strLeaderboard[intCount5][1] = strLeaderboard[intCount5+1][1];
							strLeaderboard[intCount5+1][1] = strTempScore;
							
						}
						
					}
				}
				for(intCount5 = 0; intCount5 < intNumberOfEntries; intCount5++){
					con.println(strLeaderboard[intCount5][0] + "-" + strLeaderboard[intCount5][1]);
				}
				//-------------------------------------------------------------------------------------------------------------------------------
				String strAnswer;
				con.println("\nWould you like to return to the menu? YES or NO");
				strAnswer = con.readLine();
				if(strAnswer.equalsIgnoreCase("yes")){
					con.clear();
				}else{
					con.clear();
					con.println("Would you like to quit the application?");
					strAnswer = con.readLine();
					con.clear();
					if(strAnswer.equalsIgnoreCase("yes")){
						blnReturnToMenu = false;
						con.closeConsole();
					}
				}
			}
			//Add Theme Option
			String strNewTheme;
			String strNewWord = "";
			if(intMenuOption == 3){
				con.clear();
				con.println("Add theme:\nGive me the theme name. Please enter '.txt' at the end and ensure no spaces.");
				strNewTheme = con.readLine();
				
				TextOutputFile master = new TextOutputFile("themes.txt", true);
				master.println(strNewTheme);
				master.close();
				
				TextOutputFile newUserFile = new TextOutputFile(strNewTheme);
				
				con.println("Give me words to add to the theme. Enter 'stop' to stop");
				while(!strNewWord.equalsIgnoreCase("stop")){
					con.println("Keep adding words.");
					strNewWord = con.readLine();
					if(strNewWord.equalsIgnoreCase("stop")){
						break;
					}else{
						newUserFile.println(strNewWord);
					}
				}
				con.clear();
				con.println("Finished.");
				con.sleep(1000);
				
				String strAnswer;
				con.println("\nWould you like to return to the menu? YES or NO");
				strAnswer = con.readLine();
				if(strAnswer.equalsIgnoreCase("yes")){
					con.clear();
				}else{
					con.clear();
					con.println("Would you like to quit the application?");
					strAnswer = con.readLine();
					con.clear();
					if(strAnswer.equalsIgnoreCase("yes")){
						blnReturnToMenu = false;
						con.closeConsole();
					}
				}
			}
			
			//Help Menu
			if(intMenuOption == 4){
				con.println("Help");
				con.println("Welcome to Guess The Word! \n\nUpon arriving in the menu, you are able to select from 5 options using the keys on your keyboard. \nFor example, if the menu option is (P)lay game, then you press 'p' to start. \nWhen you enter the game, you must select your theme. Ensure no typos when typing the full .txt file. \nYou will be sent to the gameplay next. \n\n(P)lay game \nWhen you are in the game, you will have as many points as letters in the secret word, \nunless you have a certain name... \nAnyways, your points will either stay the same when you guess a letter or decrease by 1 point when you \nguess a wrong letter. You may NOT enter full words; only ONE letter at a time.");
				con.println("\n(A)dd Theme \nFor the (A)dd Theme menu option, you must enter the exact file name \nfollowed by '.txt' in order to enter your desired theme. \nThen you will enter a word followed by the ENTER key to start the next entry. \nContinue for as many words as you want in the theme. \nWhen you are done, you will type 'stop' followed by pressing the ENTER key to finish.");
				con.println("\n(V)iew Leaderboard and (Q)uit are straightforward; \nit will ask if you want to return to menu or quit application. \nIf you need further help, please email maximus.chow27@ycdsbk12.ca.");
				
				
				String strAnswer;
				con.println("\nWould you like to return to the menu? YES or NO");
				strAnswer = con.readLine();
				if(strAnswer.equalsIgnoreCase("yes")){
					con.clear();
				}else{
					con.clear();
					con.println("Would you like to quit the application?");
					strAnswer = con.readLine();
					con.clear();
					if(strAnswer.equalsIgnoreCase("yes")){
						blnReturnToMenu = false;
						con.closeConsole();
					}
				}
			}
			
			//Quit Option
			String strAnswer;
			if(intMenuOption == 5){
				con.println("Are you sure you would like to quit? YES or NO");
				strAnswer = con.readLine();
				if(strAnswer.equalsIgnoreCase("yes")){
					con.closeConsole();
				}else{
					con.clear();
				}
			}
			
			//Secret Menu
			int intLaughs = 0;
			if(intMenuOption == 6){
				con.println("You discovered the secret menu! Here's your reward.");
				con.println("\n\nWhy did the Java developer quit his job?");
				con.sleep(1400);
				con.println("                                                                                                     Why?");
				con.sleep(2000);
				
				con.println("\nBecause he didn’t get arrays.");
				con.sleep(1000);
				for(intLaughs = 0; intLaughs < 50; intLaughs++){
					con.print("HA");
					con.sleep(50);
				}
				
				con.println("\n\nWould you like another joke?");
				strAnswer = con.readLine();
				if(strAnswer.equalsIgnoreCase("yes")){
					con.println("A programmer is heading out to the grocery store, so his wife tells him \n'get a gallon of milk, and if they have eggs, get a dozen.'\n He returns with 13 gallons of milk.");
					con.sleep(4000);
					for(intLaughs = 0; intLaughs < 50; intLaughs++){
					con.print("HA");
					con.sleep(50);
				}
				}else{
					con.sleep(100);
				}
				
				con.println("\n\n\nWould you like to return to the menu? YES or NO");
				strAnswer = con.readLine();
				if(strAnswer.equalsIgnoreCase("yes")){
					con.clear();
				}else{
					con.clear();
					con.println("Would you like to quit the application?");
					strAnswer = con.readLine();
					con.clear();
					if(strAnswer.equalsIgnoreCase("yes")){
						blnReturnToMenu = false;
						con.closeConsole();
					}
				}
			}
		}
	}
	
	public static boolean blnisValid(String strWord){
		boolean blnisValid = false;
		String strThemer;
		
		//open themes for reading
		TextInputFile themesValidation = new TextInputFile("themes.txt");
		while(themesValidation.eof() == false){
			strThemer = themesValidation.readLine();
			if(strWord.equalsIgnoreCase(strThemer)){
				blnisValid = true;
			}
		}
		themesValidation.close();
		
		
		return blnisValid;
		
	}

				
}


