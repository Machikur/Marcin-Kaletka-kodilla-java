package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("rozpoczynam testy");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("po testach");
    }

    @Before
    public void before() {
        System.out.println("obecnie testujemy");
    }

    @After
    public void after() {
        System.out.println("przetestowane");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyList = new ArrayList<>();

        System.out.println("testuje pustą listę");
        Assert.assertTrue(oddNumbersExterminator.exterminate(emptyList).isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(15);
        list.add(52);
        list.add(54);

        System.out.println("testuje listę z róznymi wartościami");
        Assert.assertFalse(oddNumbersExterminator.exterminate(list).isEmpty());
    }

}
