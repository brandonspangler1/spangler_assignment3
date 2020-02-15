import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	
	private static final int EXCLUSIVEBOUND = 10;
	
	static Scanner kb = new Scanner(System.in);
	
	public static void quiz() {
		
		SecureRandom random = new SecureRandom();
		
		int firstNum = random.nextInt(EXCLUSIVEBOUND); 
		int secondNum = random.nextInt(EXCLUSIVEBOUND);
		
		int answer = firstNum * secondNum;
		
		while(true) {
			 
			askQuestion(firstNum, secondNum);
			
			int response = readResponse();
			
			isAnswerCorrect(response, answer);
		
		}
		
	}
	
	public static void askQuestion(int firstNum, int secondNum) {
		System.out.println("How much is " + firstNum + " times " + secondNum + "?");
	}
	
	public static int readResponse() {
		while(true) {
			try {
				String answer = kb.nextLine();
				int number = Integer.parseInt(answer);
				return number;
			} catch (Exception e) {
				System.out.println("Please enter a number!");
				
			}
		}
	}
	
	public static void isAnswerCorrect(int response, int answer) {
		if (response == answer) {
			displayCorrectResponse();
			kb.close();
			System.exit(0);
		} else {
			displayIncorrectResponse();
		}
	}
	
	public static void displayCorrectResponse() {
		System.out.println("Very Good!");
	}
	
	public static void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}
	
	public static void main(String[] args) {
		quiz();
	}
}
