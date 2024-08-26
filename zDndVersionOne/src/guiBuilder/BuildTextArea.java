package guiBuilder;

import javax.swing.JTextArea;

public class BuildTextArea implements BuildGui<JTextArea>
{
	private String text;
	private int x;
	private int y;
	private int width;
	private int height;

	@Override
	public BuildGui<JTextArea> setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public BuildGui<JTextArea> setX(int x) {
		this.x = x;
		return this;
	}

	@Override
	public BuildGui<JTextArea> setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public BuildGui<JTextArea> setWidth(int width) {
		this.width = width;
		return this;
	}

	@Override
	public BuildGui<JTextArea> setHeight(int height) {
		this.height = height;
		return this;
	}

	@Override
	public JTextArea build() {
		JTextArea textArea = new JTextArea();
		textArea.setBounds(x, y, width, height);
		return textArea;
	}

}
