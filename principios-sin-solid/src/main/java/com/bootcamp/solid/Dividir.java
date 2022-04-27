package com.bootcamp.solid;

public class Dividir extends Operar{
	
	public Dividir(double a, double b) {
		super(a,b);
	}

	@Override
	public void operar() {
		result = a / b;
	}

}