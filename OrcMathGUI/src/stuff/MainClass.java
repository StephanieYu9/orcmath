package stuff;

import guiTeacher.GUIApplication;

public class MainClass extends GUIApplication {

	public MainClass(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		MainScreen screen = new MainScreen(getWidth(), getHeight());
		setScreen(screen);

	}

	public static void main(String[] args) {
		MainClass window = new MainClass(800,800);
		Thread go = new Thread(window);
		go.start();
	}

}
