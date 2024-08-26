package gameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gameModel.GameData;
import gameView.GameWindow;

public class GameController implements ActionListener
{
	private GameData gameData;
	private GameWindow gameWindow;
	public GameController(GameData gameData, GameWindow gameWindow)
	{
		this.gameData = gameData;
		this.gameWindow = gameWindow;
		
		
		
		addListeners();
		
	}
	
	public void startGame()
	{
		gameWindow.getWindow().showFrame();
	}
	
	public void addListener(JButton button, ActionListener listener)
	{
		button.addActionListener(listener);
	}
	
	public void addListeners()
	{
		addListener(gameWindow.getWindow().getStartBtn(), this);
		addListener(gameWindow.getWindow().getLoadBtn(), this);
		addListener(gameWindow.getWindow().getOptionBtn(), this);
		addListener(gameWindow.getWindow().getExitBtn(), this);
		
		addListener(gameWindow.getCharWindow().getStartGameBtn(), this);
		addListener(gameWindow.getCharWindow().getLoadBtn(),this);
		addListener(gameWindow.getCharWindow().getSaveBtn(), this);
		addListener(gameWindow.getCharWindow().getBackBtn(), this);
		
		addListener(gameWindow.getCharWindow().getAddStat(0), this);
		addListener(gameWindow.getCharWindow().getAddStat(1), this);
		addListener(gameWindow.getCharWindow().getAddStat(2), this);
		addListener(gameWindow.getCharWindow().getAddStat(3), this);
		addListener(gameWindow.getCharWindow().getAddStat(4), this);
		addListener(gameWindow.getCharWindow().getAddStat(5), this);
		
		addListener(gameWindow.getCharWindow().getSubStat(0), this);
		addListener(gameWindow.getCharWindow().getSubStat(1), this);
		addListener(gameWindow.getCharWindow().getSubStat(2), this);
		addListener(gameWindow.getCharWindow().getSubStat(3), this);
		addListener(gameWindow.getCharWindow().getSubStat(4), this);
		addListener(gameWindow.getCharWindow().getSubStat(5), this);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == gameWindow.getWindow().getStartBtn())
		{
			gameWindow.getWindow().hideFrame();
			gameWindow.getCharWindow().showWindow();
		}
		else if(source == gameWindow.getWindow().getLoadBtn())
		{
			System.out.println("Load Game");
		}
		else if(source == gameWindow.getWindow().getOptionBtn())
		{
			System.out.println("Options");
		}
		else if(source == gameWindow.getWindow().getExitBtn())
		{
			System.exit(0);
		}
		
		//adds all the addition to stat buttons;
		
		else if(source == gameWindow.getCharWindow().getStartGameBtn())
		{
			System.out.println("Hello");
		}
		else if(source == gameWindow.getCharWindow().getLoadBtn()) {
			System.out.println("Load Character");
		}
		else if(source == gameWindow.getCharWindow().getSaveBtn()) {
			System.out.println("Save Character");
		}
		else if(source == gameWindow.getCharWindow().getBackBtn())
		{
			System.out.println("Back");
		}
		else if(source == gameWindow.getCharWindow().getAddStat(0))
		{
			int str = gameData.getAttributeStr();
			
			if(str < 15)
			{
				++str;
				gameData.setAttributeStr(str);
				gameWindow.getCharWindow().updateLbl(str, 0);
				
				
				int strMod = updateMod(str);
				gameData.setStrMod(strMod);
				gameWindow.getCharWindow().updateModLbl(strMod, 0);
				
			}
			
			
		}
		else if(source == gameWindow.getCharWindow().getAddStat(1))
		{
			int dex = gameData.getAttributeDex();
			
			if(dex < 15)
			{
				++dex;
				gameData.setAttributeDex(dex);
				gameWindow.getCharWindow().updateLbl(dex, 1);
				
			}
		}
		else if(source == gameWindow.getCharWindow().getAddStat(2))
		{
			int con = gameData.getAttributeCon();
			if(con < 15)
			{
				++con;
				gameData.setAttributeCon(con);
				gameWindow.getCharWindow().updateLbl(con, 2);
			}
		}
		else if(source == gameWindow.getCharWindow().getAddStat(3))
		{
			int intel = gameData.getAttributeIntel();
			if(intel < 15)
			{
				++intel;
				gameData.setAttributeIntel(intel);
				gameWindow.getCharWindow().updateLbl(intel, 3);
			}
		}
		else if(source == gameWindow.getCharWindow().getAddStat(4))
		{
			int wis = gameData.getAttributeWis();
			if(wis < 15)
			{
				++wis;
				gameData.setAttributeWis(wis);
				gameWindow.getCharWindow().updateLbl(wis, 4);
			}
		}
		else if(source == gameWindow.getCharWindow().getAddStat(5))
		{
			int cha = gameData.getAttributeCha();
			if(cha < 15)
			{
				++cha;
				gameData.setAttributeCha(cha);
				gameWindow.getCharWindow().updateLbl(cha, 5);
			}
		}
		// adds all the subtraction from stat buttons
	
		else if(source == gameWindow.getCharWindow().getSubStat(0))
		{
			int str = gameData.getAttributeStr();
			
			if(str > 8)
			{
				--str;
				gameData.setAttributeStr(str);
				gameWindow.getCharWindow().updateLbl(str, 0);
				
				int strMod = updateMod(str);
				gameData.setStrMod(strMod);
				gameWindow.getCharWindow().updateModLbl(strMod, 0);
			}
		}
		else if(source == gameWindow.getCharWindow().getSubStat(1))
		{
			int dex = gameData.getAttributeDex();
			
			if(dex > 8)
			{
				--dex;
				gameData.setAttributeDex(dex);
				gameWindow.getCharWindow().updateLbl(dex, 1);
			}
		}
		else if(source == gameWindow.getCharWindow().getSubStat(2))
		{
			int con = gameData.getAttributeCon();
			
			if(con > 8)
			{
				--con;
				gameData.setAttributeCon(con);
				gameWindow.getCharWindow().updateLbl(con, 2);
			}
		}
		else if(source == gameWindow.getCharWindow().getSubStat(3))
		{
			int intel = gameData.getAttributeIntel();
			
			if(intel > 8)
			{
				--intel;
				gameData.setAttributeIntel(intel);
				gameWindow.getCharWindow().updateLbl(intel, 3);
			}
		}
		else if(source == gameWindow.getCharWindow().getSubStat(4))
		{
			int wis = gameData.getAttributeWis();
			
			if(wis > 8)
			{
				--wis;
				gameData.setAttributeWis(wis);
				gameWindow.getCharWindow().updateLbl(wis, 4);
			}
		}
		else if(source == gameWindow.getCharWindow().getSubStat(5))
		{
			int cha = gameData.getAttributeCha();
			
			if(cha > 8)
			{
				--cha;
				gameData.setAttributeCha(cha);
				gameWindow.getCharWindow().updateLbl(cha, 5);
			}
		}
		
	}
	
	private int updateMod(int stat)
	{
		int mod = (stat - 10) / 2;
	
		return mod;
	}
	
}
