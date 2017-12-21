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

	private TextField titleField;
	private TextField authorField;
	private TextField pageField;
	private Button addButton;
	private CatalogMaker catalog;
	private TextArea textarea;
	private TextArea errorarea;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		
	}

	public void initAllObjects(List<Visible> viewObjects) {
		catalog = new CatalogMaker();
		textarea = new TextArea(500,20,300,200, "Box of text");
		errorarea = new TextArea(500,500,200,50, "You can not add an empty field.");
		titleField = new TextField(40,80,200,30,"","Title");
		authorField = new TextField(40,140,200,30,"","Author");
		pageField = new TextField(40,200,200,30,"","Pages");
		pageField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(titleField);
		viewObjects.add(authorField);
		viewObjects.add(pageField);
		viewObjects.add(textarea);
		viewObjects.add(errorarea);
		errorarea.setVisible(false);
		addButton = new Button(160,200,100,100, "Add", new Action() {
			
			public void act() {
				addButtonClicked();
			}
		});
		viewObjects.add(addButton);
		
	}

	protected void addButtonClicked() {
		if(titleField.getText().equals("") || authorField.getText().equals("") || pageField.getText.equals("")){
			errorarea.setText();
			errorarea.setVisible(true);
		}else{
			Book b = new Book(titleField.getText(), authorField.getText(), Integer.parseInt(pageField.getText()));
			String s = textarea.getText() + b + "\n"; 		
			catalog.addBook(b);
		
			titleField.setText(" ");
			authorField.setText(" ");
			pageField.setText(" ");
			
			errorarea.setVisible(false);
		}
	}
}
