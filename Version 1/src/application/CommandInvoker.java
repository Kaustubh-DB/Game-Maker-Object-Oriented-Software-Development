package application;

import javafx.animation.Timeline;

public class CommandInvoker {
	Command replayCommand,undoCommand;
	public CommandInvoker(Command replayCommand,Command undoCommand)
	{
		this.undoCommand=undoCommand;
		this.replayCommand=replayCommand;
	}
	void undo(Timeline tl)
	{
		undoCommand.execute(tl);
	}
	void replay(Timeline tl)
	{
		replayCommand.execute(tl);
	}

}
