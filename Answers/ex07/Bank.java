public class Bank {

	/* Constructor */
	public Bank(int num_accounts, int init_balance) {
		accounts_ = new int[num_accounts];
		num_accounts_ = num_accounts;
		for (int i = 0; i < accounts_.length; i++) {
			accounts_[i] = init_balance;
		}
	}
	
	/* Method to transfer the money from the from account to to account */
	synchronized void transfer(int from, int to, int amount) {
		try {
			System.out.println("from: " + from + " to: " + to + 
				" amount: " + amount);

			if (accounts_[from] < amount) return;
			accounts_[from] = accounts_[from] - amount;
			Thread.sleep((int)(100*Math.random()));
			accounts_[to] = accounts_[to] + amount;
			
			System.out.println("Total balance: " + totalBalance());
		
		} catch (InterruptedException e) {
		
		}
	}

	/* Output the total ammount of all of the accounts in this bank */
	public int totalBalance() {
		int total = 0;
		for (int v : accounts_) {
			total = total + v;	
		}
		return total;
	}
	
	/* Returns the number of accounts in this bank */
	public int getNumberAccounts() {
		return num_accounts_;
	}

	/* Keep the accounts object and the number of accounts in this bank */
	private int accounts_[];
	private int num_accounts_;
	
}
