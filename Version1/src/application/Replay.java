package application;



import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;


public class Replay implements Command {
	int j=0;
	ElementManager m;
	public Replay(ElementManager m)
	{
		this.m=m;
	}
	
	public void execute(Timeline tl)
	{
	m.replay(m,tl);	
	}
	/*public void startCommand(ElementManager m,Timeline tl) {
		int k;
		tl.stop();
		
		System.out.println("Hi i am in start command!");
		for(k=0;k<m.elementsList.size();k++) {
			//System.out.println(iterator.next().shape);
			m.root.getChildren().remove(m.elementsList.get(k).shape);
	      }
		for(k=0;k<m.elementsList.size();k++) {
			//System.out.println(iterator.next().shape);
			m.root.getChildren().add(m.elementsList.get(k).shape);
			if(k==0)
			{
				m.elementsList.get(k).shape.setTranslateX(400);
				m.elementsList.get(k).shape.setTranslateY(300);
			}
			
			if(k==1)
			{
				m.elementsList.get(k).shape.setTranslateX(400);
				m.elementsList.get(k).shape.setTranslateY(350);
			}
			
			if(k==2)
			{
				m.elementsList.get(k).shape.setTranslateX(500);
				m.elementsList.get(k).shape.setTranslateY(500);
			}
			
			
			createVideoTimeline(m);
	      }}
		
		
	//root.getChildren().remove(shape);
	//root.getChildren().remove(bat2);
	//root.getChildren().add(shape);
	//root.getChildren().add(bat2);
	//shape.relocate(10, 10);
	//bat2.relocate(100, 200);
	//MainReplayLogic mainObject=new MainReplayLogic();
	//mainObject.createVideoTimeline(element);
	
	public void endCommand() {}
	
	
	void replay(ElementManager m, Timeline tl)
	{	if(j==m.i) {tl.stop();return;}
		
		System.out.println("Entered the loop!");
		System.out.println(j);
		System.out.println(m.i);
		System.out.println("replay y coordinate"+m.coordinateArray[j].yOfBall);
		//g.gameComponentsArray.get(1).shape.setTranslateX(g.coordinateArray[j].xOfBat);
		m.elementsList.get(1).shape.setTranslateX(m.coordinateArray[j].xOfBat);
		m.elementsList.get(1).shape.setTranslateY(m.coordinateArray[j].yOfBat);
		m.elementsList.get(0).shape.setTranslateX(m.coordinateArray[j].xOfBall);
		m.elementsList.get(0).shape.setTranslateY(m.coordinateArray[j].yOfBall);
		m.elementsList.get(2).shape.setTranslateX(m.coordinateArray[j].xOfBrick);
		m.elementsList.get(2).shape.setTranslateY(m.coordinateArray[j].yOfBrick);
		System.out.println(j);
		j=j+1;
	}
	void createVideoTimeline(ElementManager m)
	{	
		
		Timeline tl = new Timeline();
		
		tl.setCycleCount(Animation.INDEFINITE);
		System.out.println("Created a new Timeline!");
        KeyFrame moveBall = new KeyFrame(Duration.seconds(0.076),
                new EventHandler<ActionEvent>() {
					
        			@Override
					
					
					public void handle(ActionEvent event) {
        				
        				replay(m,tl);
				    		
						// TODO Auto-generated method stub
				    	
						
					}
					
        });
        tl.getKeyFrames().add(moveBall);
        
        tl.play();
        
        }
    		
}
*/}