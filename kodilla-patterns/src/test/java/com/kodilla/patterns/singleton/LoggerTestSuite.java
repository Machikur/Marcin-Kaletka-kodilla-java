package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testLog() {
        //given
        Logger logger = Logger.getInstance();
        String log1 = "LogOne";

        //whem
        logger.log(log1);

        //then
        Assert.assertEquals(log1, logger.getLastLog());
    }
}
