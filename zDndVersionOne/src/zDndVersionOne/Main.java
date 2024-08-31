package zDndVersionOne;

public class Main {

	public static void main(String[] args) 
	{
		GameClient gameClient = GameClient.INSTANCE;
		gameClient.gameController.startGame();
	}

}
