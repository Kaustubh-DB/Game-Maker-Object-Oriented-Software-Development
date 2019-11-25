package observable;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.text.Text;

public class NormalClockObserver  extends ClockObserver
{
	Text txtTime = new Text();
	
	
	@Override
	public void timeIncrementNotification() 
	{
		SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
		final String time = dt.format(new Date());
		System.out.println("normal clock notified");
		txtTime.setText(time);
	}
	
	public Text getTxtTime() {
		return txtTime;
	}


	public void setTxtTime(Text txtTime) {
		txtTime = txtTime;
	}


}
