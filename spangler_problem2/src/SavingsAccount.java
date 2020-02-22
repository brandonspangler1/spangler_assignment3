
public class SavingsAccount {

	private static double annualInterestRate;
	
	private double savingsBalance;
	
	public SavingsAccount(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public void calculateMonthlyInterest() {
		savingsBalance += (savingsBalance * annualInterestRate)/12;
	}
	
	public static void modifyInterestRate(double aIR) {
		annualInterestRate = aIR;
	}
	
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	
	
}
