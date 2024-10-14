package zzDnDFinal;

import controllers.AttributeController;
import controllers.InfoController;
import controllers.MainController;
import controllers.SaveLoadController;
import models.Database;
import models.ModelLogic;
import views.MainWindow;

public enum AppClient {
	INSTANCE;
	
	Database db = new Database();
	ModelLogic logic = new ModelLogic();
	MainWindow window = new MainWindow();
	
	
	MainController controller = new MainController(db, window, logic);
	AttributeController statController = new AttributeController(db, window, logic);
	InfoController infoController = new InfoController(db, window, logic);
	SaveLoadController saveLoadController = new SaveLoadController(db, window, logic);
	
}
