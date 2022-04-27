package com.bootcamp.solid;

public abstract class Operar {
	
	public double a;
	public double b;
	public double result;
	
	public Operar(double a, double b) {
		this.a=a;
		this.b=b;
	}
	
	public abstract void operar();
}
