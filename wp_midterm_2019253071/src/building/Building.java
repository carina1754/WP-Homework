package building;

public abstract class Building {
	public abstract boolean isBuild();
	public abstract int build() throws InterruptedException;
	public abstract int destory(int a);
}