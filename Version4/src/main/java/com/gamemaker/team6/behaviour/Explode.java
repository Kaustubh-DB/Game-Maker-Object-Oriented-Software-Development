package com.gamemaker.team6.behaviour;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.List;

import com.gamemaker.team6.model.Component;

public class Explode extends Reaction {

	private static final long serialVersionUID = 1L;
	private String condition;
		
	public Explode(String condition) {
		this.condition = condition;	
	}

	@Override
	public boolean react(Component primary, List<Component> components) {		
		for (int i = 0; i < components.size(); i++) {
			Component secondary = components.get(i);
			if(primary == secondary || (secondary.isToxic() && condition.equals("Consumable")) || (!secondary.isToxic() && condition.equals("Weapon") ))
				continue;
			if(doesReact(primary, secondary)){
					primary.explode();
				return true;
			}
		}
		return false;
	}
}
