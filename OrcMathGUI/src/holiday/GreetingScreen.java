package holiday;

import java.util.List;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class GreetingScreen extends FullFunctionScreen {
	
	private TextField haikuField;
	
	public GreetingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		haikuField = new TextField(40,80,200,30,"","Title");
		viewObjects.add(haikuField);
	}

}
