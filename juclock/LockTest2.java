package juclock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//仓库
class Depot2 {
	private int capacity; // 仓库的容量
	private int size; // 仓库的实际数量
	private Lock lock; // 独占锁
	private Condition fullCondition;
	private Condition emptyCondition;

	public Depot2(int capacity) {
		this.capacity = capacity;
		this.size = 10;
		this.lock = new ReentrantLock();
		this.fullCondition = lock.newCondition();
		this.emptyCondition = lock.newCondition();
	}

	public void produce(int val) {
		lock.lock();
		try {
			// 要生产的数量
			int left = val;
			while (left > 0) {
				while (size >= capacity) {
					fullCondition.await();
				}
				int inc = (size + left) > capacity ? capacity - size : left;
				size += inc;
				left -= inc;
				System.out.printf("%s produce (%3d) -->left=%3d inc=%3d size=%3d\n", Thread.currentThread().getName(),
						val, left, inc, size);
				emptyCondition.signal();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void consume(int val) {
		lock.lock();
		try {
			// 要消费的数量
			int left = val;
			while (left > 0) {
				while (size <= 0) {
					emptyCondition.await();
				}
				int dec = (size < left) ? size : left;
				size -= dec;
				left -= dec;
				System.out.printf("%s consume (%3d) --> left=%3d dec=%3d size=%d\n", Thread.currentThread().getName(),
						val, left, dec, size);
				fullCondition.signal();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String toString() {
		return "capacity=" + capacity + ",actual size= " + size;
	}
}

// 生产者
class Producer2 {
	private Depot2 depot;

	public Producer2(Depot2 depot) {
		this.depot = depot;
	}

	// 生产产品：新建一个线程向仓库中生产产品。
	public void produce(int val) {
		new Thread() {
			public void run() {
				depot.produce(val);
			}
		}.start();
	}
}

// 消费者
class Customer2 {
	private Depot2 depot;

	public Customer2(Depot2 depot) {
		this.depot = depot;
	}

	// 消费产品：新建一个线程向仓库中生产产品。
	public void consume(int val) {
		new Thread() {
			public void run() {
				depot.consume(val);
			}
		}.start();
	}
}

public class LockTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Depot2 depot = new Depot2(10);
		Producer2 producer = new Producer2(depot);
		Customer2 customer = new Customer2(depot);
		
		customer.consume(3);
		producer.produce(12);
		producer.produce(2);
		customer.consume(3);
		customer.consume(15);
		producer.produce(11);
	}
}
