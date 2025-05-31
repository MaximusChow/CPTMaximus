import arc.*;

public class CPTMax{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		//Before Menu
		String strName;
		con.println("What is your name?");
		strName = con.readLine();
		System.out.println("Name: "+strName);
		con.clear();
		con.println("Hello, "+strName+"!");
		con.sleep(1500);
		con.clear();
		
		//Menu
		int intMenuOption = 0;
		con.println("Select your option by typing in the corresponding NUMBER followed by ENTER: \n1. Play Game \n2. View Leaderboard \n3. Add Theme \n4. Quit");
		intMenuOption = con.readInt();
		con.sleep(500);
		con.clear();
		
		//Play game was selected
		if(intMenuOption == 1){
			con.println("Select Your Theme:");
		}
		
		//Open text files
		TextInputFile themes = new TextInputFile("themes.txt");
		
		String strTheme;
		while(themes.eof() == false){
			strTheme = themes.readLine();
			con.println(strTheme);
		}
		con.println("Select your theme by typing in the theme name. Please include the '.txt'.");
		strTheme = con.readLine();
		themes.close();
		con.clear();
		
		con.println("You have selected the "+strTheme+" file for your theme. \nLoading file.");
		
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
		
		con.sleep(4000);
		con.clear();
		con.println("Complete!");
		con.sleep(1000);
		con.clear();
		
		//Game
		int intWait;
		for(intWait = 0; intWait < 6; intWait++){
			con.println("Starting game. \n\nInstructions: \nEach word will have a certain number of letters.\nYou will be given the same number of points as letters in the word. \nTry to guess the word before you run out of points!");
			con.sleep(450);
			con.clear();
			con.println("Starting game.. \n\nInstructions: \nEach word will have a certain number of letters.\nYou will be given the same number of points as letters in the word. \nTry to guess the word before you run out of points!");
			con.sleep(450);
			con.clear();
			con.println("Starting game... \n\nInstructions: \nEach word will have a certain number of letters.\nYou will be given the same number of points as letters in the word. \nTry to guess the word before you run out of points!");
			con.sleep(450);
			con.clear();
			con.println("Starting game \n\nInstructions: \nEach word will have a certain number of letters.\nYou will be given the same number of points as letters in the word. \nTry to guess the word before you run out of points!");
			con.sleep(450);
			con.clear();
		}
		con.clear();
		
		//Declare variables
		int intFile1 = 0;
		String strWord = strFileWords[intFile1][0];
		String strGuess;
		int intCount;
		int intLength = strWord.length();
		int intPoints = intLength;
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
			if(intWasThatGuessCorrect == 0){
				System.out.println("That was a wrong guess.");
				intPoints = intPoints - 1;
			}else if(intWasThatGuessCorrect == 1){
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
		if(intWinCount == intLength){
			con.clear();
			con.println("You Win!");
			con.println("You have: "+intPoints+" points. Added to leaderboard.");
			con.println("Play Again? Please type YES or NO.");
		}else if(intWinCount != intLength){
			con.clear();
			con.println("You Lose!");
			con.println("You have: "+intPoints+" points left.");
			con.println("Play Again? Please type YES or NO.");
		}
	}
		
}
		

