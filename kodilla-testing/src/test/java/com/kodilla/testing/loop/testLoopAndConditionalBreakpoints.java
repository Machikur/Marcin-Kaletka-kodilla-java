package com.kodilla.testing.loop;

import org.junit.Assert;
import org.junit.Test;

public class testLoopAndConditionalBreakpoints {

    @Test
    public void testLoop() {
        //given
        int sum=0;

        //when
        for(int i=0;i<1000;i++){
            sum +=i;
            System.out.println("{" + i + "}" + "Sum equals: " + sum);
        }
        Assert.assertNotEquals(0,sum);
    }
}
