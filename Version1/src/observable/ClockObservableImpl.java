package observable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class ClockObservableImpl implements ClockObservable
{
	private List<ClockObserver> observersList;
	Timer timer = new Timer();
	
	public ClockObservableImpl() 
	{
		observersList = new ArrayList<ClockObserver>();
	}
	
	@Override
	public void register(ClockObserver clockObserver)
	{
		observersList.add(clockObserver);	
	}

	@Override
	public void deRegister(ClockObserver clockObserver) 
	{
		observersList.add(clockObserver);
	}

	@Override
	public void notifyObservers()
	{
		for (ClockObserver timeObserver : observersList) 
		{
			timeObserver.timeIncrementNotification();
		}
	}

}
