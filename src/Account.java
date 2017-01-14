import gui.Customer;

public class Account {

	private Customer customer;

	private int accountNumber;
	private String password;

	ChequingAccount chequing;
	SavingAccount saving;

	public Account(Customer customer, int accNum, String pswd, ChequingAccount che, SavingAccount sav){
		this.customer = customer;
		this.accountNumber = accNum;
		this.password = pswd;
		this.chequing = che;
		this.saving = sav;
	}

	public int getAccountNumber(){
		return accountNumber;
	}

	public String getPassword(){
		return password;
	}


	// transfer money from chequing to saving
	public void transferCheToSav(double amount, Account acc){
		if(acc.chequing != null && acc.saving != null){
			acc.chequing.withdraw(amount);
			acc.saving.deposit(amount);
		}
		else
			System.out.println("Can't make such transfer,"
					+ "There is no chequing account or saving account. "
					+ "Please ask manager to help you open one.");
	}

	// transfer money from saving to chequing
	public void trasferSavToChe(double amount, Account acc){
		if(acc.chequing != null && acc.saving !=null){
			acc.saving.withdraw(amount);
			acc.chequing.deposit(amount);
		}
		else
			System.out.println("Can't make such transfer,"
					+ "There is no chequing account or saving account. "
					+ "Please ask manager to help you open one.");
	}

	// chequing account can be delete if the balance is 0
	public void deleteChequingAccount(Account acc){
		if (acc.chequing.getBalance()==0){
			acc.chequing = null;
		}
		else 
			System.out.println("Can't delete chequing account, since the balance is not 0.");
	}

	// saving account can be delete if the balance is 0
	public void deleteSavingAccount(Account acc){
		if (acc.saving.getBalance()==0){
			acc.saving = null;
		}
		else 
			System.out.println("Can't delete saving account, since the balance is not 0.");
	}
	
	//open new chequing account if there is not one
	public void openChequingAccount(Manager manager, Account acc){
		if (acc.chequing == null){
			acc.chequing = new ChequingAccount();
		}
		else 
			System.out.println("Chequing account already exist.");
	}
	
	//open new saving account if there is not one
	public void openSavingAccount(Manager manager, Account acc){
		if (acc.saving == null){
			acc.saving = new SavingAccount();
		}
		else 
			System.out.println("Saving account already exist.");
	}
	
	
	
	//现在的情况呢是 没办法一起delete chequing 和saving 因为database设置了constraint chequing 和 saving
	//不能同时是0, 解决办法，去掉constraint, 设一个trigger 如果检测到两个都是0,则执行删除account的操作
	//1. 删掉constraint 2.设trigger 
	//
	/* ********************************************************************************
	 * public void deleteAccount（Account acc){
			if(acc.saving = null && acc.chequing = null) 
				acc = null;
			else
				System.out.println("Can't delete account, since the balance is not 0. "
		} 
	 **********************************************************************************/
}
