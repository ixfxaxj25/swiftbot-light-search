import java.io.IOException;

public class BotMoveAndLight extends Task_6 {
	public static void MoveLeft() {
		try {
			API.move(-60,0,400);
			PrintingTerminal.wait(300);
			API.move(40, 40, 500);
			} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
			}

	
	}
	public static void MoveRight() {
		try {
			API.move(60,0,400);
			PrintingTerminal.wait(300);
			API.move(30, 30, 500);
			} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
			}

	
	}
	public static void MoveForward() {
		try {
			API.move(50, 50, 500);
			} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
			}


	}
	public static void MoveRight90() {
		try {
			API.move(60,0,600);
			PrintingTerminal.wait(300);
			API.move(30, 30, 500);
			} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
			}
		
	}
	public static void MoveLeft90() {
		try {
			API.move(-60,0,600);
			PrintingTerminal.wait(300);
			API.move(40, 40, 500);
			} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
			}
		
	}
	public static void SetRedUnderlight() {
		try {
			API.fillUnderlights(255, 0, 0);
			} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
			}


	}
	public static void SetPurpleUnderlight() {
		try {
			API.fillUnderlights(180, 60, 243);
			} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
			}


	}

}
