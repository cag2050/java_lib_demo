package multithread;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(100); // 休眠100ms
					System.out.println(Thread.currentThread().getName() + " loop " + i);
				}
			} catch (InterruptedException ie) {
			}
		}
	}

}

public class SynchronizedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable demo = new MyRunnable(); // 新建“Runnable对象”

		Thread t1 = new Thread(demo, "t1"); // 新建“线程t1”, t1是基于demo这个Runnable对象
		Thread t2 = new Thread(demo, "t2"); // 新建“线程t2”, t2是基于demo这个Runnable对象
		t1.start(); // 启动“线程t1”
		t2.start(); // 启动“线程t2”
	}

}
