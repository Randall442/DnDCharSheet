package controllers;

import java.util.List;

import models.Database;
import views.MainWindow;

public class InfoController {
	
	private Database db;
	private MainWindow window;
	
	public InfoController(Database db, MainWindow window)
	{
		this.db = db;
		this.window = window;
		
		populateAlignments();
		populateBackgrounds();
		populateRaces();
		populatePlayerClasses();
	}
	
	private void populatePlayerClasses() {
		List<String> playerClasses = db.getAllClasses();
		window.getInfoPanel().setPlayerClassSelect(playerClasses);
	}

	private void populateRaces() {
		List<String> races = db.getAllRaces();
		window.getInfoPanel().setPlayerRaceSelect(races);
	}

	private void populateBackgrounds() {
		List<String> backgrounds = db.getAllBackgrounds();
		window.getInfoPanel().setPlayerBackgroundSelect(backgrounds);
		
	}

	public void populateAlignments()
	{
		List<String> alignments = db.getAllALignments();
		window.getInfoPanel().setPlayerAlignmentSelect(alignments);
	}
	
	
}
