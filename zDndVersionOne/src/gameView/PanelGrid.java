package gameView;

import javax.swing.JPanel;

public class PanelGrid {
	
	JPanel[][] gameTiles = new JPanel[8][8];
	JPanel tile = new JPanel();
	int rows = 8;
	int cols = 8;
	
	
	public PanelGrid()
	{
		for(int i = 0; i < rows; i ++)
		{
			for(int j = 0; j < cols; j++)
			{
				gameTiles[i][j] = tile;
			}
		}
	}
	
	public void createTile() 
	{
		
	}
}
