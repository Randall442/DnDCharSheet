package gameModel;

import java.util.Random;

public class GameData {

	
	private int attributeStr;
	private int attributeDex;
	private int attributeCon;
	private int attributeIntel;
	private int attributeWis;
	private int attributeCha;
	
	private int strMod;
	private int dexMod;
	private int conMod;
	private int intelMod;
	private int wisMod;
	private int chaMod;
	
	private int attributeTotal = 0;
	private int startingAttribute = 0;
	
	
	private final int FOUR_DICE = 4;
	private final int SIX_DICE = 6;
	private final int TEN_DICE = 10;
	private final int TWELVE_DICE = 12;
	private final int TWENTY_DICE = 20;
	
	private int currentTile;
	private int rows;
	private int cols;
	
	private String[] dndClass = { "Barbarian", "Bard", "Cleric", "Druid",
								  "Fighter", "Monk", "Paladin", "Ranger",
								  "Rogue", "Sorcerer","Warlock", "Wizard",
								  "Artificer" };
	
	private String[] dndBackground = { "Acolyte", "Charlatan", "Criminal", 
									   "Entertainer", "Folk Hero", "Guild Artisan", 
									   "Noble", "Outlander", "Sage", "Soldier", 
									   "Urchin"};

	//dndClass, playerBackground, playerRace, playerAlignment, playerLevel;
	private String[] dndRace = { "Human", "Elf", "Drow", "Half-Elf", "Half-Orc", 
								 "Halfling", "Dwarf", "Gnome", "Tiefling", "Githyanki",
								 "Dragonborn"};
	
	private String[] dndAlignment = { "Lawful Good", "Neutral Good", "Chaotic Good",
									  "Lawful Neutral", "True Neutral", "Chaotic Neutral",
									  "Lawful Evil", "Neutral Evil", "Chaotic Evil",};
	
	private String[] dndLevel = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	public GameData()
	{
		this.setAttributeStr(attributeStr + startingAttribute);
		this.setAttributeDex(attributeDex + startingAttribute);
		this.setAttributeCon(attributeCon + startingAttribute);
		this.setAttributeIntel(attributeIntel + startingAttribute);
		this.setAttributeWis(attributeWis + startingAttribute);
		this.setAttributeCha(attributeCha + startingAttribute);
	}

	public int getAttributeTotal() {
		return attributeTotal;
	}

	public void setAttributeTotal(int attributeTotal) {
		this.attributeTotal = attributeTotal;
	}

	public int getAttributeStr() {
		return attributeStr;
	}

	public void setAttributeStr(int attributeStr) {
		this.attributeStr = attributeStr;
	}

	public int getAttributeDex() {
		return attributeDex;
	}

	public void setAttributeDex(int attributeDex) {
		this.attributeDex = attributeDex;
	}

	public int getAttributeCon() {
		return attributeCon;
	}

	public void setAttributeCon(int attributeCon) {
		this.attributeCon = attributeCon;
	}

	public int getAttributeIntel() {
		return attributeIntel;
	}

	public void setAttributeIntel(int attributeIntel) {
		this.attributeIntel = attributeIntel;
	}

	public int getAttributeWis() {
		return attributeWis;
	}

	public void setAttributeWis(int attributeWis) {
		this.attributeWis = attributeWis;
	}

	public int getAttributeCha() {
		return attributeCha;
	}

	public void setAttributeCha(int attributeCha) {
		this.attributeCha = attributeCha;
	}

	
	public int getFOUR_DICE() {
		Random rand = new Random();
		int fourDice = rand.nextInt(1, FOUR_DICE);
		return fourDice;
	}

	public int getSIX_DICE() {
		Random rand = new Random();
		int sixDice = rand.nextInt(1, SIX_DICE);
		return sixDice;
	}

	public int getTEN_DICE() {
		Random rand = new Random();
		int tenDice = rand.nextInt(1, TEN_DICE);
		return tenDice;
	}

	public int getTWELVE_DICE() {
		Random rand = new Random();
		int twelveDice = rand.nextInt(1, TWELVE_DICE);
		return twelveDice;
	}

	public int getTWENTY_DICE() {
		Random rand = new Random();
		int twentyDice = rand.nextInt(1, TWENTY_DICE);
		return twentyDice;
	}

	public int getStartingAttribute() {
		return startingAttribute;
	}

	public void setStartingAttribute(int startingAttribute) {
		this.startingAttribute = startingAttribute;
	}

	public int getStrMod() {
		return strMod;
	}

	public void setStrMod(int strMod) {
		this.strMod = strMod;
	}

	public int getDexMod() {
		return dexMod;
	}

	public void setDexMod(int dexMod) {
		this.dexMod = dexMod;
	}

	public int getConMod() {
		return conMod;
	}

	public void setConMod(int conMod) {
		this.conMod = conMod;
	}

	public int getIntelMod() {
		return intelMod;
	}

	public void setIntelMod(int intelMod) {
		this.intelMod = intelMod;
	}

	public int getWisMod() {
		return wisMod;
	}

	public void setWisMod(int wisMod) {
		this.wisMod = wisMod;
	}

	public int getChaMod() {
		return chaMod;
	}

	public void setChaMod(int chaMod) {
		this.chaMod = chaMod;
	}
	
	public String[] getDndClassArray()
	{
		return dndClass;
	}

	public String[] getDndBackground() 
	{
		return dndBackground;
	}
	
	public String[] getDndRace()
	{
		return dndRace;
	}
	public String[] getDndAlignment()
	{
		return dndAlignment;
	}
	public String[] getDndLevel()
	{
		return dndLevel;
	}

	public int getCurrentTile() {
		return currentTile;
	}

	public void setCurrentTile(int currentTile) {
		this.currentTile = currentTile;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}
}