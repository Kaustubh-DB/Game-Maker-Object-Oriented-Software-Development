package observable;

import javafx.scene.text.Text;

public class TimerClockObserver extends ClockObserver
{
	Text txtTime = new Text();
	int sec = 0;
	int min = 0;
	

	@Override
	public void timeIncrementNotification() 
	{
		sec++;
		if ( sec % 60 == 0)
		{
			min++;
			sec =0;
		}
		txtTime.setText(Integer.toString(min)+":"+Integer.toString(sec));
		
	}

	public void Undo()
	{
		System.out.println("Timer Undo Called");
	}
	
	public Text getTxtTime() {
		return txtTime;
	}


	public void setTxtTime(Text txtTime) {
		this.txtTime = txtTime;
	}


	public  int getSec() {
		return sec;
	}


	public  void setSec(int sec) {
		this.sec = sec;
	}


	public  int getMin() {
		return min;
	}


	public  void setMin(int min) {
		this.min = min;
	}

	
}
