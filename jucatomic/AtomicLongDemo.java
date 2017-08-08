package jucatomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicLong atomicLong = new AtomicLong();
		atomicLong.set(0x0123456789ABCDEFL);
		System.out.printf("%20s : 0x%016X\n", "get()", atomicLong.get());
		System.out.printf("%20s : 0x%016X\n", "intValue()", atomicLong.intValue());
		System.out.printf("%20s : 0x%016X\n", "longValue()", atomicLong.longValue());
		System.out.printf("%20s : %s\n", "floatValue()", atomicLong.floatValue());
		System.out.printf("%20s : %s\n", "doubleValue()", atomicLong.doubleValue());
	}
}
