package build;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public interface Btn 
{
	Btn setText(String text);
	Btn setX(int x);
	Btn setY(int y);
	Btn setWidth(int width);
	Btn setHeight(int height);
	Btn setListener(ActionListener listener);
	JButton buildBtn();
	
}
