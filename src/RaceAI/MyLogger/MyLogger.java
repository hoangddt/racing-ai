package RaceAI.MyLogger;

import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.FileHandler;;



public class MyLogger {
	private static MyLogger _instance = null;
	
	private MyLogger()
	{
		// Create all log
		this.addNewLogger("All", FILE_LOG.All);
	}
	
	public static MyLogger getInstance()
	{
		if (_instance == null)
		{
			_instance = new MyLogger();
		}
		return _instance;
	}
	
	
	private final int MAX_LOG_FILE = FILE_LOG.values().length;
	private Logger[] _loggers = new Logger[MAX_LOG_FILE];

	
	public MyLogger addNewLogger(String name, FILE_LOG logOfClass)
	{
		Logger newLog = Logger.getLogger(name);
		
		try {
			FileHandler fh = new FileHandler("logs/" + name + ".log");
			newLog.addHandler(fh);
			MyFormatter formatter = new MyFormatter();
			fh.setFormatter(formatter);
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		newLog.setUseParentHandlers(false);
		int index = logOfClass.getValue();
		_loggers[index] = newLog;
		
		return _instance;
	}
	
	public void writeLogMsg(FILE_LOG fromClass, String msg)
	{
		msg = fromClass.name() + ": " + msg;
		_loggers[fromClass.getValue()].info(msg);
		
		if (fromClass == FILE_LOG.MAP)
			return;
		_loggers[FILE_LOG.All.getValue()].info(msg);
	}
}
