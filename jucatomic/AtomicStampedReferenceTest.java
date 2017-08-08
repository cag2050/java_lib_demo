package jucatomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {

	static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(0, 0);

	public static void main(String[] args) throws InterruptedException {

		final int stamp = atomicStampedReference.getStamp();
		final Integer reference = atomicStampedReference.getReference();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Integer reference = atomicStampedReference.getReference();
				System.out.printf("%20s : %s\n", "t1 reference", reference);
				Integer stamp = atomicStampedReference.getStamp();
				System.out.printf("%20s : %s\n", "t1 stamp", stamp);
				System.out.println("t1, " + Thread.currentThread().getName() + ", "
						+ atomicStampedReference.getReference() + ", " + atomicStampedReference.getStamp() + ", "
						+ atomicStampedReference.compareAndSet(reference, reference + 2, stamp, stamp + 3));
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Integer reference = atomicStampedReference.getReference();
				System.out.printf("%20s : %s\n", "t2 reference", reference);
				Integer stamp = atomicStampedReference.getStamp();
				System.out.printf("%20s : %s\n", "t2 stamp", stamp);
				System.out.println("t2, " + Thread.currentThread().getName() + ", "
						+ atomicStampedReference.getReference() + ", " + atomicStampedReference.getStamp() + ", "
						+ atomicStampedReference.compareAndSet(reference, reference + 2, stamp, stamp + 3));
			}
		});
		// 不管是t1还是t2，先运行到就会通过 compareAndSet 将reference和stamp的值修改，并返回值true
		// 后运行到的线程，就会读到修改后的值
		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.printf("%20s : %s\n", "getReference()", atomicStampedReference.getReference());
		System.out.printf("%20s : %s\n", "getStamp()", atomicStampedReference.getStamp());
	}
}
