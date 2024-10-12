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

	private void getCharacterInfo()
	{
        
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
}
