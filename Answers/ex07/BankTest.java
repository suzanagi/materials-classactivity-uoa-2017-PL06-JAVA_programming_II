public class BankTest {
	public static final int N_ACCOUNTS = 5;
	public static final int INIT_BALANCE = 1000;
	
	/* Main Method */
	public static void main(String[] args) {
		// Generate the object of Bank 
		Bank bank = new Bank(BankTest.N_ACCOUNTS, BankTest.INIT_BALANCE);
		// Generate the array of transfer objects
		Transfer[] transactions = new Transfer[BankTest.N_ACCOUNTS];
		// Initialize the transfer objects in the transactions array
		for(int i = 0; i < BankTest.N_ACCOUNTS; i++) transactions[i] = new Transfer(bank, i, BankTest.INIT_BALANCE);
		// Start the transfer threads
		for(Transfer t: transactions) t.start();
	}

}
