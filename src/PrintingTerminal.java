import java.util.LinkedList;
import java.util.Queue;

public class PrintingTerminal extends Task_6 {
	static int NTimesDetect = 0;
	static double Duration = 0;
	static double Rightint, Leftint, Centint, RightD, LeftD, CentD, TotalDistance;
	static Queue<String> MovementOfBot = new LinkedList<>();
	
	public static void wait(int ms)

	// Using wait as a sleep method to make the terminal be friendly to the user
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
	public static void WelcomeScreen() {
		System.out.println("Welcome To The Search For Light Program! Your SwiftBot Should Be Searching For Light Soon.");
		wait(500);
		
		System.out.println("Please Press The X Button On The SwiftBot To Stop The SwiftBot From Searching Light");
		wait(500);
	}
	public static void OutputLog() {
		System.out.println("-----------------");
		System.out.println("Log : 	Overall Highest Intensity On The Left, Centre, Right Are  -" + " " + Leftint + " " + Centint + " " + Rightint);
		System.out.println("	Number Of Times Bot Detected Light -" + " " + NTimesDetect + " Times");
		System.out.println("	Movements Of The Bot - " + MovementOfBot );
		System.out.println("	Total Distance Travelled - " + TotalDistance + " " + "Cm");
		System.out.println("	Duration Of Execution -" + " " + Duration + " " + "Seconds");
		wait(700);
		System.out.println("");
		System.out.println("-----------------");
		System.out.println("Program Has Ended And The Bot Has Stopped Searching For Light");
		System.out.println("-----------------");
	}
	public static void AskLogExecution() {
		System.out.println("-----------------");
    	System.out.println("Button X Has Been Pressed");
    	System.out.println("-----------------");
		System.out.print("If The Program Should Display The Log Of Execution Then Please Press Y Or If You Do Not Then Please Press Any Character: ");
	}
	public static void EndScreen() {
		System.out.println("-----------------");
		System.out.println("Program Has Ended And The Bot Has Stopped Searching For Light");
		System.out.println("-----------------");
	}
	public static void PrintLightFound() {
		wait(300);
		System.out.println("-----------------");
		System.out.println("Light Has Been Searched And The SwiftBot Will Now Begin To Move");
	}
	public static void PrintLightNotFound() {
		wait(300);
		System.out.println("-----------------");
		System.out.println("Light Has Not Been Found, Swifbot Will Now Move In A Random Direction And Search For Light");
	}
}
