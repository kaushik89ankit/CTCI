/*

Problem : Animal Shelter -

*/

import java.util.*;

class Animal {
	Date date;
	String name;
	Animal(String name) {
		this.date = new Date();
		this.name = name;
	}

	boolean isOlderThan(Animal animal) {
		return this.date.compareTo(animal.date) > 0 ? true : false;
	}
}

class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}
}


class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
}

class AnimalQueue {

	LinkedList<Dog> dogList;
	LinkedList<Cat> catList;

	AnimalQueue() {
		dogList = new LinkedList<Dog>();
		catList = new LinkedList<Cat>();
	}

	void enqueue(Animal animal) {
		if (animal instanceof Dog) {
			dogList.addLast((Dog)animal);
		} else {
			catList.addLast((Cat)animal);
		}
	}

	Animal dequeueAny() {

		if (dogList.isEmpty()) {
			return dequeueCat();
		} else if (catList.isEmpty()) {
			return dequeueDog();
		}

		Dog oldestDog = dogList.peek();
		Cat oldestCat = catList.peek();

		if (oldestDog.isOlderThan(oldestCat)) {
			return dogList.poll();
		} else {
			return catList.poll();
		}
	}

	Animal dequeueCat() {
		if (catList.isEmpty()) {
			return null;
		}
		return catList.poll();
	}

	Animal dequeueDog() {
		if (dogList.isEmpty()) {
			return null;
		}
		return dogList.poll();
	}

	int size() {
		return dogList.size() + catList.size();
	}

}


class Question6 {

	public static void main(String[] args) {
		AnimalQueue animalQueue = new AnimalQueue();

		Dog dogA = new Dog("dogA");
		Dog dogb = new Dog("dogB");
		Dog dogc = new Dog("dogC");
		Dog dogd = new Dog("dogD");
		Dog doge = new Dog("dogE");
		Dog dogf = new Dog("dogF");

		animalQueue.enqueue(dogA);
		animalQueue.enqueue(dogb);
		animalQueue.enqueue(dogc);
		animalQueue.enqueue(dogd);
		animalQueue.enqueue(doge);
		animalQueue.enqueue(dogf);

		Cat catA = new Cat("catA");
		Cat catb = new Cat("catB");
		Cat catc = new Cat("catC");
		Cat catd = new Cat("catD");
		Cat cate = new Cat("catE");
		Cat catf = new Cat("catF");

		animalQueue.enqueue(catA);
		animalQueue.enqueue(catb);
		animalQueue.enqueue(catc);
		animalQueue.enqueue(catd);
		animalQueue.enqueue(cate);
		animalQueue.enqueue(catf);


		while (animalQueue.size() != 0) {
			System.out.println("Animal : " + animalQueue.dequeueAny().name + " with size :"  + animalQueue.size());
		}

	}
}