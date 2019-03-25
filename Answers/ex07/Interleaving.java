
public class Interleaving {

	public static void main(String[] args) {
		ThreadMonitor m = new ThreadMonitor();

		EvenThread t1 = new EvenThread(m);
		OddThread t2 = new OddThread(m);

		t1.start();
		t2.start();

        try {
          t1.join();
          t2.join();
        } catch (InterruptedException e) {
          System.out.println("One of the threads was interrupted");
        }
	}
	
	

}

class EvenThread extends Thread {
	// For each even number from 2 to N
	//   Wait for your turn if needed
	//   Print the current number
	//   Pass your turn
	
	private ThreadMonitor tm;
	private int number = ThreadMonitor.EVEN;
	
	/* Constructor */
	public EvenThread(ThreadMonitor tm) {
		this.tm = tm;
	}
	/* The process this thread executes while it's running */
	@Override
	public void run() {
		while(true) {
			try {
				tm.checkTurn(this.number);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.number);
			this.number += 2;
			tm.changeTurn();
		}
	}
}


class OddThread extends Thread {
	// For each odd number from 1 to N	
	//   Wait for your turn
	//   Print the current number
	//   Pass your turn
	
	private ThreadMonitor tm;
	private int number = ThreadMonitor.ODD;
	
	/* Constructor */
	public OddThread(ThreadMonitor tm) {
		this.tm = tm;
	}
	
	/* The process this thread executes while it's running */
	@Override
	public void run() {
		while(true) {
			try {
				tm.checkTurn(this.number);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.number);
			this.number += 2;
			tm.changeTurn();
		}
	}
}
    

class ThreadMonitor {
	public static final int ODD = 1;
	public static final int EVEN = 2;
	private int turn = ODD;
	
	// Implement two methods that will allow a thread to:
	// - wait for its turn (i.e. if it is the odd thread and it should be
	// the turn of the even thread, then it will wait)
	// - change the turn status once it is done (i.e. after printing
	// its number, a thread will invoke this method to allow the other
	// thread to work)
	//
	
	// The method allow a thread to wait for its turn 
	synchronized public void checkTurn(int number) throws InterruptedException {
		switch(this.turn) {
		case ODD:
			// It's the ODD turn right now
			switch(number % EVEN) {
			case ODD:
				// The accessing thread is odd thread
				break;
			default:
				// The accessing thread is even thread
				wait();
				break;
			}
			break;
		case EVEN:
			// It's the EVEN turn right now
			switch(number % EVEN) {
			case ODD:
				// The accessing thread is odd thread
				wait();
				break;
			default:
				// The accessing thread is even thread
				break;
			}
			break;
		default:
			wait();
			break;
		}
	}
	
	// The method allow a thread to change the turn status once it is done
	synchronized public void changeTurn() {
		switch(this.turn) {
		case ODD:
			this.turn = EVEN;
			break;
		case EVEN:
			this.turn = ODD;
			break;
		}
		notifyAll();
	}
}
