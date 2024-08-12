package build;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BtnBuilder implements Btn{
	private String text = "";
	private int x = 0, y = 0, width = 0, height = 0;
	private ActionListener listener = null;
	
	@Override
	public Btn setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public Btn setX(int x) {
		this.x = x;
		return this;
	}

	@Override
	public Btn setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public Btn setWidth(int width) {
		this.width = width;
		return this;
	}

	@Override
	public Btn setHeight(int height) {
		this.height = height;
		return this;
	}

	@Override
	public Btn setListener(ActionListener listener) {
		this.listener = listener;
		return this;
	}

	@Override
	public JButton buildBtn() {
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		if(listener != null)
		{
			button.addActionListener(listener);
		}
		return button;
	}
	
	public JButton btnHelper(String helpText, int helpX, int helpY, int helpWidth, int helpHeight, ActionListener helpListener)
	{
		JButton button = new BtnBuilder().setText(helpText)
										 .setX(helpX)
										 .setY(helpY)
										 .setWidth(helpWidth)
										 .setHeight(helpHeight)
										 .setListener(helpListener)
										 .buildBtn();
		return button;
	}
	
	
}
