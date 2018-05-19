package coreJava.multithreading;
/**
 * Print Pattern a b a b a b a b a b a b a b 
 * @author Nirbhay Mishra
 *
 */
public class PrintPatternByThread {

	static Object monitor = new Object();

	static boolean a = true;
	static boolean b = false;

	public static void main(String[] args) {

		Thread t1 = new Thread(new SequenceDisplayImpl('a'));
		Thread t2 = new Thread(new SequenceDisplayImpl('b'));
		t1.start();
		t2.start();

	}

	static class SequenceDisplayImpl implements Runnable {
		char threadId;
		SequenceDisplayImpl(char threadId) {
			this.threadId = threadId;
		}

		public void run() {
			print();
		}

		
		
		private void print() {
			try {
				while (true) {
					Thread.sleep(500);
					synchronized (monitor) {
						
						
						if ('a' == threadId) {
							if (!a) {
								monitor.wait();
							} else {
								System.out.print(threadId + " ");
								a = false;
								b = true;
								monitor.notifyAll();
							}
						}
						
						
						if ('b' == threadId) {
							if (!b) {
								monitor.wait();
							} else {
								System.out.print(threadId + " ");
								a = true;
								b = false;
								monitor.notifyAll();
							}
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		
	}
}
