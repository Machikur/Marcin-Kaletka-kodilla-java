package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyList = new ArrayList<>();

        //When
        ArrayList<Integer> testList = oddNumbersExterminator.exterminate(emptyList);

        //Then
        Assert.assertTrue(testList.isEmpty());
        Assert.assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> testlist = new ArrayList<>();

        testlist.add(5);
        testlist.add(15);
        testlist.add(52);
        testlist.add(54);

        //When
        ArrayList<Integer> oddNumbersList = oddNumbersExterminator.exterminate(testlist);

        //Then
        Assert.assertFalse(oddNumbersList.isEmpty());
        Assert.assertTrue(testlist.size() == 4);
        Assert.assertTrue(oddNumbersList.size() == 2);
    }

}
