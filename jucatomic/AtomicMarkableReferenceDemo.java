package jucatomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceDemo {
	static AtomicMarkableReference<Integer> atomicMarkableReference = new AtomicMarkableReference<Integer>(10, false);

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.printf("%20s : %s\n", "reference", atomicMarkableReference.getReference());
		System.out.printf("%20s : %s\n", "mark", atomicMarkableReference.isMarked());

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				// atomicMarkableReference.compareAndSet(10, 11, false, true);
				System.out.println("t1: " + atomicMarkableReference.compareAndSet(10, 11, false, true));
				System.out.printf("%20s : %s\n", "t1:reference", atomicMarkableReference.getReference());
				System.out.printf("%20s : %s\n", "t1:mark", atomicMarkableReference.isMarked());
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("t2: " + atomicMarkableReference.compareAndSet(10, 12, false, true));
				System.out.printf("%20s : %s\n", "t2:reference", atomicMarkableReference.getReference());
				System.out.printf("%20s : %s\n", "t2:mark", atomicMarkableReference.isMarked());
			}
		});
		// 不管是t1还是t2，先运行到就会通过 compareAndSet 将reference和mark的值修改
		// 后运行到的线程，就会读到修改后的值
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.printf("%20s : %s\n", "final reference", atomicMarkableReference.getReference());
		System.out.printf("%20s : %s\n", "final mark", atomicMarkableReference.isMarked());
	}

}
