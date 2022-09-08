package Homework13.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SpecialLogger {

    private static final String path = "application.log";

    private static void log(String message, LoggingLevel loggingLevel) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.write(LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")) + " " + message + "[" + loggingLevel + "]" + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void error(String msg) {
        log(msg, LoggingLevel.ERROR);
    }

    public static void info(String msg) {
        log(msg, LoggingLevel.DEBUG);
    }

}
