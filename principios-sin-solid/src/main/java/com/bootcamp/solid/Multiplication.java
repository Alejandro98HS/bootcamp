package com.bootcamp.solid;

public class Multiplication extends Operar{
	
	public Multiplication(double a, double b) {
		super(a,b);
	}

	@Override
	public void operar() {
		result = a * b;
	}
}