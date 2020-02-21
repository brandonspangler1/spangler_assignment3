import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	
	private static final int EXCLUSIVEBOUND = 10;
	private static final int NUMCHOICESBOUND = 5;
	
	static Scanner kb = new Scanner(System.in);
	
	private static void quiz() {
		
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
	
	private static void askQuestion(int firstNum, int secondNum) {
		System.out.println("How much is " + firstNum + " times " + secondNum + "?");
	}
	
	private static int readResponse() {
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
	
	private static void isAnswerCorrect(int response, int answer) {
		if (response == answer) {
			displayCorrectResponse();
			kb.close();
			System.exit(0);
		} else {
			displayIncorrectResponse();
		}
	}
	
	private static void displayCorrectResponse() {
		
		SecureRandom random = new SecureRandom();
		
		int response = 0;
		
		while (response == 0) {
			response = random.nextInt(NUMCHOICESBOUND);
		}
		
		switch (response) {
			case 1:
				System.out.println("Very Good!");
				break;
			case 2:
				System.out.println("Excellent!");
				break;
			case 3:
				System.out.println("Keep up the good work!");
				break;
			case 4:
				System.out.println("Nice work!");
				break;
		}
	}
	
	private static void displayIncorrectResponse() {
		SecureRandom random = new SecureRandom();
		
		int response = 0;
		
		while (response == 0) {
			response = random.nextInt(NUMCHOICESBOUND);
		}
		
		switch (response) {
			case 1:
				System.out.println("No. Pleae try again.");
				break;
			case 2:
				System.out.println("Wrong. Try once more.");
				break;
			case 3:
				System.out.println("Don't give up!");
				break;
			case 4:
				System.out.println("No. Keep trying.");
				break;
		}
	}
	
	public static void main(String[] args) {
		quiz();
	}
}
