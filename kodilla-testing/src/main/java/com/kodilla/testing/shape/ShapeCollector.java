package com.kodilla.testing.shape;
import java.util.ArrayList;
import java.util.List;
public class ShapeCollector {
    List<Shape> shapeCollector = new ArrayList<>();
    public List<Shape> getShapeCollector() {
        return shapeCollector;
    }
    public void addShape(Shape shape) {
        shapeCollector.add(shape);
    }
    public boolean removeShape(Shape shape) {
        return shapeCollector.remove(shape);
    }
    public Shape getShape(int number) {
        return shapeCollector.get(number);
    }
    public int getListSize() {
        return shapeCollector.size();
    }

}