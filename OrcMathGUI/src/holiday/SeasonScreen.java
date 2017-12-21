package holiday;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SeasonScreen extends FullFunctionScreen {

	private TextArea greetingField;
	private TextArea nameField;
	
	public SeasonScreen(int width, int height) {
		super(width, height);
		
	}

	public void initAllObjects(List<Visible> viewObjects) {
		Button open = new Button(getWidth(), getHeight(),100,30,"Switch", new Action() {
			
			@Override
			public void act() {
				HolidayGUI.holiday.setScreen(HolidayGUI.screen2);
			}
		}); {
			viewObjects.add(open);
		}
		
		greetingField = new TextArea(40,80,200,30,"Season Greetings,");
		viewObjects.add(greetingField);
		nameField = new TextArea(800,900,200,30,"Mother");
		viewObjects.add(nameField);
	}

}
