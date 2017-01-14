
public class SavingAccount {

	private double balance;

	public SavingAccount(){
		this.balance = balance;
	}

	public double getBalance(){
		return balance;
	}

	public void deposit(double amount){
		balance = balance + amount;
	}

	public void withdraw(double amount){
		if(amount > balance || balance == 0.0){
			System.out.println("Not enough balance.");
		}
		else
			balance = balance - amount;
	}

}