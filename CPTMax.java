import arc.*;

public class CPTMax{
	public static void main(String[] args){
		Console con = new Console();
		con.println("Hello World");
		
		String strWord;
		
		con.println("Give me a word");
		strWord = con.readLine();
		
		if(strWord.length() > 0){
			con.println("Nice!");
		}
	}
}
