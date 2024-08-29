package gameModel;

public class GameData {

	private int attributeTotal;
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
	
	private int startingAttribute = 8;
	private final int FOUR_DICE = 4;
	private final int SIX_DICE = 6;
	private final int TEN_DICE = 10;
	private final int TWELVE_DICE = 12;
	private final int TWENTY_DICE = 20;
	
	private String[] dndClass = { "Barbarian", "Bard", "Cleric", "Druid",
								  "Fighter", "Monk", "Paladin", "Ranger",
								  "Rogue", "Sorcerer","Warlock", "Wizard",
								  "Artificer" };
	
	private String[] dndBackground = {
	};
	
	
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
		return FOUR_DICE;
	}

	public int getSIX_DICE() {
		return SIX_DICE;
	}

	public int getTEN_DICE() {
		return TEN_DICE;
	}

	public int getTWELVE_DICE() {
		return TWELVE_DICE;
	}

	public int getTWENTY_DICE() {
		return TWENTY_DICE;
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
}
