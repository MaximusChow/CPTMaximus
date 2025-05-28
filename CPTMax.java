import arc.*;

public class CPTMax{
	public static void main(String[] args){
		Console con = new Console();
		
		char chrLetter;
		String strWord = "eggplant";
		int intLength;
		int intCount;
		
		intLength = strWord.length();
		
		for(intCount = 1; intCount <= intLength; intCount++){
			con.print("_ ");
		}
		
		con.println("\n\nYou have "+intLength+" points.");
		con.println("Guess a letter");
		chrLetter = con.readChar();
		
		for(intCount = 0; intCount <= intLength-1; intCount++){
			if(chrLetter != strWord.charAt(intCount)){
				con.print("_ ");
			}
			if(chrLetter == strWord.charAt(intCount)){
				con.print(chrLetter + " ");
			}
		}
	}
}
