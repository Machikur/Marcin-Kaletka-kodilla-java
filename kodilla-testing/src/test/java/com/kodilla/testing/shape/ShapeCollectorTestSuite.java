package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;

public class ShapeCollectorTestSuite {

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
    public void testAddShape() {
        ArrayList<Shape> testList = new ArrayList<>();
        ShapeCollector shapeCollector=new ShapeCollector(testList);
        shapeCollector.addFigure(new Triangle(5,10,15));
        Assert.assertEquals(1,testList.size());
    }

    @Test
    public void testDelShape(){
        ArrayList<Shape> testList = new ArrayList<>();
        ShapeCollector shapeCollector=new ShapeCollector(testList);
        Triangle triangle=new Triangle(5,10,15);
        shapeCollector.addFigure(triangle);
        Assert.assertTrue(shapeCollector.removeFigure(triangle));
    }

    @Test
    public void testGetFigure(){
        ArrayList<Shape> testList = new ArrayList<>();
        ShapeCollector shapeCollector=new ShapeCollector(testList);
        Square square=new Square(1);
        shapeCollector.addFigure(square);

        Assert.assertEquals(square,testList.get(0));

    }


}
