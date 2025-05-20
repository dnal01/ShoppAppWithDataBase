package org.example;

import org.example.utils.AppStarter;
import org.example.utils.Constants;

import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) {
        Handler consoleHandler;
        Handler fileHandler;
        Formatter simpleFormatter;
        try {

            consoleHandler = new ConsoleHandler();
            fileHandler = new FileHandler(Constants.BASE_PATH_INFO_LOGS.getValue() + AppStarter.class.getName() + "_logs.log");
            simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            fileHandler.setLevel(Level.INFO);
            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.config("Log configuration done.");
            LOGGER.removeHandler(consoleHandler);
            LOGGER.log(Level.FINE, "FINE logged");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error while creating log file: " + e.getMessage());
        }
        LOGGER.log(Level.FINER, "App started.");


        AppStarter.startApp();
    }
}