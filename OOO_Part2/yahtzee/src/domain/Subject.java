package domain;

import ui.Observer;

public interface Subject {

	public void add(Observer o);
	public void remove(Observer o);
	public void notiffy();
}
