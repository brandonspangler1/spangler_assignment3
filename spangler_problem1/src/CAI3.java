import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	
	private static final int EXCLUSIVEBOUND = 10;
	private static final int NUMCHOICESBOUND = 5;
	private static final int NUMOFPROBLEMS = 10;
	
	static Scanner kb = new Scanner(System.in);
	
	private static void quiz() {
		
		SecureRandom random = new SecureRandom();
		
		double totalCorrect = 0.0;
		
		while (true) {
			
			
			if (menu() == 1) {
				for (int i = 0; i < NUMOFPROBLEMS; i++) {
					
					int firstNum = random.nextInt(EXCLUSIVEBOUND); 
					int secondNum = random.nextInt(EXCLUSIVEBOUND);
					
					int answer = firstNum * secondNum;
					
					askQuestion(firstNum, secondNum);
					
					int response = readResponse();
					
					totalCorrect += isAnswerCorrect(response, answer);
					
					if (isAnswerCorrect(response, answer) == 1) {
						displayCorrectResponse();
					} else {
						displayIncorrectResponse();
					}
					
					if (i == NUMOFPROBLEMS-1) {
						displayCompletionMessage(totalCorrect);
					}
				}
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
			return 1;
		} else {
			return 0;
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
	
	private static void displayCompletionMessage(double totalCorrect) {
		
		double score;
		
		if (totalCorrect/NUMOFPROBLEMS == 1) {
			score = 10;
		} else {
			score = totalCorrect/NUMOFPROBLEMS;
		}
		
		
		if (totalCorrect/NUMOFPROBLEMS > 0.75) {
			System.out.println("Congratulations, you are ready to go to the next level!");
			System.out.println("Your score was: " + score);
		} else {
			System.out.println("Please ask your teacher for extra help.");
			System.out.println("Your score was: " + score);
		}
		
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
