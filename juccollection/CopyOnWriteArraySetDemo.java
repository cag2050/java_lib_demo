package juccollection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
	static CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<String>();

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyThread thread1 = new MyThread("thread1-");
		MyThread thread2 = new MyThread("thread2-");
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
	}

	static void printAll() {
		String value = null;
		Iterator iterator = copyOnWriteArraySet.iterator();
		if (iterator.hasNext()) {
			value = String.valueOf(iterator.next());
			System.out.print(value + ", ");
		}
		System.out.println();
	}

	static class MyThread extends Thread {
		MyThread(String name) {
			super(name);
		}

		public void run() {
			int i = 0;
			while (i++ < 3) {
				String val = Thread.currentThread().getName() + "-" + i;
				copyOnWriteArraySet.add(val);
				printAll();
			}

		}
	}
}
