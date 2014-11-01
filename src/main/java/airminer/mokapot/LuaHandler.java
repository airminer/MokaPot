package airminer.mokapot;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class LuaHandler extends ConsoleHandler {

    @Override
    public void publish(LogRecord record) {
    	Level level = record.getLevel();
        String message = getFormatter().formatMessage(record);
        
        if (level == Level.SEVERE) {
        	MokaPot.log(message);
        } else if (level == Level.WARNING) {
        	MokaPot.log(message);
        } else if (level == Level.INFO) {
        	MokaPot.log(message);
        } else if (level == Level.CONFIG) {
        	MokaPot.log(message);
        } else {
        	MokaPot.log(message);
        }
    }

    @Override
    public void flush() {}

    @Override
    public void close() throws SecurityException {}
}
