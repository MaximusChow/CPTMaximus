import arc.*;

public class CPTMax{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		
		String strGuess;
		String strWord = "eggplant";
		int intLength;
		int intCount;
		boolean blnGuessed = false;
		
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
		
		while(intLength != 0){
			con.println("\n\nYou have "+intPoints+" points.");
			con.println("Guess a letter");
			strGuess = con.readLine();
			
			for(intCount = 0; intCount <= intLength-1; intCount++){
				if(strLetter[intCount].equalsIgnoreCase(strGuess)){
					con.print(strLetter[intCount]);
					blnGuessed = true;
				}else if(!strLetter[intCount].equalsIgnoreCase(strGuess)){
					con.print("_");
				}
			}
			
			
		}
	}
}		

