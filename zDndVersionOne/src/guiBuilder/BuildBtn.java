package guiBuilder;

import javax.swing.JButton;

public class BuildBtn implements BuildGui<JButton>
{
	private String text;
	private int x;
	private int y;
	private int width;
	private int height;
	
	@Override
	public BuildGui<JButton> setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public BuildGui<JButton> setX(int x) {
		this.x = x;
		return this;
	}

	@Override
	public BuildGui<JButton> setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public BuildGui<JButton> setWidth(int width) {
		this.width = width;
		return this;
	}

	@Override
	public BuildGui<JButton> setHeight(int height) {
		this.height = height;
		return this;
	}

	
	public JButton build() {
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		return button;
	}
	
}
