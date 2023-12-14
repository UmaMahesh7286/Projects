package com.feuji.springconfig;

import org.springframework.stereotype.Component;
@Component
public class Marks {
	private int marks;
	private double percentage;
	public Marks() {
		super();
	}
	public Marks(int marks, double percentage) {
		super();
		this.marks = marks;
		this.percentage = percentage;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	
}
