import arc.*;
import java.awt.Color;

public class maxtesting{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		
		int intX = 350;
		con.setDrawColor(Color.RED);
		con.fillRect(0, 0, 1280, 720);
		con.setDrawColor(Color.WHITE);
		con.fillRect(500, intX, 200, 50);
		con.setDrawColor(Color.BLACK);
		con.drawString("Play Game", 550, 350);
		while(12>2){
			
			while(con.currentKey() == 38){
				if(intX <= 350){
					con.println("No more");
					con.sleep(100);
					con.setDrawColor(Color.BLACK);
					con.drawString("Play Game", 550, 350);
				}else{
					con.println("Up");
					intX = intX - 50;
					con.setDrawColor(Color.WHITE);
					con.fillRect(500, intX, 200, 50);
					con.setDrawColor(Color.BLACK);
					con.fillRect(500, intX+50, 200, 50);
					con.sleep(100);
					con.setDrawColor(Color.BLACK);
					con.drawString("Play Game", 550, 350);
				}
			}
			while(con.getKey() == 40){
				if(intX > 450){
					con.println("No more");
					con.sleep(100);
					con.setDrawColor(Color.BLACK);
					con.drawString("Play Game", 550, 350);
				}else{
					con.println("Down");
					intX = intX + 50;
					con.setDrawColor(Color.WHITE);
					con.fillRect(500, intX, 200, 50);
					con.setDrawColor(Color.BLACK);
					con.fillRect(500, intX-50, 200, 50);
					con.setDrawColor(Color.BLACK);
					con.drawString("Play Game", 550, 350);
				}
			}
			con.repaint();
			//con.setDrawColor(Color.BLACK);
			//con.drawString("Play Game", 550, 350);
		}
	}
}
