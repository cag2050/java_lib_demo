package jucatomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person(20L);
		System.out.printf("%20s : %s\n", "person.id", person1.toString());
		AtomicReference atomicReference = new AtomicReference(person1);
		Person person2 = (Person) atomicReference.get();
		System.out.printf("%20s : %s\n", "person.id", person2.toString());

	}

}

class Person {
	volatile long id;

	public Person(long id) {
		this.id = id;
	}

	public String toString() {
		return "" + id;
	}
}
