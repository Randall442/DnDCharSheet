package zDndVersionOne;

import gameController.GameController;
import gameModel.GameData;
import gameView.GameView;

public enum GameClient {
	INSTANCE;
	
	GameData gameData = new GameData();
	GameView gameWindow = new GameView(gameData);
	GameController gameController = new GameController(gameData, gameWindow);
}
