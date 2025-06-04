import arc.*;
import java.awt.Color;

public class maxtesting{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		
		int intX = 350;
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.setDrawColor(Color.WHITE);
		con.fillRect(500, intX, 200, 50);
		
		con.setDrawColor(Color.WHITE);
		con.drawString("Play Game", 550, 360);

		con.drawString("View Leaderboard", 505, 400);
		con.drawString("Add Theme", 550, 450);
		con.drawString("Quit", 575, 500);
		boolean blnReturnToMenu = true;
		int intMenuOption = 0;
		while(blnReturnToMenu){
			con.setDrawColor(Color.WHITE);
			con.fillRect(450, intX+25, 25, 7);
			while(con.currentKey() == 10){
				if(intX == 350){
					con.println("Play Game Selected");
					intMenuOption = 1;
					con.sleep(100);
				}
				if(intX == 400){
					con.println("View Leaderboard Selected");
					intMenuOption = 2;
					con.sleep(1000);
				}
				if(intX == 450){
					con.println("Add Theme Selected");
					intMenuOption = 3;
					con.sleep(1000);	
				}
				if(intX == 500){
					con.println("Quit Selected");
					intMenuOption = 4;
					con.sleep(1000);
				}
			}
			while(con.currentKey() == 38){
				
				if(intX == 350){
					System.out.println("Cannot Go up");
				}
				con.sleep(100);
				if(intX == 400 || intX == 450 || intX == 500){
					con.setDrawColor(Color.BLACK);
					con.fillRect(450, intX, 25, 7);
					intX = intX - 50;
					con.setDrawColor(Color.WHITE);
					con.fillRect(450, intX, 25, 7);
				}
			}
			while(con.getKey() == 40){
				
				if(intX == 500){
					System.out.println("Cannot Go Down");
				}
				
				if(intX == 350 || intX == 400 || intX == 450){
					con.setDrawColor(Color.BLACK);
					con.fillRect(450, intX, 25, 7);
					intX = intX + 50;
					con.setDrawColor(Color.WHITE);
					con.fillRect(450, intX, 25, 7);
				}
			}
			
			if(intMenuOption == 1){
				con.clear();
				con.println("Give me a theme");
			}
			con.repaint();
			
		}con.println("outisde");
		
		/*while(true){
			
			while(con.currentKey() == 38){
				if(intX <= 350){
					con.println("No more");
					con.sleep(100);
					if(intX == 350){
						con.setDrawColor(Color.BLACK);
						con.drawString("Play Game", 550, 360);
						con.setDrawColor(Color.WHITE);
						con.drawString("View Leaderboard", 505, 400);
						con.drawString("Add Theme", 550, 450);
						con.drawString("Quit", 575, 500);
					}
					
				}
				
				if(intX == 400){
						intX = intX - 50;
						con.setDrawColor(Color.WHITE);
						con.drawString("Play Game", 550, 360);
						con.setDrawColor(Color.BLACK);
						con.drawString("View Leaderboard", 505, 400);
						con.setDrawColor(Color.WHITE);
						con.drawString("Add Theme", 550, 450);
						con.drawString("Quit", 575, 500);
					}
			}
			while(con.getKey() == 40){
				if(intX > 450){
					con.println("No more");
					con.sleep(100);
					con.setDrawColor(Color.BLACK);
					con.setDrawColor(Color.BLACK);
					con.drawString("Play Game", 550, 360);
					con.drawString("View Leaderboard", 505, 400);
					con.drawString("Add Theme", 550, 450);
					con.drawString("Quit", 575, 500);
				}else{
					con.println("Down");
					intX = intX + 50;
					con.setDrawColor(Color.WHITE);
					con.fillRect(500, intX, 200, 50);
					con.setDrawColor(Color.BLACK);
					con.fillRect(500, intX-50, 200, 50);
					
					con.setDrawColor(Color.BLACK);
					con.drawString("Play Game", 550, 360);
					con.drawString("View Leaderboard", 505, 400);
					con.drawString("Add Theme", 550, 450);
					con.drawString("Quit", 575, 500);
				}
				
			}
			con.repaint();
		}
	
		*/
	}
}
