package zDndVersionOne;

import gameController.GameController;
import gameModel.GameData;
import gameView.GameWindow;

public enum GameClient {
	INSTANCE;
	
	GameData gameData = new GameData();
	GameWindow gameWindow = new GameWindow(gameData);
	GameController gameController = new GameController(gameData, gameWindow);
}
