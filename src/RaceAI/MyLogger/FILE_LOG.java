package RaceAI.MyLogger;

public enum FILE_LOG {
	Race(0),
	Car(1),
	MainAI(2),
	MAP(3),
	All(4);
	
	private int value;
	
	FILE_LOG(int i)
	{
		value = i;
	}
	public int getValue()
	{
		return value;
	}

}