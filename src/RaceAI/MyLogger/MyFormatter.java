package RaceAI.MyLogger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter{
	
	public MyFormatter() {
		
	}
	private static final DateFormat df = new SimpleDateFormat("hh:mm:ss.SSS");
	 
	@Override
	public String format(LogRecord record) {
		StringBuilder builder = new StringBuilder(1000);
        builder.append(df.format(new Date(record.getMillis()))).append(" - ");
        // builder.append("[").append(record.getSourceClassName()).append(".");
        // builder.append(record.getSourceMethodName()).append("] - ");
        builder.append("[").append(record.getLevel()).append("] - ");
        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();
        // ex Output: 10:25:24.727 - [INFO] - Race: Msg from class Race
	}

}
