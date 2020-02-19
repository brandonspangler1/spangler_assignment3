import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
	
	private static final int DIFFLEVEL1 = 10;
	private static final int DIFFLEVEL2 = 100;
	private static final int DIFFLEVEL3 = 1000;
	private static final int DIFFLEVEL4 = 10000;
	private static final int NUMCHOICESBOUND = 5;
	private static final int NUMOFPROBLEMS = 10;
	
	static Scanner kb = new Scanner(System.in);
	
	private static void quiz() {
		
		
		while (true) {
			
			double totalCorrect = 0.0;
			
			int diffLevel = menu();
			
			for (int i = 0; i < NUMOFPROBLEMS; i++) {
				
				int firstNum = generateQuestionArugment(diffLevel);
				int secondNum = generateQuestionArugment(diffLevel);
				
				int answer = firstNum * secondNum;
				
				askQuestion(firstNum, secondNum);
				
				int response = readResponse();
				
				totalCorrect += isAnswerCorrect(response, answer);
				
				if (isAnswerCorrect(response, answer) == 1) {
					displayCorrectResponse();
				} else {
					displayIncorrectResponse();
				}
				
			}
			
			
			displayCompletionMessage(totalCorrect);
			
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
		
		
		if (totalCorrect/NUMOFPROBLEMS > 0.75) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		} else {
			System.out.println("Please ask your teacher for extra help.");
		}
	
}
	
	private static int menu() {
		while (true) {
			System.out.println("Do you want to start a new problem set? (y/n)");
			String choice = kb.nextLine();
			if (choice.charAt(0) == 'n') {
				System.exit(0);
			} else if (choice.charAt(0) == 'y'){
				return readDiffculty();
			} else {
				System.out.println("Enter a vaild input!");
			}
		}
		
	}
	
	private static int readDiffculty() {
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
	
	private static int generateQuestionArugment(int diffLevel) {
		
		SecureRandom random = new SecureRandom();
		
		switch (diffLevel){
			case 1:
				return random.nextInt(DIFFLEVEL1);
			case 2:
				return random.nextInt(DIFFLEVEL2);
			case 3:
				return random.nextInt(DIFFLEVEL3);
			case 4: 
				return random.nextInt(DIFFLEVEL4);
			default:
				return -1;
		}
		
	}
	
	public static void main(String[] args) {
		quiz();
	}
}
