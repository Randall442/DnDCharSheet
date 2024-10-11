package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Database;

public class AtmWindow {
	//sets up variables for the gui
	private JFrame frame;
	private JPanel mainPanel;
	private CardLayout cardLayout;
	private JButton submitBtn;
	private JButton createBtn;
	private JButton[] numPadBtns = new JButton[12];
	private JTextField enterNum;
	private JTextField enterPin;
	private JPanel welcomePanel;
	private JPanel choicePanel;
	private JPanel withdrawPanel;
	private JPanel depositPanel;
	private JPanel balancePanel;
	private JPanel windowPanel;
	private JLabel withdrawAmountLbl;
	private JLabel depositAmountLbl;
	private JLabel balanceAmountLbl;
	private JLabel getSetBalanceLbl;
	private Database db;
	private String currentPanel;

	public AtmWindow()
	{
		//creates a window for the app
		frame = new JFrame("Atm");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//creates a cardlayout to cycle through panels
		cardLayout = new CardLayout();
		windowPanel = new JPanel();
		mainPanel = new JPanel();
		mainPanel.setLayout(cardLayout);
		
		
		//sets up the panels
		welcomePanel = createLoginMenu();
		choicePanel = createChoicePanel();
        withdrawPanel = createWithdrawPanel();
        depositPanel = createDepositPanel();
        balancePanel = createBalancePanel();
       
        //adds the panels to the main panel
        mainPanel.add(welcomePanel, "WelcomePanel");
        mainPanel.add(depositPanel,"DepositPanel");
        mainPanel.add(choicePanel,"ChoicePanel");
        mainPanel.add(withdrawPanel, "WithdrawPanel");
        mainPanel.add(balancePanel, "BalancePanel");
        
        //creates the num pad
        JPanel numPadPanel = createNumPadPanel();
        
		frame.setLocationRelativeTo(null);
		
		
		frame.add(mainPanel);
		frame.add(numPadPanel, BorderLayout.SOUTH);
		frame.setResizable(false);
		
		frame.setVisible(true);
	}
	public JPanel createChoicePanel()
	{
		//sets up the choice panel with labels
		JPanel choicePanel = new JPanel();
		choicePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel withdrawLbl = new JLabel("1. Withdraw");
        gbc.gridx = 0;
        gbc.gridy = 1;
        choicePanel.add(withdrawLbl, gbc);
        
        JLabel depositLbl = new JLabel("2. Deposit");
        gbc.gridx = 0;
        gbc.gridy = 2;
        choicePanel.add(depositLbl, gbc);
		
        JLabel balanceLbl = new JLabel("3. Balance");
        gbc.gridx = 0;
        gbc.gridy = 3;
        choicePanel.add(balanceLbl, gbc);
		
        JLabel backLbl = new JLabel("6. go back");
        gbc.gridx = 0;
        gbc.gridy = 4;
        choicePanel.add(backLbl, gbc);
		
		return choicePanel;
	}
	private JPanel createWithdrawPanel() {
		//sets up the withdraw panel
		JPanel withdrawPanel = new JPanel();
		
		withdrawPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel label = new JLabel("Select how much you wish to withdraw.");
        gbc.gridx = 0;
        gbc.gridy = 1;
        withdrawPanel.add(label, gbc);
        
        JLabel twentyLbl = new JLabel("1. 20$");
        gbc.gridx = 0;
        gbc.gridy = 2;
        withdrawPanel.add(twentyLbl, gbc);
        
        JLabel fourtyLbl = new JLabel("2. 40$");
        gbc.gridx = 0;
        gbc.gridy = 3;
        withdrawPanel.add(fourtyLbl, gbc);
        
        JLabel sixtyLbl = new JLabel("3. 60$");
        gbc.gridx = 0;
        gbc.gridy = 4;
        withdrawPanel.add(sixtyLbl, gbc);
        
        JLabel eightyLbl = new JLabel("4. 80$");
        gbc.gridx = 0;
        gbc.gridy = 5;
        withdrawPanel.add(eightyLbl, gbc);
        
        JLabel hundredLbl = new JLabel("5. 100$");
        gbc.gridx = 0;
        gbc.gridy = 6;
        withdrawPanel.add(hundredLbl, gbc);
        
        JLabel backLbl = new JLabel("6. Go Back");
        gbc.gridx = 0;
        gbc.gridy = 7;
        withdrawPanel.add(backLbl, gbc);
		
		return withdrawPanel;
	}
	private JPanel createDepositPanel()
	{
		//stets up the deposit panel
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel label = new JLabel("Select how much you wish to deposit.");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(label, gbc);
        
        JLabel twentyLbl = new JLabel("1. 20$");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(twentyLbl, gbc);
        
        JLabel fourtyLbl = new JLabel("2. 40$");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(fourtyLbl, gbc);
        
        JLabel sixtyLbl = new JLabel("3. 60$");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(sixtyLbl, gbc);
        
        JLabel eightyLbl = new JLabel("4. 80$");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(eightyLbl, gbc);
        
        JLabel hundredLbl = new JLabel("5. 100$");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(hundredLbl, gbc);
        
        JLabel backLbl = new JLabel("6. Go Back");
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(backLbl, gbc);
        
        
		
		return panel;
	}
	private JPanel createBalancePanel() 
	{
		//sts up the balance panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel label = new JLabel("8. View Balance");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);
        
        JLabel labelTwo = new JLabel("6. Go Back");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelTwo, gbc);
        
