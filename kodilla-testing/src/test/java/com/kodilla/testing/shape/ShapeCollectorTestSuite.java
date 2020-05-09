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
        //Given
        ArrayList<Shape> testList = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector(testList);
        Triangle triangle = new Triangle(5, 10, 15);
        //When
        shapeCollector.addFigure(triangle);
        //Then
        Assert.assertEquals(1, testList.size());
        Assert.assertTrue(testList.contains(triangle));
    }

    @Test
    public void testDelShape() {
        //Given
        ArrayList<Shape> testList = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector(testList);
        //When
        Triangle triangle = new Triangle(5, 10, 15);
        shapeCollector.addFigure(triangle);
        //Then
        Assert.assertTrue(shapeCollector.removeFigure(triangle));
        Assert.assertTrue(testList.isEmpty());
    }

    @Test
    public void testDelNonexistenShape() {
        //Given
        Shape shape = new Square(2);
        ArrayList<Shape> testList = new ArrayList<>();
        //When
        ShapeCollector shapeCollector = new ShapeCollector(testList);
        //Then
        Assert.assertFalse(shapeCollector.removeFigure(shape));
    }

    @Test
    public void testGetFigure() {
        //Given
        ArrayList<Shape> testList = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector(testList);

        //When
        Square square = new Square(1);
        shapeCollector.addFigure(square);

        //Then
        Assert.assertEquals(square, testList.get(0));

    }

    @Test
    public void testGetElementFromNonexistsentIndex() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector(new ArrayList<>());

        //When
        Shape testShape = shapeCollector.getFigure(1);

        //Then
        Assert.assertNull(testShape);

    }
    @Test
    public void showAllFigures(){
        //when
        ShapeCollector shapeCollector = new ShapeCollector(new ArrayList<>());
        Shape shape = new Square(2);

        //given
        shapeCollector.addFigure(shape);
        shapeCollector.addFigure(shape);
        shapeCollector.addFigure(shape);

        //then
        shapeCollector.showFigures();
    }

}
