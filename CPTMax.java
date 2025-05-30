import arc.*;

public class CPTMax{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		
		String strGuess;
		String strWord = "bread";
		int intLength;
		int intCount;
		boolean blnCorrectGuess;
		
		
		
		intLength = strWord.length();
		int intPoints = intLength;
		System.out.println("There are "+intPoints+" remaining letters to be guessed");
		
		String strLetter[];
		strLetter = new String[intPoints];
		
		String strGuessed[];
		strGuessed = new String[intLength];
		
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
					strGuessed[intCount] = strGuess;
					blnCorrectGuess = true;
				}
			}
			
			if(blnCorrectGuess = false){
				con.println("Wrong guess.");
				intPoints--;
			}
			//print out the letters that were guessed using both arrays
			//con.print("_");
			//con.print(strLetter[intCount]);
			
			//for(intCount = 0; intCount < intLength; intCount++){
				if(strGuessed[0] == (strLetter[0])){
					con.print(strLetter[0]);
				}
				
			//}
			
		}
	}
}		

