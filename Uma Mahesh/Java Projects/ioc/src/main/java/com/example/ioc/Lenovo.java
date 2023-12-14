package com.example.ioc;

public class Lenovo {

	int a=0;
	double b=0.0;
	
	public Lenovo(int a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	
	public void values() {
		System.out.println(a+" "+b);
	}

	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	Color color;
//	
//	public Lenovo() {
//		System.out.println("lenovo constructor");
//	}
//	
//	public Lenovo(Color colorobj) {
//		this.color=colorobj;
//	}
//	
//	
//		@Override
//	public void getmodel() {
//		System.out.println("lenovo");
//		color.getlenovocolor();
//	}

}
