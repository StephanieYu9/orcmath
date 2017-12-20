package myStuff;

import java.util.List;

import guiPlayer.Book;
import guiPlayer.CatalogMaker;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField titleField1;
	private TextField titleField2;
	private TextField titleField3;
	private Button addButton;
	private CatalogMaker catalog;
	private TextArea textarea;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		
	}

	public void initAllObjects(List<Visible> viewObjects) {
		catalog = new CatalogMaker();
		textarea = new TextArea(500,20,300,200, "Box of text");
		titleField1 = new TextField(40,80,200,30,"Enter text here","Title");
		titleField2 = new TextField(40,140,200,30,"Enter text here","Author");
		titleField3 = new TextField(40,200,200,30,"Enter text here","Pages");
		viewObjects.add(titleField1);
		viewObjects.add(titleField2);
		viewObjects.add(titleField3);
		viewObjects.add(textarea);
		addButton = new Button(160,200,100,100, "Add", new Action() {
			
			public void act() {
				addButtonClicked();
			}
		});
		viewObjects.add(addButton);
		
	}

	protected void addButtonClicked() {
		Book b = new Book(titleField1.getText(), titleField2.getText(), Integer.parseInt(titleField3.getText()));
		String s = textarea.getText() + b + "\n"; 		
		catalog.addBook(b);
		
		
		
		
	}

}
