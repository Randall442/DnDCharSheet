package gameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gameModel.GameData;
import gameView.CharacterWindow;
import gameView.GameView;

public class GameController implements ActionListener
{
	private GameData gameData;
	private GameView gameWindow;
	private CharacterWindow charWindow;
	
	public GameController(GameData gameData, GameView gameWindow)
	{
		this.gameData = gameData;
		this.gameWindow = gameWindow;
		
		charWindow = gameWindow.getCharWindow();
		
		addListeners();
		updateDndClass();
		updateDndBackground();
		updateDndRace();
		updateDndAlignment();
		updateDndLevel();
		
	}
	//not needed
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
		addListener(gameWindow.getCharWindow().getRollStatBtn(), this);
		
		for(int i = 0; i < 6; i++)
		{
			addListener(gameWindow.getCharWindow().getAddStat(i), this);
		}
		for(int i = 0; i < 6; i++)
		{
			addListener(gameWindow.getCharWindow().getSubStat(i), this);
		}
		
		
		
		
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
			gameWindow.getCharWindow().hideWindow();
			gameWindow.getGameWindow().showFrame();
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
		else if(source == gameWindow.getCharWindow().getRollStatBtn())
		{
			int total;
			if(gameData.getAttributeTotal() > 0)
			{
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset your stats?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION)
				{
					total = rollStatCalcTotal();
					
					gameData.setAttributeTotal(total);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(total));
					
				
					gameData.setAttributeStr(0);
					charWindow.updateLbl(0, 0);
					charWindow.updateModLbl(-5, 0);
					gameData.setAttributeDex(0);
					charWindow.updateLbl(0, 1);
					charWindow.updateModLbl(-5, 1);
					gameData.setAttributeCon(0);
					charWindow.updateLbl(0, 2);
					charWindow.updateModLbl(-5, 2);
					gameData.setAttributeIntel(0);
					charWindow.updateLbl(0, 3);
					charWindow.updateModLbl(-5, 3);
					gameData.setAttributeWis(0);
					charWindow.updateLbl(0, 4);
					charWindow.updateModLbl(-5, 4);
					gameData.setAttributeCha(0);
					charWindow.updateLbl(0, 5);
					charWindow.updateModLbl(-5, 5);
				}
				else if (confirm == JOptionPane.NO_OPTION)
				{
					return;
				}
				
