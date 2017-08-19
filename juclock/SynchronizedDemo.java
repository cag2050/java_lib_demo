package juclock;

class Depot3 {
	private int size = 0; // 仓库剩余数量
	private int capacity; // 仓库容量

	Depot3(int capacity) {
		this.capacity = capacity;
	}

	public synchronized void produce(int val) {
		try {
			int left = val;
			while (left > 0) {
				while (size >= capacity) {
					wait();
				}
				int inc = size + left > capacity ? capacity - size : left;
				size += inc;
				left -= inc;
				System.out.printf("%s produce (%3d) -->left=%3d inc=%3d size=%3d\n", Thread.currentThread().getName(),
						val, left, inc, size);
				notifyAll();
			}
		} catch (InterruptedException e) {

		}

	}

	public synchronized void consume(int val) {
		try {
			int left = val;
			while (left > 0) {
				while (size <= 0) {
					wait();
				}
				int dec = left > size ? size : left;
				size -= dec;
				left -= dec;
				System.out.printf("%s consume (%3d) -->left=%3d dec=%3d size=%3d\n", Thread.currentThread().getName(),
						val, left, dec, size);
				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Producer3 {
	private Depot3 depot;

	public Producer3(Depot3 depot) {
		this.depot = depot;
	}

	public void produce(int val) {
		new Thread() {
			public void run() {
				depot.produce(val);
			}
		}.start();
	}
}

class Customer3 {
	private Depot3 depot;

	public Customer3(Depot3 depot) {
		this.depot = depot;
	}

	public void consume(int val) {
		new Thread() {
			public void run() {
				depot.consume(val);
			}
		}.start();
	}

}

public class SynchronizedDemo {
	public static void main(String[] args) {
		Depot3 depot = new Depot3(10);
		Producer3 producer = new Producer3(depot);
		Customer3 customer = new Customer3(depot);

		producer.produce(1);
		producer.produce(1);
		customer.consume(30);
		producer.produce(10);

	}
}
