package guiBuilder;

import javax.swing.JComboBox;

public class BuildCombo implements BuildGui<JComboBox<String>> {
	
	private String text;
	private int x;
	private int y;
	private int width;
	private int height;
	@Override
	public BuildGui<JComboBox<String>> setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public BuildGui<JComboBox<String>> setX(int x) {
		this.x = x;
		return this;
	}

	@Override
	public BuildGui<JComboBox<String>> setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public BuildGui<JComboBox<String>> setWidth(int width) {
		this.width = width;
		return this;
	}

	@Override
	public BuildGui<JComboBox<String>> setHeight(int height) {
		this.height = height;
		return this;
	}

	@Override
	public JComboBox<String> build() {
		JComboBox<String> combo = new JComboBox<String>();
		combo.setBounds(x, y, width, height);
		return combo;
	}

}
