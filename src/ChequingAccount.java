import java.util.Scanner;

public class ChequingAccount {

	private double balance;

	public ChequingAccount(){
		this.balance = balance;
	}

	// get account balance
	public double getBalance(){
		return balance;
	}

	public void deposit(double amount){
		balance = balance + amount;
	}

	public void withdraw(double amount){

		Boolean checkFlag = true;

		if(balance == 0.0)
			System.out.println("Can't withdraw, account balance is 0.");
		
		else if(balance > 0.0 && balance <1000.0){
			if (amount > balance){
				System.out.println("Can't withdraw, withdraw amount larger than balance.");
			}
			else{
				balance = balance - amount;
			}
		}//end else if
		
		else if(balance > 1000 && (balance - amount)<1000){
			System.out.println("Your balance will drop below $1000, "
					+ "a $2.00 one time fee will be charged"
					+ "Are you willing to continue? Please enter: Y/N");

			while(checkFlag){
				Scanner reader = new Scanner(System.in);
				String n = reader.nextLine();
				if(n == "Y"){
					balance = balance - amount - 2.00;
					checkFlag = false;
				}
				if(n == "N"){
					System.out.println("Terminate withdraw process.");
					checkFlag = false;
				}
				else{
					System.out.println("Please enter a valid input: Y/N");
				}
			}//end while
			
		}//end else if

		else
			balance = balance - amount;
	}
}
