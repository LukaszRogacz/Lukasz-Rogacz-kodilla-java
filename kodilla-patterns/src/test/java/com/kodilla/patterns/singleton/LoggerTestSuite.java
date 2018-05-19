package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog(){
        //Given
        //When
        Logger.getInstance().log("taki log");
        //Then
        String lastLog=Logger.getInstance().getLastLog();
        Assert.assertEquals("taki log",lastLog);
    }
}
