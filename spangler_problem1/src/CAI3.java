import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	
	private static final int EXCLUSIVEBOUND = 10;
	private static final int NUMOFPROBLEMS = 10;
	
	static Scanner kb = new Scanner(System.in);
	
	private static void quiz() {
		
		SecureRandom random = new SecureRandom();
		
		
		while (true) {
			
			double totalCorrect = 10.0;
			
			if (menu() == 1) {
				for (int i = 0; i < NUMOFPROBLEMS; i++) {
					
					int firstNum = random.nextInt(EXCLUSIVEBOUND); 
					int secondNum = random.nextInt(EXCLUSIVEBOUND);
					
					int answer = firstNum * secondNum;
					
					askQuestion(firstNum, secondNum);
					
					int response = readResponse();
					
					totalCorrect += isAnswerCorrect(response, answer);
				}
			}
			
			if (totalCorrect/NUMOFPROBLEMS > 0.75) {
				System.out.println(displayCorrectResponse());
			} else {
				System.out.println(displayIncorrectResponse());
			}
			
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
	
	private static int isAnswerCorrect(int response, int answer) {
		if (response == answer) {
			return 0;
		} else {
			return -1;
		}
	}
	
	private static String displayCorrectResponse() {
		return "Congratulations, you are ready to go to the next level!";
	}
	
	private static String displayIncorrectResponse() {
		return "Please ask your teacher for extra help.";
	}
	
	private static int menu() {
		while (true) {
			System.out.println("Do you want to start a new problem set? (y/n)");
			String choice = kb.nextLine();
			if (choice.charAt(0) == 'n') {
				System.exit(0);
			} else if (choice.charAt(0) == 'y'){
				return 1;
			} else {
				System.out.println("Enter a vaild input!");
			}
		}
		
	}
	
	public static void main(String[] args) {
		quiz();
	}
}
