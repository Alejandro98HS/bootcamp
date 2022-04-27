package com.bootcamp.solid;

public class Substraction extends Operar{ 
	
	public Substraction(double a, double b) {
		super(a,b);
	}

	@Override
	public void operar() {
		result = a - b;
	}

}