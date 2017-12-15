package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogueMaker {

	private ArrayList<Dog> list;
	
	public CatalogueMaker() {
		list = new ArrayList<Dog>();
		list.add(new Dog("Pug", "black"));
		list.add(new Dog("Corgi", "brown"));
		list.add(new Dog("Pomeranian", "brown"));
		list.add(new Dog("Sheepdog", "white"));
		list.add(new Dog("Poodle", "white"));
	}

	public static void main(String[] args) {
		CatalogueMaker x = new CatalogueMaker();
		System.out.println(x.getCSVContent());
		Scanner n = new Scanner(System.in);

	}

	public void getUserinput() {
		
	}
	
	
	public String getCSVContent(){
		String data = "name, color \n";
		for(Dog d: list) {
			data += d + "\n";
		}
		return data;
	}
	
	public void addNewItem(String name, String color) {
		list.add(new Dog(name, color));
		System.out.println("Item successfully added.");
	}
	
}
