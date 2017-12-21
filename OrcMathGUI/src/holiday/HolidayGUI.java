package holiday;

import guiTeacher.GUIApplication;
import myStuff.CatalogMakerGUI;
import myStuff.CatalogScreen;

public class HolidayGUI extends GUIApplication {
	
	public static HolidayGUI holiday;
	public static SeasonScreen screen1;
	public static GreetingScreen screen2;

	public HolidayGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		screen1 = new SeasonScreen(getWidth(),getHeight());
		screen2 = new GreetingScreen(getWidth(),getHeight());
		setScreen(screen1);
		setScreen(screen2);
	}

	public static void main(String[] args) {
		holiday = new HolidayGUI(1000,1000);
		Thread go = new Thread(holiday);
		go.start();
	}

}
