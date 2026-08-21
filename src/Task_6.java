import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;
import swiftbot.SwiftBotAPI;
import swiftbot.SwiftBotAPI.ImageSize;

	public class Task_6  {
		static SwiftBotAPI API = new SwiftBotAPI();
		static BotMoveAndLight bot = new BotMoveAndLight();
		public static void CaptureImage() {
			try {
				API.takeStill("/home/pi/Pictures", "Image", ImageSize.SQUARE_720x720);
				} catch (IOException | FailedToRunRaspistillException | InterruptedException e) {
				e.printStackTrace();
				}
			
		}

		public static void RandomMovement() {
			// Generating a random number
			Random generateRandom = new Random(); 
			int upperbound = 2; // Setting the number to only have either 0 or 1
			int randomise = generateRandom.nextInt(upperbound); // randomising 
			// Choosing the direction based on the random value
			if (randomise == 1) { 
				PrintingTerminal.wait(500);
				bot.MoveLeft();
				RecordLeftDistance();
			}
			else {
				PrintingTerminal.wait(500);
				bot.MoveRight();
				RecordRightDistance();
			}
			
		}
		public static void RecordLeftDistance() {
			PrintingTerminal.LeftD = 15.2 * 0.5; 
			PrintingTerminal.MovementOfBot.add("Left:" + PrintingTerminal.LeftD );
			PrintingTerminal.TotalDistance = PrintingTerminal.TotalDistance + PrintingTerminal.LeftD;
		}
		public static void RecordRightDistance() {
			PrintingTerminal.RightD = 11.4 * 0.5; 
			PrintingTerminal.MovementOfBot.add("Right:" + PrintingTerminal.RightD );
			PrintingTerminal.TotalDistance = PrintingTerminal.TotalDistance + PrintingTerminal.RightD;
		}
		public static void RecordCentreDistance() {
			PrintingTerminal.CentD = 19 * 0.5; 
			PrintingTerminal.MovementOfBot.add("Center:" + PrintingTerminal.CentD );
			PrintingTerminal.TotalDistance = PrintingTerminal.TotalDistance + PrintingTerminal.CentD;
		}
		public static void FindHighestLight() {
			try {
				// Finding the image
				BufferedImage image = ImageIO.read(new File("/home/pi/Pictures/Image.png")); 
				// Getting the width and height of the image
				int width = image.getWidth(); 
				int height = image.getHeight(); 
				
				// Creates an array to store each section of image
				BufferedImage[] parts = new BufferedImage[3]; 
				
				// Splitting the image into 3 equal sections
				parts[0] = image.getSubimage(0,0, width/3, height); //Left Of Image
				parts[1] = image.getSubimage(width/3, 0, width/3, height); // Centre Of Image
				parts[2] = image.getSubimage(2*width/3, 0, width/3, height); // Right Of Image
				
				// getting the width and height of each section of the image
				int leftwidth = parts[0].getWidth(); 
				int leftheight = parts[0].getHeight();
				
				int centwidth = parts[1].getWidth();
				int centheight = parts[1].getHeight();
				
				int rightwidth = parts[2].getWidth();
				int rightheight = parts[2].getHeight();
				
				int Lr = 0;
				int Lg = 0;
				int Lb = 0;
				int Lcount = 0;
				double leftAI = 0;
				double Lintensity = 0;
				
				// Goes through each pixel on both row and column for the left side of the picture
				for(int i=0;i<leftwidth;i++) { 
					for(int s=0;s<leftheight;s++) { 
						// sets LC to get the R G B values
						Color Lc = new Color(parts[0].getRGB(i, s)); 
						// Records the RED GREEN BLUE RGB value of the pixel
						Lr = Lc.getRed(); 
						Lg = Lc.getGreen(); 
						Lb = Lc.getBlue(); 
						// Calculates the intensity value of the pixel
						Lintensity = 0.299*Lr + 0.587*Lg + 0.114*Lb; 
						// Records the total intensity value of the left side of the image
						leftAI += Lintensity;
						// Finds out how many pixels there is
						Lcount++;
					}
				}
				// Gets an average intensity value of the left side of the image
				leftAI = leftAI/Lcount; 
				
				int Cr = 0;
				int Cg = 0;
				int Cb = 0;
				int Ccount = 0;
				double centAI = 0;
				double Cintensity = 0;
				
				// Goes through each pixel on both row and column for the centre side of the picture
				for(int i=0;i<centwidth;i++) {
					for(int s=0;s<centheight;s++) {
						// sets CC to get the R G B values
						Color Cc = new Color(parts[1].getRGB(i, s));
						// Records the RED GREEN BLUE RGB value of the pixel
						Cr = Cc.getRed();
						Cg = Cc.getGreen();
						Cb = Cc.getBlue();
						// Calculates the intensity value of the pixel
						Cintensity = 0.299*Cr + 0.587*Cg + 0.114*Cb;
						// Records the total intensity value of the centre side of the image
						centAI += Cintensity;
						// Finds out how many pixels there is
						Ccount++;
					}
				}
				// Gets an average intensity value of the centre side of the image
				centAI = centAI/Ccount;
				
				int Rr = 0;
				int Rg = 0;
				int Rb = 0;
				int Rcount = 0;
				double rightAI = 0;
				double Rintensity = 0;
				
				// Goes through each pixel on both row and column for the centre side of the picture
				for(int i=0;i<rightwidth;i++) {
					for(int s=0;s<rightheight;s++) {
						// sets RC to get the R G B values
						Color Rc = new Color(parts[2].getRGB(i, s));
						// Records the RED GREEN BLUE RGB value of the pixel
						Rr = Rc.getRed();
						Rg = Rc.getGreen();
						Rb = Rc.getBlue();
						// Calculates the intensity value of the pixel
						Rintensity = 0.299*Rr + 0.587*Rg + 0.114*Rb;
						// Records the total intensity value of the right side of the image
						rightAI += Rintensity;
						// Finds out how many pixels there is
						Rcount++;
					}
				}
				// Gets an average intensity value of the right side of the image
				rightAI = rightAI/Rcount;
				
				System.out.println("-----------------");
				System.out.println(leftAI + " " + "Left Avg Light Intensity Value");
				System.out.println(rightAI + " " + "Right Avg Light Intenisty Value");
				System.out.println(centAI + " " + "Centre Avg Light Intensity Value");
				PrintingTerminal.wait(500);
				

				
				
				// Compares The intensity value of each direction and sets the swiftbot to move in the direction that has the highest intensity
				if (leftAI > rightAI && leftAI > centAI && leftAI > 1) {  
					PrintingTerminal.PrintLightFound();
					bot.SetRedUnderlight();
					PrintingTerminal.wait(1000);
					bot.MoveLeft();
					PrintingTerminal.NTimesDetect++;
					PrintingTerminal.Duration = PrintingTerminal.Duration + 0.5;
					//Records the distance of the swiftbot in which direction it moves in and gets the total distance of the bot as well
					RecordLeftDistance();
					System.out.println("Moved To Left");
				}
				// Checks if the direction with the highest AI value direction is less than or equal to 1
				if (leftAI > rightAI && leftAI > centAI && leftAI <= 1) {
					// Moves in random direction, either right or left
					PrintingTerminal.PrintLightNotFound();
					bot.SetPurpleUnderlight();
					PrintingTerminal.wait(300);
					RandomMovement();
					PrintingTerminal.Duration = PrintingTerminal.Duration + 0.5;	
				}

				// Compares the stored highest AI direction value with the current one
				if (leftAI > PrintingTerminal.Leftint) { 
					// Replaces the stored value with the current one 
					PrintingTerminal.Leftint = leftAI; 
				}
				
				
				// Compares The intensity value of each direction and sets the swiftbot to move in the direction that has the highest intensity
				if (leftAI < rightAI && rightAI > centAI && rightAI > 1) {
					PrintingTerminal.PrintLightFound();
					bot.SetRedUnderlight();
					PrintingTerminal.wait(1000);
					bot.MoveRight();
					PrintingTerminal.NTimesDetect++;
					PrintingTerminal.Duration = PrintingTerminal.Duration + 0.5;
					//Records the distance of the bot in which direction it moves in and gets the total distance of the bot as well
					RecordRightDistance();
					System.out.println("Moved To Right");
				}
				// Checks if the direction with the highest AI value direction is less than or equal to 1
				if (leftAI < rightAI && rightAI > centAI && rightAI <= 1) {
					// Moves in random direction, either right or left
					PrintingTerminal.PrintLightNotFound();
					bot.SetPurpleUnderlight(); //Purple
					PrintingTerminal.wait(300);
					RandomMovement();
					PrintingTerminal.Duration = PrintingTerminal.Duration + 0.5;	
				}
				
				// Compares the stored highest AI direction value with the current one
				if (rightAI > PrintingTerminal.Rightint) {
					// Replaces the stored value with the current one 
					PrintingTerminal.Rightint = rightAI;
				}
				
				// Compares The intensity value of each direction and sets the swiftbot to move in the direction that has the highest intensity
				if (leftAI < centAI && rightAI < centAI && centAI > 1) {
					PrintingTerminal.PrintLightFound();
					bot.SetRedUnderlight();
					PrintingTerminal.wait(1000);
					bot.MoveForward();
					PrintingTerminal.NTimesDetect++;
					PrintingTerminal.Duration = PrintingTerminal.Duration + 0.5;
					//Records the distance of the swiftbot in which direction it moves in and gets the total distance of the bot as well
					RecordCentreDistance();
					System.out.println("Moved To Centre");
				}
				// Checks if the direction with the highest AI value direction is less than or equal to 1 
				if (leftAI < centAI && rightAI < centAI && centAI <= 1 ) {
				    // Moves in random direction, either right or left	
					PrintingTerminal.PrintLightNotFound();
					bot.SetPurpleUnderlight();
					PrintingTerminal.wait(300);
					RandomMovement();
					PrintingTerminal.Duration = PrintingTerminal.Duration + 0.5;
				}

				// Compares the stored highest AI direction value with the current one
				if (centAI > PrintingTerminal.Centint) {
					// Replaces the stored value with the current one 
					PrintingTerminal.Centint = centAI;
				}
				
				// To check if the images are divided equally			
				ImageIO.write(parts[0], "png", new File("/home/pi/Pictures/1.png"));
				ImageIO.write(parts[1], "png", new File("/home/pi/Pictures/2.png"));
				ImageIO.write(parts[2], "png", new File("/home/pi/Pictures/3.png"));
			
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			

		}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			PrintingTerminal.WelcomeScreen();
			
			// Keeps searching for light if the X button has not been pressed
			while (API.BUTTON_X.isHigh()) {
				System.out.println("-----------------");
				System.out.println("The SwiftBot Is Searching For Light.");
				CaptureImage();
				PrintingTerminal.wait(200);
				FindHighestLight();
	            API.disableUnderlights();
	            PrintingTerminal.wait(500);
	            
	        // If the x button is low, will ask the user if it wants to display the log of execution
	        if (API.BUTTON_X.isLow()) {
	        	PrintingTerminal.AskLogExecution();
		
				String y = sc.next();
				if (y.equals("y") || y.equals("Y")) {
					PrintingTerminal.wait(300);
					PrintingTerminal.OutputLog();
					API.shutdown();		
				}
				else {
					PrintingTerminal.wait(500);
					PrintingTerminal.EndScreen();
					API.shutdown();
	        }
				break;
	        }
		    } 
		}
	}
