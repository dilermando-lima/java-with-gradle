package com.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Run {

    private static final Logger LOGGER = LogManager.getLogger(Run.class);

    public static void main(String[] args) {
        LOGGER.debug("starting main()");
        var msg1 = Util.msg1();
        LOGGER.info("Util.msg1() = {}", msg1);
        LOGGER.debug("ending main()");
    }

  
}
