package views;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AtmWindow {
	private JFrame frame;
	private JPanel mainPanel;
	private CardLayout cardLayout;
	private JButton submitBtn;
	private JButton createBtn;
	private JTextField enterNum;
	private JTextField enterPin;
	public AtmWindow()
	{
		frame = new JFrame("Atm");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		
		JPanel welcomePanel = createLoginMenu();
        //JPanel transactionPanel = createTransactionPanel();
       // JPanel balancePanel = createBalancePanel();
		
        mainPanel.add(welcomePanel, "WelcomePanel");
        //mainPanel.add(transactionPanel, "TransactionPanel");
       // mainPanel.add(balancePanel, "BalancePanel");
        
		frame.setLocationRelativeTo(null);
		
		
		frame.add(mainPanel);
		frame.setResizable(false);
		
		frame.setVisible(true);
	}
	
	public JPanel createLoginMenu()
	{
		 JPanel loginPanel = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 10, 10, 10);
	        
	   
	        JLabel userNum = new JLabel("User: ");
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        loginPanel.add(userNum, gbc);
	        
	   
	        enterNum = new JTextField(10);
	        gbc.gridx = 1;
	        loginPanel.add(enterNum, gbc);
	        
	    
	        JLabel userPin = new JLabel("Pin: ");
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        loginPanel.add(userPin, gbc);
	        
	   
	        enterPin = new JTextField(10);
	        gbc.gridx = 1;
	        loginPanel.add(enterPin, gbc);
	        
	       
	        submitBtn = new JButton("Submit");
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        loginPanel.add(submitBtn, gbc);
	        

	        createBtn = new JButton("Create");
	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        loginPanel.add(createBtn, gbc);
	        
	        return loginPanel;
		
	}
	
	public JButton getSubmit()
	{
		return submitBtn;
	}
	public JButton getCreate()
	{
		return createBtn;
	}
	public JFrame getWindow()
	{
		return frame;
	}
	
	public String getUser()
	{
		return enterNum.getText();
	}
	public String getPin()
	{
		return enterPin.getText();
	}
	public JFrame getFrame()
	{
		return frame;
	}
	public void hideWindow()
	{
		frame.setVisible(false);
	}

}
