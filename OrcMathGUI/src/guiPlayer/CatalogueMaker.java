package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogueMaker {

	private ArrayList<Dog> list;
	
	public CatalogueMaker() {
		CatalogMaker maker = new CatalogMaker();
		in = new Scanner(System.in);
		maker.menu();

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
		System.out.println("Enter a name.");
		String name = n.nextLine();
		System.out.println("Enter a color.");
		String color = n.nextLine();
	}
	
	private void add() {
		String name = null;
		String breed = null;
		displayMessage("Please enter a name");
		name = getStringInput();
		displayMessage("Please enter a breed");
		breed = getStringInput();
		addDog(new Dog(name, breed));
	}
	
	private void addDog(Dog b){
		list.add(b);
	}
	
	private static String getStringInput(){
		String text = in.nextLine();
		while(text.isEmpty()){
			displayMessage("You must enter a non-empty String.");
			text = in.nextLine();
		}
		return text;
	}
	
	private static void displayMessage(String message){
		System.out.println(message);
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