package application;

import javafx.animation.Timeline;

public class Undo implements Command{
	ElementManager m;
	public Undo(ElementManager m)
	{
		this.m=m;
	}
	
	public void execute(Timeline tl)
	{
	m.undo(m);	
	}
}
