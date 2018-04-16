package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Test;

public class ShapeCollectorTestSuite {

    @Test
    public void testAddFigure() {
        //Given
        Shape testShape = new Circle(2);
        ShapeCollector testShapeCollector = new ShapeCollector();

        //When
        testShapeCollector.addFigure(testShape);
        //Then
        Assert.assertEquals(1,testShapeCollector.getListSize());
    }

    @Test
    public void testGetFigure() {
        //Given
        Shape testShape = new Circle(2);
        ShapeCollector testShapeCollector = new ShapeCollector();
        testShapeCollector.addFigure(testShape);
        //When
        Shape retrievedShape = testShapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(testShape, retrievedShape);
    }

    @Test
    public void testRemovingNotExistingFigure() {
        //Given
        Shape testShape = new Circle(2);
        ShapeCollector testShapeCollector = new ShapeCollector();
        //When
        boolean result=testShapeCollector.removeFigure(testShape);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemovingFigure() {
        //Given
        Shape testShape = new Circle(2);
        ShapeCollector testShapeCollector = new ShapeCollector();
        testShapeCollector.addFigure(testShape);
        //When
        boolean result=testShapeCollector.removeFigure(testShape);
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testShowFigures(){
        //Given
        Shape testShape = new Triangle(1,1);
        Shape testShape2 = new Square(2);
        ShapeCollector testShapeCollector = new ShapeCollector();

        //When
        testShapeCollector.addFigure(testShape);
        testShapeCollector.addFigure(testShape2);
        //Then
        Assert.assertEquals("Triangle{field=0.5};Square{field=4.0};",testShapeCollector.showFigures());

    }



}
