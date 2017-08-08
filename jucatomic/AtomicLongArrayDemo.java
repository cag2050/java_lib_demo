package jucatomic;

import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicLongArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// long[] longArray = new long[] { 10, 20, 30, 40 };
		long[] longArray = { 10, 20, 30, 40 };
		AtomicLongArray atomicLongArray = new AtomicLongArray(longArray);
		System.out.printf("%30s : %s\n", "toString()", atomicLongArray.toString());
		System.out.printf("%30s : %s\n", "String.valueOf()", String.valueOf(atomicLongArray));
		atomicLongArray.set(0, 100);
		int len = atomicLongArray.length();
		for (int i = 0; i < len; i++) {
			System.out.printf("%30s : %s\n", "get(" + i + ")", atomicLongArray.get(i));
		}
		System.out.printf("%30s : %s\n", "compareAndSet(2, 30, 300)", atomicLongArray.compareAndSet(2, 30, 300));
		System.out.printf("%30s : %s\n", "get(2)", atomicLongArray.get(2));
	}

}
