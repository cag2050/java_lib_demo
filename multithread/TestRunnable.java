package multithread;

public class TestRunnable {
	public static void main(String[] args) {
		System.out.printf("%20s : %s\n", "Thread.currentThread()", Thread.currentThread());
		RunnableDemo R1 = new RunnableDemo("Thread-1");
		R1.start();
		System.out.printf("%20s : %s\n", "Thread.currentThread()", Thread.currentThread());
		RunnableDemo R2 = new RunnableDemo("Thread-2");
		R2.start();
		System.out.printf("%20s : %s\n", "Thread.currentThread()", Thread.currentThread());
	}
}
