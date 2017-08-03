package multithread;

class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;

	RunnableDemo(String thread_name) {
		threadName = thread_name;
		System.out.println("Creating thread: " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running thread: " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				// 让线程睡眠一会
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

}
