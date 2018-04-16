package com.kodilla.testing.shape;

public class Circle implements Shape {
    private double field=0;

    public Circle(double radius) {
        field=radius*radius*Math.PI;
    }

    public String getShapeName() {
        return "Circle";
    }

    public double getField() {
        return field;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "field=" + field +
                '}';
    }
}
