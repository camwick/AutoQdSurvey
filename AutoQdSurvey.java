// packages
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import java.util.Scanner;
import java.io.File;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.Toolkit;

// errors
import java.io.FileNotFoundException;
import java.awt.AWTException; 

public class AutoQdSurvey{
	public static void main(String[] args){
		try{
			File file = new File("SurveyCodes.txt");
			Scanner input = new Scanner(file);

			// variables for use in while loop
			String codeString;
			StringSelection code;
			Clipboard clipboard;
			clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			int counter = 0;

			//runs main survey script
			while(input.hasNext()){
				// initializses the above declared variables
				codeString = input.nextLine();
				code = new StringSelection(codeString);
				clipboard.setContents(code, code);

				// runs main script and prints info
				counter++;
				System.out.printf("Code #: %d %nStarting Code: %s%n", counter, codeString);
				survey();
				System.out.printf("Finished Code #: %d%n%n", counter);
			}

			System.out.printf("Script Finished Inputting %d Codes", counter);

			input.close();
		}
		catch(Exception e){
			System.out.println("main Error: " + e);
		}
	}

	public static void survey(){
		// y offset 103 for chrome
		int yOffSet = 103;
		int ms = 1500;

		click(955,590+yOffSet);
		robotSleep(ms);
		paste();
		click(1485,605+yOffSet);
		robotSleep(ms);
		click(813,250+yOffSet);
		click(990,300+yOffSet);
		robotSleep(ms);
		click(813,250+yOffSet);
		click(980,480+yOffSet);
		robotSleep(ms);
		click(813,205+yOffSet);
		click(980,350+yOffSet);
		robotSleep(ms);
		click(813,388+yOffSet);
		click(980,440+yOffSet);
		robotSleep(ms);
		for(int i = 0; i <= 300; i += 50)
			click(1695,235+yOffSet+i);
		click(985,595+yOffSet);
		robotSleep(ms);
		for(int i = 0; i <= 200; i += 50){
			click(1598,235+yOffSet+i);
		}
		click(980,490+yOffSet);
		robotSleep(ms);
		click(814,205+yOffSet);
		click(980,440+yOffSet);
		robotSleep(ms);
		click(814,205+yOffSet);
		click(980,300+yOffSet);
		robotSleep(ms);
		click(814,225+yOffSet);
		click(980,415+yOffSet);
		robotSleep(ms);
		click(814,250+yOffSet);
		click(980,300+yOffSet);
		robotSleep(ms);
		click(980,345+yOffSet);
		robotSleep(ms);
		click(814,205+yOffSet);
		click(980,300+yOffSet);
		robotSleep(ms);
		click(180,52);
		type(KeyEvent.VK_Q);
		type(KeyEvent.VK_ENTER);
		robotSleep(ms);
	}

	public static void robotSleep(int ms){
		try{
			Thread.sleep(ms);
			}
		catch(Exception e){
			System.out.println("RobotSleep Error: " + e);
		}
	}

	public static void click(int x, int y){
		try{
			// Start Robot
			Robot mouse = new Robot();

			// click
			mouse.mouseMove(x,y);
			robotSleep(100);
			mouse.mousePress(InputEvent.BUTTON1_MASK);		
			mouse.mouseRelease(InputEvent.BUTTON1_MASK);
		}
		catch(Exception e){
			System.out.println("Click Error: " + e);
		}
	}

	public static void paste(){
		try{
			Robot keyboard = new Robot();
			keyboard.keyPress(KeyEvent.VK_CONTROL);
			keyboard.keyPress(KeyEvent.VK_V);
			keyboard.keyRelease(KeyEvent.VK_CONTROL);
			keyboard.keyRelease(KeyEvent.VK_V);
		}
		catch(Exception e){
			System.out.println("Paste Error: " + e);
		}
	}

	public static void type(int key){
		try{
			Robot keyboard = new Robot();
			keyboard.keyPress(key);
			keyboard.keyRelease(key);
		}
		catch(Exception e){
			System.out.println("Type Error: " + e);
		}
	}
}