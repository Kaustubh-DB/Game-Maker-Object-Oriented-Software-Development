package com.gamemaker.team6.behaviour;
import org.apache.log4j.Logger;
public class NoAction implements Action {

	private static final long serialVersionUID = -7909079686737336264L;
	private final static Logger logger = Logger.getLogger(NoAction.class);

	@Override
	public void act() {
		logger.info("This function is meant to be empty");

	}

}
