package guiBuilder;

public interface BuildGui<T>
{
	BuildGui<T> setText(String text);
	BuildGui<T> setX(int x);
	BuildGui<T> setY(int y);
	BuildGui<T> setWidth(int width);
	BuildGui<T> setHeight(int height);
	T build();
}
