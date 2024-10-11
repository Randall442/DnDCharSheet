package zzDnDFinal;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		AppClient app = AppClient.INSTANCE;
		app.controller.getWindow();

		try {
			app.db.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
