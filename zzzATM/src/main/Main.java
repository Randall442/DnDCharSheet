package main;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		//creates an instance
		AppClient startApp = AppClient.INSTANCE;
		
		startApp.controller.atmWindow();
		startApp.database.getConnection();
		
	}

}
