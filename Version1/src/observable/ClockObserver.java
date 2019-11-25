package observable;

import java.sql.Time;

import javafx.scene.text.Text;

public abstract class ClockObserver 
{
	Text txtTime = new Text();
	int sec;
	int min;
	
	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}


	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public Text getTxtTime() {
		return txtTime;
	}

	public void setTxtTime(Text txtTime) {
		this.txtTime = txtTime;
	}

	public abstract void timeIncrementNotification();
}
