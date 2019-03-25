/*
 * @author s1240234 Yuta Nemoto
 */

//"Transfer" threads select a random amount of money in [0, max_amount]
//and transfer it to a random account in the bank.
//

public class Transfer extends Thread{
	/* Constructor */
	public Transfer(Bank bank, int from, int max_amount) {
		bank_ = bank;
		from_ = from;
		max_ = max_amount;
	}

	/* Process the Transfer Thread executes */
	public void run() {
		while(true) {
			int accountTo = (int) (Math.random() * BankTest.N_ACCOUNTS);
			int amount = (int) (Math.random() * this.max_);
			bank_.transfer(from_, accountTo, amount);
		}
	}

	/* Stores the bank object, the account number of the source account, and the number of the accounts */
	private Bank bank_;
	private int from_;
	private int max_;
}
