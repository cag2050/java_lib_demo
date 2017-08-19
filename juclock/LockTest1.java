package juclock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 这个模型存在两个问题：
// (01) 现实中，仓库的容量不可能为负数。但是，此模型中的仓库容量可以为负数，这与现实相矛盾！
// (02) 现实中，仓库的容量是有限制的。但是，此模型中的容量确实没有限制的！
// 这2个问题可以通过Condition来解决，详见LockTest2.java

// 仓库
class Depot {
	private int size; // 仓库的实际数量
	private Lock lock; // 独占锁

	public Depot() {
		this.size = 0;
		this.lock = new ReentrantLock();
	}

	public void produce(int val) {
		lock.lock();
		try {
			size += val;
			System.out.printf("%s produce (%d) --> size=%d\n", Thread.currentThread().getName(), val, size);
		} finally {
			lock.unlock();
		}
	}

	public void consume(int val) {
		lock.lock();
		try {
			size -= val;
			System.out.printf("%s consume (%d) --> size=%d\n", Thread.currentThread().getName(), val, size);
		} finally {
			lock.unlock();
		}
	}
}

// 生产者
class Producer {
	private Depot depot;

	public Producer(Depot depot) {
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
class Customer {
	private Depot depot;

	public Customer(Depot depot) {
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

public class LockTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Depot depot = new Depot();
		Producer producer = new Producer(depot);
		Customer customer = new Customer(depot);

		producer.produce(60);
		producer.produce(120);
		customer.consume(90);
		customer.consume(150);
		producer.produce(110);
	}

}
