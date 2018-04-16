package com.kodilla.testing.shape;

public class Square implements Shape {

    private double field=0;

    public Square(double side) {
        field=side*side;
    }

    public String getShapeName() {
        return "Square";
    }

    public double getField() {
        return field;
    }

    @Override
    public String toString() {
        return "Square{" +
                "field=" + field +
                '}';
    }
}
