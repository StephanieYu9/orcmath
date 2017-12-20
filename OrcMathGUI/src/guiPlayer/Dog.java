package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Dog extends AnimatedComponent {
	
	ArrayList list =  new ArrayList<Dog>();
	String name; 
	String color;

	public Dog(String name, String color) {
		super(40, 40, 40, 32);
		
		this.name = name;
		this.color = color;
		
		addSequence("resources/dogSheet.png", 150, 0, 0, 40, 32, 10);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}

	public void update(Graphics2D g) {
		//g.setColor(Color.blue);
		//g.fillRect(0, 0, getWidth(), getHeight());
		super.update(g);
		
	}
	
	public String toString() {
		return name + ", " + color;
	}
	
}
