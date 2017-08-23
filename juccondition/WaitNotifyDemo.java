package juccondition;

public class WaitNotifyDemo {
	static class ThreadA extends Thread {
		ThreadA(String name) {
			super(name);
		}

		public void run() {
			synchronized (this) { // 通过synchronized(this)获取“当前对象的同步锁”
				System.out.println(Thread.currentThread().getName() + " notify other threads");
				notify(); // 唤醒“当前对象上的等待线程”
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadA threadA = new ThreadA("threadA");
		synchronized (threadA) { // 通过synchronized(threadA)获取“对象threadA的同步锁”
			try {
				System.out.println(Thread.currentThread().getName() + " start");
				threadA.start();
				System.out.println(Thread.currentThread().getName() + " wait");
				threadA.wait();
				System.out.println(Thread.currentThread().getName() + " continue");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
