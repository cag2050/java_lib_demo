package juclock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//通过ReentrantLock和Condition实现完善的生产/消费者模型
// 通过Condition来解决两个问题：“仓库的容量不可能为负数”以及“仓库的容量是有限制的”。
// Condition是需要和Lock联合使用的：通过Condition中的await()方法，能让线程阻塞[类似于wait()]；通过Condition的signal()方法，能让唤醒线程[类似于notify()]。

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
//				仓库的实际数量 大于等于 仓库容量，阻塞
				while (size >= capacity) {
					fullCondition.await();
				}
//				如果仓库的实际数量加上要生产的数量 大于 仓库容量，此次可生产的数量是 仓库容量减去实际数量；否则，小于等于 仓库容量，可生产数量是要生产的数量
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
//				仓库的实际数量 小于等于 0，阻塞
				while (size <= 0) {
					emptyCondition.await();
				}
//				如果要消费的数量 大于 仓库的实际数量，此次可消费的数量是 仓库实际数量；否则，小于等于 仓库实际数量，可消费数量是要消费的数量
				int dec = (left > size) ? size : left;
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

public class ReentrantLockConditionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Depot2 depot = new Depot2(10);
		Producer2 producer = new Producer2(depot);
		Customer2 customer = new Customer2(depot);

		customer.consume(3);
		producer.produce(1);
		producer.produce(2);
		customer.consume(4);
	}
}
