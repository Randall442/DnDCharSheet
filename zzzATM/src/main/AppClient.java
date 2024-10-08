package main;

import controllers.AtmController;
import models.AtmData;
import models.Database;
import views.AtmWindow;
import views.AtmWindow;

public enum AppClient {
	INSTANCE;
	
	
	
	AtmWindow window = new AtmWindow();
	AtmData data = new AtmData();
	Database database = new Database(window);
	AtmController controller = new AtmController(window, data);
	
}
