package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Util {
    private static final Logger LOGGER = LogManager.getLogger(Util.class);

    private Util(){}

    public static final String MSG_1 = "any text 1";

    public static String msg1(){
        LOGGER.debug("starting msg1()");
        LOGGER.debug("msg1 = {}", MSG_1);
        LOGGER.debug("ending msg1()");
        return MSG_1;
    }


      
}
