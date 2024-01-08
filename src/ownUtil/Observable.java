package ownUtil;
public interface Observable {
	public abstract void addObserver(Observer o);
	public abstract void notifyObservers();
}
