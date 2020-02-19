import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
	
	private static final int DIFFLEVEL1 = 10;
	private static final int DIFFLEVEL2 = 100;
	private static final int DIFFLEVEL3 = 1000;
	private static final int DIFFLEVEL4 = 10000;
	private static final int NUMOFPROBLEMS = 10;
	
	static Scanner kb = new Scanner(System.in);
	
	private static void quiz() {
		
		SecureRandom random = new SecureRandom();
		
		
		while (true) {
			
			double totalCorrect = 10.0;
			
			switch (menu()) {
				case 1: 
					for (int i = 0; i < NUMOFPROBLEMS; i++) {
						
						int firstNum = random.nextInt(DIFFLEVEL1); 
						int secondNum = random.nextInt(DIFFLEVEL1);
						
						int answer = firstNum * secondNum;
						
						askQuestion(firstNum, secondNum);
						
						int response = readResponse();
						
						totalCorrect += isAnswerCorrect(response, answer);
					}
					break;
				case 2:
					for (int i = 0; i < NUMOFPROBLEMS; i++) {
						
						int firstNum = random.nextInt(DIFFLEVEL2); 
						int secondNum = random.nextInt(DIFFLEVEL2);
						
						int answer = firstNum * secondNum;
						
						askQuestion(firstNum, secondNum);
						
						int response = readResponse();
						
						totalCorrect += isAnswerCorrect(response, answer);
					}
					break;
				case 3:
					for (int i = 0; i < NUMOFPROBLEMS; i++) {
						
						int firstNum = random.nextInt(DIFFLEVEL3); 
						int secondNum = random.nextInt(DIFFLEVEL3);
						
						int answer = firstNum * secondNum;
						
						askQuestion(firstNum, secondNum);
						
						int response = readResponse();
						
						totalCorrect += isAnswerCorrect(response, answer);
					}
					break;
				case 4:
					for (int i = 0; i < NUMOFPROBLEMS; i++) {
						
						int firstNum = random.nextInt(DIFFLEVEL4); 
						int secondNum = random.nextInt(DIFFLEVEL4);
						
						int answer = firstNum * secondNum;
						
						askQuestion(firstNum, secondNum);
						
						int response = readResponse();
						
						totalCorrect += isAnswerCorrect(response, answer);
					}
					break;	
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
				return diffcultyLevel();
			} else {
				System.out.println("Enter a vaild input!");
			}
		}
		
	}
	
	private static int diffcultyLevel() {
		while (true) {
			System.out.println("What diffculty level do you want? 1, 2, 3, or 4?");
			try {
				String answer = kb.nextLine();
				if (Integer.parseInt(answer) > 0 && Integer.parseInt(answer) < 5) {
					int num = Integer.parseInt(answer);
					return num;
				}
			} catch (Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		quiz();
	}
}
