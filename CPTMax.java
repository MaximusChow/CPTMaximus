import arc.*;

public class CPTMax{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		
		char chrLetter;
		String strWord = "eggplant";
		int intLength;
		int intCount;
		boolean blnGuessed = false;
		
		
		char chrFirst = '!';
		char chrSecond = '!';
		char chrThird = '!';
		char chrFourth = '!';
		char chrFifth = '!';
		char chrSixth = '!';
		char chrSeventh = '!';
		char chrEighth = '!';
		
		
		
		intLength = strWord.length();
		int intRLetters = intLength;
		
		for(intCount = 1; intCount <= intLength; intCount++){
			con.print("_ ");
			con.sleep(100);
		}
		
		while(blnGuessed == false){
			con.println("\n\nYou have "+intLength+" points.");
			con.println("Guess a letter");
			chrLetter = con.readChar();
			
			for(intCount = 0; intCount <= intLength-1; intCount++){
				
				if(chrFirst != '!'){
					con.print(chrFirst);
					intRLetters = intRLetters -1;
				}
				if(chrSecond != '!'){
					con.print(chrSecond);
					intRLetters = intRLetters -1;
				}
				if(chrThird != '!'){
					con.print(chrThird);
					intRLetters = intRLetters -1;
				}
				if(chrFourth != '!'){
					con.print(chrFourth);
					intRLetters = intRLetters -1;
				}
				if(chrFifth != '!'){
					con.print(chrFifth);
					intRLetters = intRLetters -1;
				}
				if(chrSixth != '!'){
					con.print(chrSixth);
					intRLetters = intRLetters -1;
				}
				if(chrSeventh != '!'){
					con.print(chrSeventh);
					intRLetters = intRLetters -1;
				}
				if(chrEighth != '!'){
					con.print(chrEighth);
					intRLetters = intRLetters -1;
				}
				
				if(chrLetter == strWord.charAt(intCount)){
					if(intCount == 0){
						chrFirst = chrLetter;
						con.print(chrLetter + " ");
					}
					if(intCount == 1){
						chrSecond = chrLetter;
						con.print(chrSecond + " ");
					}
					if(intCount == 2){
						chrThird = chrLetter;
						con.print(chrThird + " ");
					}
					if(intCount == 3){
						chrFourth = chrLetter;
						con.print(chrFourth + " ");
					}
					if(intCount == 4){
						chrFifth = chrLetter;
						con.print(chrFifth + " ");
					}
					if(intCount == 5){
						chrSixth = chrLetter;
						con.print(chrSixth + " ");
					}
					if(intCount == 6){
						chrSeventh = chrLetter;
						con.print(chrSeventh + " ");
					}
					if(intCount == 7){
						chrEighth = chrLetter;
						con.print(chrEighth + " ");
					}
				}
			}
			
			
		}
		
		
	}
}
