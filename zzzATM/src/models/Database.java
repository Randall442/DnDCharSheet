package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import views.AtmWindow;

public class Database {
	//string to connect to the database
	private String url = "jdbc:sqlite:./ATMF.db";
	private AtmWindow window;

	public Database(AtmWindow window)
	{
		setWindow(window);
	}
	//checks to make sure there are 5 digits in the text field
	public boolean isFiveDigits(int number) 
	{
		return number >= 10000 && number <= 99999;
	}
	 //connection to the database
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
	//checkes to make sure the account number and the pin match whats in the database
	public boolean authenticate(int accountNumber, int pin) {
		//query for the database
		  String query = "SELECT * FROM accounts WHERE account_number = ? AND pin = ?";
		  //try catch for prepared statement for data
		    try (Connection conn = this.getConnection();
		        PreparedStatement pstmt = conn.prepareStatement(query)) 
		    {

		        pstmt.setInt(1, accountNumber);
		        pstmt.setInt(2, pin);
		        
		        try (ResultSet rs = pstmt.executeQuery()) {
		            return rs.next();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
    }
	
   
    public void createUser(int userNum, int pin) {
    	//creates the user if the user num and user pin match the digit length
    	 if (!isFiveDigits(userNum) || !isFiveDigits(pin)) {
             JOptionPane.showMessageDialog(window.getFrame(),"Account number and PIN must be exactly 5 digits.", "Input Error", JOptionPane.ERROR_MESSAGE);
             
         }
    	 //creates the users and inserts it into the datyabase
    	String validateSQL = "SELECT COUNT(*) FROM accounts WHERE account_number = ?";
        String insertSQL = "INSERT INTO accounts (account_number, pin, balance) VALUES (?, ?, ?)";

        try (Connection conn = this.getConnection();
        	 PreparedStatement validate = conn.prepareStatement(validateSQL);
             PreparedStatement statement = conn.prepareStatement(insertSQL)) {

       
        	validate.setInt(1, userNum);
            ResultSet result = validate.executeQuery();
            result.next();
            int counter = result.getInt(1);
            
            
            if(counter > 0) {
            	JOptionPane.showMessageDialog(window.getFrame(),"Account already exists", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else
            {
            	statement.setInt(1, userNum);
            	statement.setInt(2, pin);
            	statement.setDouble(3, 500);
            	statement.executeUpdate();
                System.out.println("User created successfully.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void getUsers() {
    	// query to get the user from the database for logging in
        String sql = "SELECT account_number, pin, balance FROM accounts";
        
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("User: " + rs.getString("account_number"));
                System.out.println("Password: " + rs.getString("pin"));
                System.out.println("Balance: " + rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUsers(int accountNumber)
    {
    	//query for deleting users from the database
    	String deleteUserSQL = "DELETE FROM accounts WHERE account_number = ?";

    	try (Connection conn = this.getConnection();
    	     PreparedStatement pstmt = conn.prepareStatement(deleteUserSQL)) {
    	    
    	    
    	    pstmt.setInt(1, accountNumber); 

    	   
    	    int rowsAffected = pstmt.executeUpdate();
    	    
    	    if (rowsAffected > 0) {
    	       
    	        JOptionPane.showMessageDialog(window.getFrame(), "Account with account_number " + accountNumber + " deleted successfully.", "Input Error", JOptionPane.ERROR_MESSAGE);
    	    } else {
    	        
    	        JOptionPane.showMessageDialog(window.getFrame(),"No account found with account_number " + accountNumber , "Input Error", JOptionPane.ERROR_MESSAGE);
    	    }
    	} catch (SQLException e) {
    	    System.out.println(e.getMessage());
    	}
    }
    
    public int getBalance(int accountNumber) {
    	//query for getting the balance of the account
        String sql = "SELECT balance FROM accounts WHERE account_number = ?";
        int balance = 0;  
        
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
           
            pstmt.setInt(1, accountNumber);
            
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    
                    balance = rs.getInt("balance");
                } else {
                    
                    JOptionPane.showMessageDialog(window.getFrame(),"Account not found for account number: " + accountNumber, "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(window.getFrame(),"Error retrieving balance for account number " + accountNumber, "Input Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        return balance; 
    }
    
    public void setBalance(int accountNumber, int newBalance) {
    	//query for updating the balance
        String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?";
        
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDouble(1, newBalance);
            pstmt.setInt(2, accountNumber);
            
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(window.getFrame(),"Balance updated successfully for account number: " + accountNumber, "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
               
                JOptionPane.showMessageDialog(window.getFrame(),"No account found with account number: " + accountNumber, "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(window.getFrame(),"Error updating balance for account number " + accountNumber, "Input Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    public AtmWindow getWindow()
    {
    	return window;
    }
    public void setWindow(AtmWindow window)
    {
    	this.window = window;
    }
    
}
