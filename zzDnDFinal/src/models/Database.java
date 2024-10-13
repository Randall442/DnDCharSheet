package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Database 
{
	private String url = "jdbc:sqlite:./DnDB.db";
	private List<String> alignments;
	private List<String> backgrounds;
	private List<String> races;
	private List<String> playerClasses;
	private List<String> charNames;
	
	 private String name;
	 private String className;
	 private String alignment;
	 private String background;
	 private String race;
	 private int strength;
	 private int dexterity;
	 private int constitution;
	 private int intelligence;
	 private int wisdom;
	 private int charisma;
	
	public Database()
	{
		
	}
	
	public Connection getConnection() throws SQLException
	{
		Connection conn = null;
		try 
		{
			conn = DriverManager.getConnection(url);
			System.out.println("Connection Established");
		}
		catch (SQLException e)
		{
			 System.out.println(e.getMessage());
		     throw e;
		}
		
		return conn;
	}
	
	public List<String> getAllALignments()
	{
		alignments = new ArrayList<>();
		
		String query = "Select alignmentName From Alignment";
		
		 try (Connection conn = this.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	           
	            while (rs.next()) {
	                String alignment = rs.getString("alignmentName");
	                alignments.add(alignment); 
	            }
	            System.out.println(rs);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return alignments;
	}
	
	
	public List<String> getAllBackgrounds()
	{
		backgrounds = new ArrayList<>();
		
		String query = "Select BackgroundName From Background";
		
		 try (Connection conn = this.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	           
	            while (rs.next()) {
	                String background = rs.getString("BackgroundName");
	                backgrounds.add(background); 
	            }
	            System.out.println(rs);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return backgrounds;
	}
	
	
	public List<String> getAllRaces()
	{
		races = new ArrayList<>();
		
		String query = "Select RaceName From Race";
		
		 try (Connection conn = this.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	           
	            while (rs.next()) {
	                String race = rs.getString("RaceName");
	                races.add(race); 
	            }
	            System.out.println(rs);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return races;
	}
	
	
	public List<String> getAllClasses()
	{
		playerClasses = new ArrayList<>();
		
		String query = "Select ClassName From Class";
		
		 try (Connection conn = this.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	           
	            while (rs.next()) {
	                String playerClass = rs.getString("ClassName");
	                playerClasses.add(playerClass); 
	            }
	            System.out.println(rs);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return playerClasses;
	}
	
	
	public void createCharacter(String name, int level, int backgroundID, int raceID, int alignmentID, int classID, 
            int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, 
            int hitPoints, int armorClass, int speed, int initiative)
	{
		String sql = "INSERT INTO Character (Name, Level, BackgroundID, RaceID, AlignmentID, ClassID, "
				+ "Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma, HitPoints, ArmorClass, "
				+ "Speed, Initiative) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

     try (Connection conn = this.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(sql)) {

         
         pstmt.setString(1, name);         
         pstmt.setInt(2, level);           
         pstmt.setInt(3, backgroundID);    
         pstmt.setInt(4, raceID);         
         pstmt.setInt(5, alignmentID);     
         pstmt.setInt(6, classID);         
         pstmt.setInt(7, strength);        
         pstmt.setInt(8, dexterity);      
         pstmt.setInt(9, constitution);   
         pstmt.setInt(10, intelligence);   
         pstmt.setInt(11, wisdom);         
         pstmt.setInt(12, charisma);       
         pstmt.setInt(13, hitPoints);      
         pstmt.setInt(14, armorClass);     
         pstmt.setInt(15, speed);          
         pstmt.setInt(16, initiative);     
    
         pstmt.executeUpdate();
         System.out.println("Character inserted successfully");

     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
	}
	
	public List<String> getCharacterNames() {
		charNames = new ArrayList<>();
		
		String query = "Select name From Character";
		
		 try (Connection conn = this.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	           
	            while (rs.next()) {
	                String name = rs.getString("Name");
	                races.add(name); 
	            }
	            System.out.println(rs);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return charNames;
    }

	public void getCharInfo(int num)
	{
		String sql = "Select Name, classname, alignmentname, backgroundname, racename, strength, dexterity, "
				+ "constitution, intelligence, wisdom, charisma From Character "
				+ "inner join alignment on character.alignmentid = alignment.alignmentid "
				+ "inner join background on character.backgroundid = background.backgroundid "
				+ "inner join race on character.raceid = race.raceid "
				+ "inner join class on character.classid = class.classid "
				+ "WHERE CharacterID = ?";
		
     try (Connection conn = this.getConnection();
          PreparedStatement stmt = conn.prepareStatement(sql)) {

         
         stmt.setInt(1, num);         
           
         ResultSet rs = stmt.executeQuery();
         
         if(rs.next())
         {
        	setName(rs.getString("Name"));
            setClassName(rs.getString("classname"));
            setAlignment(rs.getString("alignmentname"));
            setBackground(rs.getString("backgroundname"));
            setRace(rs.getString("racename"));
            setStrength(rs.getInt("strength"));
            setDexterity(rs.getInt("dexterity"));
            setConstitution(rs.getInt("constitution"));
            setIntelligence(rs.getInt("intelligence"));
            setWisdom(rs.getInt("wisdom"));
            setCharisma(rs.getInt("charisma"));
         }
        
         System.out.println("Character loaded successfully");

     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
	}
	
	public String getOneName(int id)
	{
		String name = null;
		String query = "Select Name From Character WHERE CharacterID = ?";
		
		 try (Connection conn = this.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query))
		 {

	           stmt.setInt(1,  id);
	           
	           ResultSet rs = stmt.executeQuery();
	           
	           if(rs.next()) {
	        	   name = rs.getString("Name");
	           }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
}
