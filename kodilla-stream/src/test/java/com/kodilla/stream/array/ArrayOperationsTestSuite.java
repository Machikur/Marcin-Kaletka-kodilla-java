package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = {10, 12, 14, 16, 18};
        Array array = new Array();

        //When
        double average = array.getAverage(numbers);

        //Then
        Assert.assertEquals(14, average, 0);
    }
}
