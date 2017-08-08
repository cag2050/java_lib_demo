package jucatomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class AtomicLongFieldUpdaterDemo {
	public static void main(String[] args) {
		Class class1 = Man.class;
		// 传入参数是：class 和 类的某个属性
		AtomicLongFieldUpdater atomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(class1, "id");
		System.out.printf("%20s : %s\n", "toString()", atomicLongFieldUpdater.toString());
		Man man = new Man(123L);
		atomicLongFieldUpdater.compareAndSet(man, 123L, 456);
		System.out.printf("%20s : %s\n", "getId()", man.getId());
	}
}

class Man {
	volatile long id;

	public Man(long id) {
		this.id = id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
