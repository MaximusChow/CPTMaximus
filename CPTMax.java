import arc.*;

public class CPTMax{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		
		//Declare variables
		String strWord = "dress";
		String strGuess;
		int intCount;
		int intLength = strWord.length();
		int intPoints = intLength;
		boolean blnWin = false;
		
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
			
			//Check if that was a good guess or not
			if(intWasThatGuessCorrect == 0){
				System.out.println("That was a wrong guess.");
				intPoints = intPoints - 1;
			}else if(intWasThatGuessCorrect == 1){
				System.out.println("That was an AWESOME guess.");
			}
			
			//Check if player won
			blnWin = true;
			for(intCount = 0; intCount < intLength; intCount++){
				if(strWordArray[intCount].equals(strGuessed[intCount])){
					System.out.print("g");
				}else{
					System.out.print("b");
					blnWin = false;
				}
			}
			
			
		}
		if(blnWin = true){
				con.clear();
				con.println("You win!");
		}
			con.clear();
			con.println("You Lose!");
	}
		
}
		

