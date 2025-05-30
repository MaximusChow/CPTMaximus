import arc.*;

public class CPTMax{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		
		String strGuess;
		String strWord = "cat";
		int intLength;
		int intCount;
		boolean blnCorrectGuess;
		int intUnderscores;
		
		
		intLength = strWord.length();
		int intPoints = intLength;
		intUnderscores = intLength;
		System.out.println("There are "+intPoints+" remaining letters to be guessed");
		
		String strLetter[];
		strLetter = new String[intPoints];
		
		String strGuessed[];
		strGuessed = new String[intLength];
		
		for(intCount = 1; intCount <= intLength; intCount++){
			strLetter[intCount-1] = strWord.substring(intCount-1, intCount);
		}
		
		
		for(intCount = 1; intCount <= intLength; intCount++){
			con.print("_");
			con.sleep(100);
		}
		
		while(intPoints != 0){
			con.println("\nYou have "+intPoints+" points.");
			con.println("Guess a letter");
			strGuess = con.readLine();
			
			
			for(intCount = 0; intCount < intLength; intCount++){
				if(strGuess.equals(strLetter[intCount])){
					strGuessed[intCount] = strGuess;
					
					blnCorrectGuess = true;
					
				}else{
					
					
				}
			}
			
			for(intCount = 0; intCount < intLength; intCount++){
				if(strGuessed[intCount] == strLetter[intCount]){
					con.print(strGuessed[intCount]);
				}else{
					con.print("_");
				}
				
			}
			
			
			if(intUnderscores == intLength){
				con.println("\nYou guessed a correct letter!");
				intUnderscores = intUnderscores -1;
				con.println("You have "+intUnderscores+" letters left to guess.");
				
				
			}else{
				con.println("\nThat was not one of the letters.");
				con.println("You have "+intUnderscores+" letters left to guess.");
				intPoints = intPoints - 1;
				
				
			}
			
			
		}
		
		con.clear();
		con.println("You Lose!");
		con.println("Points: "+intPoints);
		
	}
}		

