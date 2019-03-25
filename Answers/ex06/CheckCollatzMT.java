import java.math.BigInteger;
import java.util.Date;


// The implementation of CheckCollatz.check() will be extremely slow
// if we try very large values for n.
// It is actually easy to share the computation on multiple threads,
// by spawning as many threads as cores and running the checks
// for an interval [lower, upper] on 1 core.
//
public class CheckCollatzMT implements Runnable{

	// Keep the value of Lower and Upper of conjecture process
	private BigInteger lower, upper;
	// The result of conjecture process initialized by false;
	public boolean valid = false;
	
	/* Constructor */
	public CheckCollatzMT(BigInteger lower, BigInteger upper) {
		this.lower = lower;
		this.upper = upper;
	}
	
	/* Main Method */
	public static void main(String[] args) {
	    if (args.length != 2) {
	        System.out.println("Usage:");
	        System.out.println("java CheckCollatzMT n num_threads");
	        System.out.println("where positive integers i: 1<= i <= n will be checked");
	        System.out.println("and num_threads is the number of threads to use");
	        System.exit(1);
	      }

	    // Spawn num_threads,
	    // each of them will verify the conjecture for i in [lower, upper]
	    // where lower and upper are determined such that each thread has
	    // approximately the same amount of work to perform.
	    //
	    
		long start_time = new Date().getTime();
	    // Spawn threads
	    Thread[] threads = new Thread[Integer.valueOf(args[1])];
	    // Prepare the value represents the value n divided by the number of threads given
	    BigInteger nDividedByThreads = (new BigInteger(args[0])).divide(new BigInteger(args[1]));
	    // Prepare the CheckCollatzMT object used as runnable task
	    CheckCollatzMT[] task = new CheckCollatzMT[Integer.valueOf(args[1])];
	    for(int i = 0; i < Integer.valueOf(args[1]); i++) {
	    		// lower and upper value will given to the conjecture process of the particular thread
	    		BigInteger low = nDividedByThreads.multiply(new BigInteger(String.valueOf(i))).add(BigInteger.ONE);
	    		BigInteger up = nDividedByThreads.multiply(new BigInteger(String.valueOf(i + 1)));
	    		// for the final thread, assign the all of tasks remaining
	    		if(i == (Integer.valueOf(args[1]) - 1)) task[i] = new CheckCollatzMT(low, new BigInteger(args[0]));
	    		else task[i] = new CheckCollatzMT(low, up);
	    		// Initialize the thread
	    		threads[i] = new Thread(task[i]);
	    }
	    // Start the threads and join it
	    for(int i = 0; i < Integer.valueOf(args[1]); i++) {
	    		threads[i].start();
	    }
	    for(int i = 0; i < Integer.valueOf(args[1]); i++) {
		try {
		    threads[i].join();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	    // Check flag whether the conjecture is succeed or not
	    boolean isValid = true;
	    // If any conjecture is failed, the flag is false
	    for(int i = 0; i < Integer.valueOf(args[1]); i++)
	    		if(!task[i].valid) 
	    			isValid = false;
		long end_time = new Date().getTime();
		System.out.println("Ellapsed time: " + (end_time-start_time) + "ms");
		
		if (isValid) {
    		System.out.println("The conjecture seems valid up to n="+args[0]);
    	} else {
    		System.out.println("The conjecture is not valid");
    	}
	}
	
	/* Process of conjecture called by run method */
	public boolean conjecture() {
		for(BigInteger i = this.lower; i.compareTo(this.upper) <= 0; i = i.add(BigInteger.ONE)) {
		    boolean check = Collatz.check(i).valid;
		    if(!check) return false;
		}
		return true;
	}

	@Override
	public void run() {
		if(this.conjecture()) this.valid = true;
		else this.valid = false;
	}

}
