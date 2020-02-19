import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	
	private static final int DIFFLEVEL1 = 10;
	private static final int DIFFLEVEL2 = 100;
	private static final int DIFFLEVEL3 = 1000;
	private static final int DIFFLEVEL4 = 10000;
	private static final int NUMCHOICESBOUND = 5;
	private static final int NUMOFPROBLEMS = 10;
	
	static SecureRandom random = new SecureRandom();
	static Scanner kb = new Scanner(System.in);
	
	private static void quiz() {
		
		
		while (true) {
			
			double totalCorrect = 0.0;
			
			int diffLevel = menu();
			int problemType = readProblemType();
			
			if (problemType == 4 || problemType == 5) {
				System.out.println("Round to the nearset whole number!");
			}
			
			for (int i = 0; i < NUMOFPROBLEMS; i++) {
				
				int firstNum = generateQuestionArugment(diffLevel);
				int secondNum = generateQuestionArugment(diffLevel);
				
				//Make sure division is possible
				if (problemType == 4 || problemType == 5) {
					secondNum += 1;
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				int answer = askQuestion(firstNum, secondNum, problemType);
				
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
	
	private static int askQuestion(int firstNum, int secondNum, int problemType) {
		switch (problemType) {
			case 1:
				System.out.println("How much is " + firstNum + " plus " + secondNum + "?");
				return firstNum + secondNum;
			case 2:
				System.out.println("How much is " + firstNum + " times " + secondNum + "?");
				return firstNum * secondNum;
			case 3:
				System.out.println("How much is " + firstNum + " minus " + secondNum + "?");
				return firstNum - secondNum;
			case 4:
				System.out.println("How much is " + firstNum + " divided by " + secondNum + "?");
				return (int) Math.round(((double) firstNum)/secondNum);
			case 5:
				switch (random.nextInt(4)) {
					case 0:
						System.out.println("How much is " + firstNum + " plus " + secondNum + "?");
						return firstNum+secondNum;
					case 1:
						System.out.println("How much is " + firstNum + " times " + secondNum + "?");
						return firstNum*secondNum;
					case 2:
						System.out.println("How much is " + firstNum + " minus " + secondNum + "?");
						return firstNum-secondNum;
					case 3:
						System.out.println("How much is " + firstNum + " divided by " + secondNum + "?");
						return (int) Math.round(((double) firstNum)/secondNum);
					}
			default: 
				return -9999;
		}
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
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
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
	
	private static int readProblemType() {
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Enter a arithmetic problem to study."
				+ "\n\t1. Addition Only"
				+ "\n\t2. Multiplication Only"
				+ "\n\t3. Subtraction Only"
				+ "\n\t4. Divison Only"
				+ "\n\t5. Random Mixture");
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		while (true) {
			try {
				String problemType = kb.nextLine();
				if (Integer.parseInt(problemType) > 0 && Integer.parseInt(problemType) < 6) {
					int num = Integer.parseInt(problemType);
					return num;
				}
			} catch (Exception e) {
				System.out.println("Enter a number 1-5!");
			}
		}
	}
	
	public static void main(String[] args) {
		quiz();
	}
}
