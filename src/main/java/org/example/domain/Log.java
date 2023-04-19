package org.example.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Log {

    private static final Logger logger = Logger.getLogger("MainLogger");

    static void info(String message) {
        logger.log(Level.INFO, message);
    }

}
