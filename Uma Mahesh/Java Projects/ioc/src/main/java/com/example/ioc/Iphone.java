package com.example.ioc;

public class Iphone implements Mobiles {

	Color color;
	
	public Iphone() {
		System.out.println("Iphone constructor");
	}
	public Iphone(Color colorobj) { //constructor injection
		this.color=colorobj;
	}
	@Override
	public void getmodel() {
		System.out.println("iphone");
		color.getiphonecolor();
	}

}
