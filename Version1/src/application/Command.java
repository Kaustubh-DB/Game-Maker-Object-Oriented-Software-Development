package application;


import javafx.animation.Timeline;

//import javafx.scene.layout.BorderPane;

public interface Command {
	
	//public void startCommand(ElementManager m,Timeline tl);
	//public void endCommand();
	public void execute(Timeline tl);

}
