package com.fp.solid.liskov.problem;

public class Elephant extends Animal {

	@Override
	public void walk() {
		System.out.println("Soy un elefante y ando con mis patas grandotas");
		
	}

	@Override
	public void jump() {
		throw new RuntimeException("No puedo saltar porque soy muy grande!");
		
	}

}