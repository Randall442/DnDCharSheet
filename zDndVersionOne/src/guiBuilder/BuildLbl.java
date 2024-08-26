package guiBuilder;

import javax.swing.JLabel;

public class BuildLbl implements BuildGui<JLabel>{

	private String text;
	private int x;
	private int y;
	private int width;
	private int height;
	
	@Override
	public BuildGui<JLabel> setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public BuildGui<JLabel> setX(int x) {
		this.x = x;
		return this;
	}

	@Override
	public BuildGui<JLabel> setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public BuildGui<JLabel> setWidth(int width) {
		this.width = width;
		return this;
	}

	@Override
	public BuildGui<JLabel> setHeight(int height) {
		this.height = height;
		return this;
	}

	@Override
	public JLabel build() {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, width, height);
		return label;
	}

}
