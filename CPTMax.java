import arc.*;

public class CPTMax{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		
		String strGuess;
		String strWord = "eggplant";
		int intLength;
		int intCount;
		int intGuessed = 0;
		
		
		
		intLength = strWord.length();
		int intPoints = intLength;
		System.out.println("There are "+intPoints+" remaining letters to be guessed");
		
		String strLetter[];
		strLetter = new String[intPoints];
		
		for(intCount = 1; intCount <= intLength; intCount++){
			strLetter[intCount-1] = strWord.substring(intCount-1, intCount);
		}
		
		
		for(intCount = 1; intCount <= intLength; intCount++){
			con.print("_ ");
			con.sleep(100);
		}
		
		while(intPoints != 0){
			con.println("\n\nYou have "+intPoints+" points.");
			con.println("Guess a letter");
			strGuess = con.readLine();
			
			for(intCount = 0; intCount < intLength; intCount++){
				if(strGuess.equalsIgnoreCase(strLetter[intCount])){
					con.println("You correctly guessed a letter!");
					//add an array that has all of the positions that were guessed
				}
			}
			//print out the letters that were guessed using both arrays
			//con.print("_");
			//con.print(strLetter[intCount]);
			
			
		}
	}
}		

