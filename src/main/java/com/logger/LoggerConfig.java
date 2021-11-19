package com.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LoggerConfig {

    public static final Logger setup_logger(Class name) {
        DOMConfigurator.configure("src/test/resources/Logger_LOG4j/logger.xml");
        Logger logger = Logger.getLogger(name);
        return logger;
    }

}
