package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if(shapes.contains(shape)){
            shapes.remove(shape);
            result=true;
        }
        return result;
    }

    public Shape getFigure(int shapeNumber) {
        Shape theShape=null;
        if(shapeNumber>=0 && (shapeNumber<shapes.size())){
            theShape=shapes.get(shapeNumber);
        }
        return theShape;
    }

    public String showFigures() {
        String allFigures="";

        for(Shape tempShape : shapes){
            allFigures+=tempShape+";";
        }

        return allFigures;
    }

    public int getListSize() {
        return shapes.size();
    }
}
