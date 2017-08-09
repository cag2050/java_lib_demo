package multithread;

public class This_CurrentThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread thread1 = new MyThread();
		MyThread thread2 = new MyThread();
		thread1.start();
		thread2.start();
	}

}

class MyThread extends Thread {
	public void run() {
		System.out.printf("%25s : %s\n", "this", this);
		System.out.printf("%25s : %s\n", "Thread.currentThread()", Thread.currentThread());
		System.out.printf("%25s : %s\n", "this.currentThread()", this.currentThread());
	}
}