				else {
					return;
				}
				
			}
			
			total = rollStatCalcTotal();
			
			gameData.setAttributeTotal(total);
			gameWindow.getCharWindow().updateStatLabel(String.valueOf(total));
			
		
			gameData.setAttributeStr(0);
			charWindow.updateLbl(0, 0);
			charWindow.updateModLbl(-5, 0);
			gameData.setAttributeDex(0);
			charWindow.updateLbl(0, 1);
			charWindow.updateModLbl(-5, 1);
			gameData.setAttributeCon(0);
			charWindow.updateLbl(0, 2);
			charWindow.updateModLbl(-5, 2);
			gameData.setAttributeIntel(0);
			charWindow.updateLbl(0, 3);
			charWindow.updateModLbl(-5, 3);
			gameData.setAttributeWis(0);
			charWindow.updateLbl(0, 4);
			charWindow.updateModLbl(-5, 4);
			gameData.setAttributeCha(0);
			charWindow.updateLbl(0, 5);
			charWindow.updateModLbl(-5, 5);
			
		}
		else if(source == gameWindow.getCharWindow().getAddStat(0))
		{
			int str = gameData.getAttributeStr();
			int total = gameData.getAttributeTotal();
			
			if(total == 0)
			{
				JOptionPane.showMessageDialog(null, "Please press the roll btn to roll for attribute points!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(str < 17 && total > 0)
			{
				if(str >= 13)
				{
					++str;
					gameData.setAttributeStr(str);
					gameWindow.getCharWindow().updateLbl(str, 0);
					
					int strMod = updateMod(str);
					gameData.setStrMod(strMod);
					gameWindow.getCharWindow().updateModLbl(strMod, 0);
					
					gameData.setAttributeTotal(total -= 2);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
					
				}
				else
				{
					++str;
					gameData.setAttributeStr(str);
					gameWindow.getCharWindow().updateLbl(str, 0);
					
					int strMod = updateMod(str);
					gameData.setStrMod(strMod);
					gameWindow.getCharWindow().updateModLbl(strMod, 0);
					
					gameData.setAttributeTotal(total -= 1);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
				}
				
			}
			
			
		}
		else if(source == gameWindow.getCharWindow().getAddStat(1))
		{
			int dex = gameData.getAttributeDex();
			int total = gameData.getAttributeTotal();
			
			if(total == 0)
			{
				JOptionPane.showMessageDialog(null, "Please press the roll btn to roll for attribute points!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			if(dex < 17 && total > 0)
			{
				if(dex >= 13)
				{
					++dex;
					gameData.setAttributeDex(dex);
					gameWindow.getCharWindow().updateLbl(dex, 1);
					
					int dexMod = updateMod(dex);
					gameData.setDexMod(dexMod);
					gameWindow.getCharWindow().updateModLbl(dexMod, 1);
					
					gameData.setAttributeTotal(total -= 2);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
				}
				else
				{
					++dex;
					gameData.setAttributeDex(dex);
					gameWindow.getCharWindow().updateLbl(dex, 1);
					
					int dexMod = updateMod(dex);
					gameData.setDexMod(dexMod);
					gameWindow.getCharWindow().updateModLbl(dexMod, 1);
					
					gameData.setAttributeTotal(total -= 1);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
				}
			
			}
		}
		else if(source == gameWindow.getCharWindow().getAddStat(2))
		{
			int con = gameData.getAttributeCon();
			int total = gameData.getAttributeTotal();
			
			if(total == 0)
			{
				JOptionPane.showMessageDialog(null, "Please press the roll btn to roll for attribute points!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if(con < 17 && total > 0)
			{
				if(con >= 13)
				{
					++con;
					gameData.setAttributeCon(con);
					gameWindow.getCharWindow().updateLbl(con, 2);
					
					int conMod = updateMod(con);
					gameData.setStrMod(conMod);
					gameWindow.getCharWindow().updateModLbl(conMod, 2);
					
					gameData.setAttributeTotal(total -= 2);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
				}
				else
				{
					++con;
					gameData.setAttributeCon(con);
					gameWindow.getCharWindow().updateLbl(con, 2);
					
					int conMod = updateMod(con);
					gameData.setStrMod(conMod);
					gameWindow.getCharWindow().updateModLbl(conMod, 2);
					
					gameData.setAttributeTotal(total -= 1);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
				}
				
			}
		}
		else if(source == gameWindow.getCharWindow().getAddStat(3))
		{
			int intel = gameData.getAttributeIntel();
			int total = gameData.getAttributeTotal();
			
			if(total == 0)
			{
				JOptionPane.showMessageDialog(null, "Please press the roll btn to roll for attribute points!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if(intel < 17 && total > 0)
			{
				if(intel >= 13)
				{
					++intel;
					gameData.setAttributeIntel(intel);
					gameWindow.getCharWindow().updateLbl(intel, 3);
					
					int intelMod = updateMod(intel);
					gameData.setIntelMod(intelMod);
					gameWindow.getCharWindow().updateModLbl(intelMod, 3);
					
					gameData.setAttributeTotal(total -= 2);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
				}
				else
				{
					++intel;
					gameData.setAttributeIntel(intel);
					gameWindow.getCharWindow().updateLbl(intel, 3);
					
					int intelMod = updateMod(intel);
					gameData.setIntelMod(intelMod);
					gameWindow.getCharWindow().updateModLbl(intelMod, 3);
					
					gameData.setAttributeTotal(total -= 1);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
				}
				
			}
		}
		else if(source == gameWindow.getCharWindow().getAddStat(4))
		{
			int wis = gameData.getAttributeWis();
			int total = gameData.getAttributeTotal();
			
			if(total == 0)
			{
				JOptionPane.showMessageDialog(null, "Please press the roll btn to roll for attribute points!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if(wis < 17 && total > 0)
			{
				if(wis >= 13)
				{
					++wis;
					gameData.setAttributeWis(wis);
					gameWindow.getCharWindow().updateLbl(wis, 4);
					
					int wisMod = updateMod(wis);
					gameData.setWisMod(wisMod);
					gameWindow.getCharWindow().updateModLbl(wisMod, 4);
					
					gameData.setAttributeTotal(total -= 2);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
				}
				else 
				{
					++wis;
					gameData.setAttributeWis(wis);
					gameWindow.getCharWindow().updateLbl(wis, 4);
					
					int wisMod = updateMod(wis);
					gameData.setWisMod(wisMod);
					gameWindow.getCharWindow().updateModLbl(wisMod, 4);
					
					gameData.setAttributeTotal(total -= 1);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
				}
				
			}
		}
		
		else if(source == gameWindow.getCharWindow().getAddStat(5))
		{
			int cha = gameData.getAttributeCha();
			int total = gameData.getAttributeTotal();
			System.out.println("cha button");
			if(total == 0)
			{
				JOptionPane.showMessageDialog(null, "Please press the roll btn to roll for attribute points!", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if(cha < 15 && total > 0)
			{
				if(cha >= 13)
				{
					++cha;
					gameData.setAttributeCha(cha);
					gameWindow.getCharWindow().updateLbl(cha, 5);
					
					int chaMod = updateMod(cha);
					gameData.setChaMod(chaMod);
					gameWindow.getCharWindow().updateModLbl(chaMod, 5);
					
					gameData.setAttributeTotal(total -= 2);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
				}
				else 
				{
					++cha;
					gameData.setAttributeCha(cha);
					gameWindow.getCharWindow().updateLbl(cha, 5);
					
					int chaMod = updateMod(cha);
					gameData.setChaMod(chaMod);
					gameWindow.getCharWindow().updateModLbl(chaMod, 5);
					
					gameData.setAttributeTotal(total -= 1);
					gameWindow.getCharWindow().updateStatLabel(String.valueOf(gameData.getAttributeTotal()).toString());
				}
				
			}
		}
		// adds all the subtraction from stat buttons
	
		else if(source == gameWindow.getCharWindow().getSubStat(0))
		{
			int str = gameData.getAttributeStr();
			int total = gameData.getAttributeTotal();
			
			
			if(str > 0)
			{
				--str;
				gameData.setAttributeStr(str);
				gameWindow.getCharWindow().updateLbl(str, 0);
				
				int strMod = updateMod(str);
				gameData.setStrMod(strMod);
				gameWindow.getCharWindow().updateModLbl(strMod, 0);
				
				gameData.setAttributeTotal(total += 1);
				gameWindow.getCharWindow().updateStatLabel(String.valueOf(total).toString());
			}
		}
		else if(source == gameWindow.getCharWindow().getSubStat(1))
		{
			int dex = gameData.getAttributeDex();
			int total = gameData.getAttributeTotal();
			
			if(dex > 0)
			{
				--dex;
				gameData.setAttributeDex(dex);
				gameWindow.getCharWindow().updateLbl(dex, 1);
				
				int dexMod = updateMod(dex);
				gameData.setDexMod(dexMod);
				gameWindow.getCharWindow().updateModLbl(dexMod, 1);
				
				gameData.setAttributeTotal(total += 1);
				gameWindow.getCharWindow().updateStatLabel(String.valueOf(total).toString());
			}
		}
		else if(source == gameWindow.getCharWindow().getSubStat(2))
		{
			int con = gameData.getAttributeCon();
			int total = gameData.getAttributeTotal();
			
			if(con > 0)
			{
				--con;
				gameData.setAttributeCon(con);
				gameWindow.getCharWindow().updateLbl(con, 2);
				
				int conMod = updateMod(con);
				gameData.setConMod(conMod);
				gameWindow.getCharWindow().updateModLbl(conMod, 2);
				
				gameData.setAttributeTotal(total += 1);
				gameWindow.getCharWindow().updateStatLabel(String.valueOf(total).toString());
				
			}
		}
		else if(source == gameWindow.getCharWindow().getSubStat(3))
		{
			int intel = gameData.getAttributeIntel();
			int total = gameData.getAttributeTotal();
			
			if(intel > 0)
			{
				--intel;
				gameData.setAttributeIntel(intel);
				gameWindow.getCharWindow().updateLbl(intel, 3);
				
				int intelMod = updateMod(intel);
				gameData.setIntelMod(intelMod);
				gameWindow.getCharWindow().updateModLbl(intelMod, 3);
				
				gameData.setAttributeTotal(total += 1);
				gameWindow.getCharWindow().updateStatLabel(String.valueOf(total).toString());
			}
		}
		else if(source == gameWindow.getCharWindow().getSubStat(4))
		{
			int wis = gameData.getAttributeWis();
			int total = gameData.getAttributeTotal();
			
			if(wis > 0)
			{
				--wis;
				gameData.setAttributeWis(wis);
				gameWindow.getCharWindow().updateLbl(wis, 4);
				
				int wisMod = updateMod(wis);
				gameData.setWisMod(wisMod);
				gameWindow.getCharWindow().updateModLbl(wisMod, 4);
				
				gameData.setAttributeTotal(total += 1);
				gameWindow.getCharWindow().updateStatLabel(String.valueOf(total).toString());
			}
		}
		else if(source == gameWindow.getCharWindow().getSubStat(5))
		{
			int cha = gameData.getAttributeCha();
			int total = gameData.getAttributeTotal();
			
			if(cha > 0)
			{
				--cha;
				gameData.setAttributeCha(cha);
				gameWindow.getCharWindow().updateLbl(cha, 5);
				
				int chaMod = updateMod(cha);
				gameData.setChaMod(chaMod);
				gameWindow.getCharWindow().updateModLbl(chaMod, 5);
				
				gameData.setAttributeTotal(total += 1);
				gameWindow.getCharWindow().updateStatLabel(String.valueOf(total).toString());
			}
		}
		
	}
	
	private void updateDndClass()
	{	
		String[] dndClassArray = gameData.getDndClassArray();
		gameWindow.getCharWindow().setClassArray(dndClassArray);
		
	}
	//dndClass, playerBackground, playerRace, playerAlignment, playerLevel;
	private void updateDndBackground ()
	{
		String[] dndBackgroundArray = gameData.getDndBackground();
		gameWindow.getCharWindow().setDndBackground(dndBackgroundArray);
	}
	
	private void updateDndRace()
	{
		String[] dndRaceArray = gameData.getDndRace();
		gameWindow.getCharWindow().setDndRace(dndRaceArray);
	}
	
	private void updateDndAlignment()
	{
		String[] dndAlignmentArray = gameData.getDndAlignment();
		gameWindow.getCharWindow().setDndAlignment(dndAlignmentArray);
	}
	private void updateDndLevel()
	{
		String[] dndLevelArray = gameData.getDndLevel();
		gameWindow.getCharWindow().setDndLevel(dndLevelArray);
	}
	private int updateMod(int stat)
	{
		int mod = (stat - 10) / 2;
	
		return mod;
	}
	
	private int rollStatCalcTotal()
	{
		int[] roll = new int[4];
		int lowestRoll = Integer.MAX_VALUE;
		int total = 0;
		for(int i = 0; i < 4; i++) {
			roll[i] = gameData.getSIX_DICE();
		}
		
		
		for(int i = 1; i < roll.length; i++)
		{
			if(roll[i] < lowestRoll)
			{
				lowestRoll = roll[i];
			}
		}
		
		for(int i = 0; i < roll.length; i++)
		{
			total += roll[i];
		}
		
		total -= lowestRoll;
		total += total * 6;
		return total;
	}
	
}
