package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double field=0;

    public Triangle(double side, double height) {
        field=side*height/2;
    }

    public String getShapeName() {
        return "Triangle";
    }

    public double getField() {
        return field;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "field=" + field +
                '}';
    }
}
