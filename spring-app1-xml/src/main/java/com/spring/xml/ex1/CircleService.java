package com.spring.xml.ex1;

public class CircleService {
	Circle c;
	public void drawCircle() {
		c.drawCircle();
	}
	public CircleService() {
		super();
	}
	public CircleService(Circle c) {
		super();
		this.c = c;
	}
	public Circle getC() {
		return c;
	}
	public void setC(Circle c) {
		this.c = c;
	}
	
}
