package juccondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitSignalDemo {
	private static Lock lock = new ReentrantLock();
	static Condition condition = lock.newCondition();

	static class ThreadA extends Thread {
		ThreadA(String name) {
			super(name);
		}

		public void run() {
			lock.lock(); // 获取锁
			try {
				System.out.println(Thread.currentThread().getName() + " signal other threads");
				condition.signal(); // 唤醒“condition所在锁上的其它线程”
			} finally {
				lock.unlock(); // 释放锁
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadA threadA = new ThreadA("threadA");
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " start");
			threadA.start();
			System.out.println(Thread.currentThread().getName() + " await");
			condition.await();
			System.out.println(Thread.currentThread().getName() + " continue");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
