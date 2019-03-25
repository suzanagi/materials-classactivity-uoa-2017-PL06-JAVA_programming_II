import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Collatz {
	// Collatz conjecture:
	// Given n,
	// if n is even then divide it by 2,
	// if n is odd then multiply it by 3 and add 1,
	// The Collatz conjecture claims that this sequence converges to 1.
	// This function will return true if the conjecture is verified for
	// a given n. False otherwise.
	//
	// The conjecture can only be false if there is a repeating sequence
	// of numbers, excluding 1.
	//
	// One difficulty is to detect this loop and prevent looping forever.
	// We can do it by using a set and marking the numbers as
	// we are visiting them.
	//
	// More on the conjecture:
	// https://en.wikipedia.org/wiki/Collatz_conjecture
	//

	private final static BigInteger TWO = new BigInteger("2");
	private final static BigInteger THREE = new BigInteger("3");
  
	public static Result check(BigInteger n) {
	    // Set to mark the visited elements
		HashSet<BigInteger> visited = new HashSet<BigInteger>();
		// Sequence of the visited numbers in order
		ArrayList<BigInteger> sequence = new ArrayList<BigInteger>();
		return check(n, visited, sequence);
	}

	private static Result check(BigInteger n, Set<BigInteger> visited, List<BigInteger> sequence) {
		// n == 1. The sequence converges to 1 for this given n
		if (n.equals(java.math.BigInteger.ONE)) {
			sequence.add(java.math.BigInteger.ONE);
			return new Result(sequence, true);
		}

		// Check if we are inside a repeating sequence
		if (visited.contains(n)) {
		  return new Result(sequence, false);
		}

		visited.add(n);
		sequence.add(n);

		if (n.mod(new BigInteger("2")).equals(java.math.BigInteger.ZERO)) {
			// Even
			n = n.divide(new BigInteger("2"));
		} else {
			// Odd
			n = n.multiply(new BigInteger("3")).add(java.math.BigInteger.ONE);
		}
		    	return check(n, visited, sequence);
	  	}

	public static void main(String[] args) {
	    if (args.length != 1) {
	    		System.out.println("Usage:");
	        System.out.println("java Collatz n");
	        System.out.println("where n is the number to test");
	        System.exit(1);
  		}
	      
	    BigInteger n = new BigInteger(args[0]);
	    Result res = Collatz.check(n);
	    if (res.valid) {
	    		System.out.println("Valid for n="+args[0]);
	    	  	System.out.println("Sequence:");
	    	  	for (BigInteger s: res.sequence) {
	    	  		System.out.print(s + ", ");
	    	  	}
	    	  	System.out.println();
	  	}
	}
}
