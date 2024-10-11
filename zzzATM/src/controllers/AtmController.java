package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.AtmData;
import models.Database;
import views.AtmWindow;
import views.AtmWindow;

public class AtmController implements ActionListener {
	private AtmWindow window;
	private AtmData data;
	private Database db;
	private StringBuilder userNumInput = new StringBuilder();
	private StringBuilder userPinInput = new StringBuilder();
	private JTextField lastFocusedField;
	private JLabel currentDisplayLabel; 
	private String currentUser;
	
	public AtmController(AtmWindow window, AtmData data)
	{
		this.window = window;
		this.data = data;
		
		db = new Database(window);
	
		getCreateBtn();
		getNumPadBtns();
		
		
	}
	
	public void atmWindow()
	{
		window.getWindow();
	}
	
	//adds action listener to the buttons
	public void getCreateBtn() {
		addListener(window.getCreate(), this);
	}
	
	public void addListener(JButton button, ActionListener listener)
	{
		button.addActionListener(listener);
	}
	//gets the num pads and adds the action listener for each button in the array of buttons
	public void getNumPadBtns()
	{
		for(var num : window.getNumPadBtns())
		{
			addListener(num ,this);
		}
	}
	//gets current user
	public String getUserNum()
	{
		return currentUser;
	}
	//sets current user
	public void setUserNum(String num)
	{
		this.currentUser = num;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
	   
	    if (source == window.getCreate()) 
	    {
	    	//gets the num and pin from the textField in the view
	    	String userNum = window.getUser();
	        String userPin = window.getPin();
	        
	        
	       
	      //checks to make sure the num and pin are not null or not empty
	        if (userNum == null || userPin == null || userNum.isEmpty() || userPin.isEmpty()) {
	            JOptionPane.showMessageDialog(window.getFrame(), "Please fill in both fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
	            return; 
	        }

	        try {
	            //creates the user in the db
	            int numValue = Integer.parseInt(userNum);
	            int pinValue = Integer.parseInt(userPin);
	            
	            db.createUser(numValue, pinValue);

	        } catch (NumberFormatException ex) {
	         
	            JOptionPane.showMessageDialog(window.getFrame(), "Please enter a valid integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    else 
	    {
	        for (JButton numBtn : window.getNumPadBtns()) 
	        {
	            if (source == numBtn) 
	            {
	            	
	                String btnText = numBtn.getText();
	                //switch case for the buttons
	                switch (btnText) 
	                {
                    case "0": case "1": case "2": case "3": case "4":
                    case "5": case "6": case "7": case "8": case "9":
                    	//only allows the buttons to work on the panel that is shown
                    		if(window.isWelcomePanelShown())
                    		{
                    			if (window.getEnterNum().isFocusOwner()) 
                          	  {
                          		  userNumInput.append(btnText);
                                    window.getEnterNum().setText(userNumInput.toString());
                                } 
                          	  
                          	  else if (window.getEnterPin().isFocusOwner()) 
                          		  
                                {
                              	  userPinInput.append(btnText);
                                    window.getEnterPin().setText(userPinInput.toString());
                                }
                    		}
                    		else if (window.isChoicePanelShown()) 
                    		{
                    			if (btnText.equals("1")) 
                    			{
                    				window.switchCardLayout(window.getMainPanel(), "WithdrawPanel");
                    				
                    			}
                    			else if(btnText.equals("2"))
                    			{
                    				window.switchCardLayout(window.getMainPanel(), "DepositPanel");
                    				
                    			}
                    			else if(btnText.equals("3"))
                    			{
                    				window.switchCardLayout(window.getMainPanel(), "BalancePanel");
                    				
                    			}
                    			else if(btnText.equals("6"))
                    			{
                    				window.switchCardLayout(window.getMainPanel(), "WelcomePanel");
                    				
                    			}
                    		}
                    		
                    		else if(window.isWithdrawPanelShown())
                    		{
                    			if(btnText.equals("1"))
                    			{
                    				db.setBalance(Integer.parseInt(currentUser), -20);
                        		    
                    			}
                    			if(btnText.equals("2"))
                    			{
                    				db.setBalance(Integer.parseInt(currentUser), -40);
                    			}
                    			if(btnText.equals("3"))
                    			{
                    				db.setBalance(Integer.parseInt(currentUser), -60);
                    			}
                    			if(btnText.equals("4"))
                    			{
                    				db.setBalance(Integer.parseInt(currentUser), -80);
                    			}
                    			if(btnText.equals("5"))
                    			{
                    				db.setBalance(Integer.parseInt(currentUser), -100);
                    			}
                    			if(btnText.equals("6"))
                    			{
                    				window.switchCardLayout(window.getMainPanel(), "ChoicePanel");
                    			}
                    		}
                    		else if(window.isDepositPanelShown())
                    		{
                    			if(btnText.equals("1"))
                    			{
                    				db.setBalance(Integer.parseInt(currentUser), 20);
                        		    
                    			}
                    			if(btnText.equals("2"))
                    			{
                    				db.setBalance(Integer.parseInt(currentUser), 40);
                    			}
                    			if(btnText.equals("3"))
                    			{
                    				db.setBalance(Integer.parseInt(currentUser), 60);
                    			}
                    			if(btnText.equals("4"))
                    			{
                    				db.setBalance(Integer.parseInt(currentUser), 80);
                    			}
                    			if(btnText.equals("5"))
                    			{
                    				db.setBalance(Integer.parseInt(currentUser), 100);
                    			}
                    			if(btnText.equals("6"))
                    			{
                    				window.switchCardLayout(window.getMainPanel(), "ChoicePanel");
                    			}
                    			
                    		}
                    		else if (window.isBalancePanelShown())
                    		{
                    			if(btnText.equals("8"))
                    			{
                    				
                    				int newBalance = db.getBalance(Integer.parseInt(currentUser));
                        		    String balanceCon = String.valueOf(newBalance);
                        		    
                        		    window.setBalance(balanceCon); 
                    			}
                    			else if(btnText.equals("6"))
                    			{
                    				window.switchCardLayout(window.getMainPanel(), "ChoicePanel");
                    			}
                    			
                    		}
                    		else if(window.isChoicePanelShown())
                    		{
                    			if (window.getEnterNum().isFocusOwner()) 
                          	  {
                          		  userNumInput.append(btnText);
                                    window.getEnterNum().setText(userNumInput.toString());
                                } 
                          	  
                          	  else if (window.getEnterPin().isFocusOwner()) 
                          		  
                                {
                              	  userPinInput.append(btnText);
                                    window.getEnterPin().setText(userPinInput.toString());
                                }
                    		}
                    			
                    	  
                          break;
                    	
                    case "Enter":
                       //enter button for logging in
                    	String userNum = window.getUser();
            	        String userPin = window.getPin();
            	        
            	      
            	        if (userNum == null || userPin == null || userNum.isEmpty() || userPin.isEmpty()) {
            	            JOptionPane.showMessageDialog(window.getFrame(), "Please fill in both fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            	            return; 
            	        }

            	        try {
            	            
            	            int numValue = Integer.parseInt(userNum);
            	            int pinValue = Integer.parseInt(userPin);

            	            if (db.authenticate(numValue, pinValue)) 
            	            {
            	            	 window.switchCardLayout(window.getMainPanel(), "ChoicePanel");
            	            	 setUserNum(String.valueOf(numValue));
            	            } 
            	            else 
            	            {
            	            	JOptionPane.showMessageDialog(window.getFrame(), "User Num and Pin do not match!", "Input Error", JOptionPane.ERROR_MESSAGE);
            	            }

            	        } catch (NumberFormatException ex) {
            	         
            	            JOptionPane.showMessageDialog(window.getFrame(), "Please enter a valid integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            	        }
                       
                        break;

                    case "Clear":
                    	//clears the focuse text field
                    	if (window.getEnterNum().isFocusOwner()) {
                            userNumInput.setLength(0);  
                            window.getEnterNum().setText("");  
                        } else if (window.getEnterPin().isFocusOwner()) {
                            userPinInput.setLength(0);
                            window.getEnterPin().setText(""); 
                        }
                    	break;

                    default:
                        
                        System.out.println("Unknown button pressed");
                        break; 
	                }
	              
	            }
	        }
	    }
	}
}
