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

    @Test
    public void testSingleton() {
        //given
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        //when
        log1.log("sout");

        //then
        Assert.assertEquals(log1, log2);
        Assert.assertEquals(log1.getLastLog(), log2.getLastLog());
    }
}
