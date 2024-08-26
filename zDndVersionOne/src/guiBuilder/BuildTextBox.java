package guiBuilder;

import javax.swing.JTextField;

public class BuildTextBox implements BuildGui<JTextField>
{
	private String text;
	private int x;
	private int y;
	private int width;
	private int height;

	@Override
	public BuildGui<JTextField> setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public BuildGui<JTextField> setX(int x) {
		this.x = x;
		return this;
	}

	@Override
	public BuildGui<JTextField> setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public BuildGui<JTextField> setWidth(int width) {
		this.width = width;
		return this;
	}

	@Override
	public BuildGui<JTextField> setHeight(int height) {
		this.height = height;
		return this;
	}

	@Override
	public JTextField build() {
		JTextField textField = new JTextField();
		textField.setBounds(x, y, width, height);
		return textField;
				
	}

}
