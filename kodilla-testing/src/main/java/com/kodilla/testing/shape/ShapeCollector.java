package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    ArrayList<Shape> listOfShapes = new ArrayList<>();

    public ShapeCollector(ArrayList<Shape> listOfShapes) {
        this.listOfShapes = listOfShapes;
    }

    public void addFigure(Shape shape) {
        listOfShapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if (listOfShapes.contains(shape)) {
            listOfShapes.remove(shape);
            return true;
        } else
            return false;
    }

    public Shape getFigure(int position){
        return listOfShapes.get(position);
    }
    public void showFigures(){

    }
}