        getSetBalanceLbl = new JLabel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(getSetBalanceLbl, gbc);
        
		return panel;
	}

	public JPanel createLoginMenu()
	{
		//sets up the login menu
		 JPanel loginPanel = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 10, 10, 10);
	        loginPanel.setBackground(Color.gray);
	        
	   
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
	        
	       
	        createBtn = new JButton("Create");
	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        loginPanel.add(createBtn, gbc);
	        
	        
	        loginPanel.setPreferredSize(new Dimension(400,300));
	        
	        return loginPanel;
		
	}
	public JPanel createNumPadPanel()
	{
		//creates the numpad
		JPanel numPad = new JPanel(new GridLayout(4, 3, 10, 10));

		//loop and an array to create the numbers 1-9
	    for (int i = 1; i <= 9; i++) {
	        JButton numPadBtn = new JButton(String.valueOf(i)); 
	        numPadBtn.setFocusable(false);  
	        numPadBtns[i - 1] = numPadBtn;  
	        numPad.add(numPadBtn);          
	    }

	    //creates the other buttons
	    JButton zeroButton = new JButton("0");
	    zeroButton.setFocusable(false); 
	    numPadBtns[9] = zeroButton;
	    numPad.add(zeroButton);
	    
	    JButton enterButton = new JButton("Enter");
	    enterButton.setFocusable(false); 
	    
	    JButton clearButton = new JButton("Clear");
	    clearButton.setFocusable(false); 
	    
	    numPadBtns[10] = enterButton;
	    numPadBtns[11] = clearButton;

	    numPad.add(enterButton);
	    numPad.add(clearButton);

	    return numPad;
	}
	//getters and setters for the controller
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
	public JButton[] getNumPadBtns()
	{
		return numPadBtns;
	}
	public String getUser()
	{
		return enterNum.getText();
	}
	public String getPin()
	{
		return enterPin.getText();
	}
	public void setPin(String text) {
		enterPin.setText(text);
		
	}
	public JFrame getFrame()
	{
		return frame;
	}
	public void hideWindow()
	{
		frame.setVisible(false);
	}
	public JTextField getEnterNum()
	{
		return enterNum;
	}
	public JTextField getEnterPin()
	{
		return enterPin;
	}
	 public void switchCardLayout(JPanel mainPanel, String panelName) {
	        cardLayout.show(mainPanel, panelName);
	        currentPanel = panelName;
	    }
	public JPanel getChoicePanel()
	{
		return choicePanel;
	}
	public JPanel getMainPanel() {
	    return mainPanel;
	}

	public CardLayout getCardLayout() {
	    return cardLayout;
	}
	public JLabel getWithdrawLbl()
	{
		return withdrawAmountLbl;
	}
	public JLabel getDepositLbl()
	{
		return depositAmountLbl;
	}
	public JLabel getBalanceLbl()
	{
		return balanceAmountLbl;
	}
	public boolean isWelcomePanelShown()
	{
		return welcomePanel.isVisible();
	}
	public boolean isChoicePanelShown() {
	    return choicePanel.isVisible();
	}
	public void setIsChoicePanelShown()
	{
		choicePanel.setVisible(false);
	}
	public boolean isWithdrawPanelShown() {
	    return withdrawPanel.isVisible();
	}
	public void setIsWithdrawPanelShown()
	{
		withdrawPanel.setVisible(false);
	}
	public boolean isDepositPanelShown() {
	    return depositPanel.isVisible();
	}
	public void setIsDepositPanelShown()
	{
		depositPanel.setVisible(false);
	}
	public boolean isBalancePanelShown() {
	    return balancePanel.isVisible();
	}
	public void setIsBalancePanelShown()
	{
		balancePanel.setVisible(false);
	}
	public JLabel getBalance() 
	{
		return getSetBalanceLbl;
	}
	public void setBalance(String getSetBalance)
	{
		this.getSetBalanceLbl.setText(getSetBalance);
	}
	
	public String getCurrentPanel() {
        return currentPanel;
    }
	
}
