package com.bootcamp.solid;

public class Addition extends Operar{
    
	
	public Addition(double a, double b) {
		super(a,b);
	}

	@Override
	public void operar() {
		result = a + b;
	}
}