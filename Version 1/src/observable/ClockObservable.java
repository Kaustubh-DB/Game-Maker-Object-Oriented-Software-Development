package observable;

public interface ClockObservable 
{
	public void register(ClockObserver timeObserver);
	public void deRegister(ClockObserver timeObserver);
	//public void timeincrement();
	public void notifyObservers();

}
