import java.text.DecimalFormat;

public class SavingsAccountTest {
	
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public static void main(String[] args) {
		
		final int year = 12;
		
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		
		SavingsAccount.modifyInterestRate(0.04);
		
		for (int i = 0; i < year; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
		}
		
		System.out.println("Savings Balance: " + df.format(saver1.getSavingsBalance()));
		
		System.out.println("Savings Balance: " + df.format(saver2.getSavingsBalance()));
		
		SavingsAccount.modifyInterestRate(0.05);
		
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		System.out.println("Savings Balance: " + df.format(saver1.getSavingsBalance()));
		
		System.out.println("Savings Balance: " + df.format(saver2.getSavingsBalance()));
		
		
		
	}
	
}
