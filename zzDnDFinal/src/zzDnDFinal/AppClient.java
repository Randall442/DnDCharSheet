package zzDnDFinal;

import controllers.AttributeController;
import controllers.InfoController;
import controllers.MainController;
import models.Database;
import views.MainWindow;

public enum AppClient {
	INSTANCE;
	
	Database db = new Database();
	MainWindow window = new MainWindow();
	
	MainController controller = new MainController(db, window);
	AttributeController statController = new AttributeController(db, window);
	InfoController infoController = new InfoController(db, window);
	
}
