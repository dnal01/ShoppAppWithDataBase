package org.example;

import org.example.utils.AppStarter;
import org.example.utils.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class Main implements Filter {

    private static final LogManager logManager =
            LogManager.getLogManager();
    private static final Logger LOGGER =
            Logger.getLogger("confLogger");
    static {
        try {
            logManager.readConfiguration(
                    new FileInputStream(
                            Constants.BASE_PATH_LOGS_CONFIG +
                                    "logs.properties")
            );
            Handler consoleHandler;
            Handler fileHandler;
            Formatter simpleFormatter;
            consoleHandler = new ConsoleHandler();
            fileHandler = new FileHandler(Constants.BASE_PATH_INFO_LOGS.getValue() + "logs.log", 2000, 3);
//            simpleFormatter = new SimpleFormatter();
            // By this it simplifies xml file to two lines
//            fileHandler.setFormatter(simpleFormatter);
            // Will log only messages which have "important" word in them.
            LOGGER.setFilter(new Main());

            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.config("Important log configuration done.");
            LOGGER.removeHandler(consoleHandler);
            LOGGER.log(Level.FINE, "FINE logged");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error while creating log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        LOGGER.log(Level.FINER, "App started.");
        AppStarter.startApp();
    }
    @Override
    public boolean isLoggable(LogRecord record) {
        if (record == null)
            return false;
        String message = record.getMessage() == null ? ""
                : record.getMessage();
        return message.contains("important");
    }
}