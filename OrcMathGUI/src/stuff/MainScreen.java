package stuff;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MainScreen extends FullFunctionScreen {

	private Button winButton;
	private Button loseButton;
	private TextArea text;
	public boolean buttonClick;
	
	public MainScreen(int width, int height) {
		super(width, height);
		buttonClick = false;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		winButton = new Button(100,100,100,50,"WIN",Color.GREEN, new Action() {
			
			@Override
			public void act() {
				buttonClick = true;
				text.setText("YOU WIN");
				text.update();
				buttonClicked();
			}
		});

		viewObjects.add(winButton);
		
		loseButton = new Button(100,200,100,50,"LOSE",Color.RED, new Action() {
			
			@Override
			public void act() {
				buttonClick = true;
				text.setText("YOU LOSE");
				text.update();
				buttonClicked();
			}
		});

		viewObjects.add(loseButton);
		
		text = new TextArea(400, 100, 100, 200, "");
		viewObjects.add(text);
		
		
	}
	
	public void buttonClicked() {
		if(buttonClick == true) {
			loseButton.setEnabled(false);
			winButton.setEnabled(false);
		}
	}

}
