package application;

import javafx.scene.Scene;
import javafx.scene.shape.Shape;

public interface Movement {

	void move(Element element, Shape shape, Scene scene, Boolean ballUp, Boolean ballLeft);

}
