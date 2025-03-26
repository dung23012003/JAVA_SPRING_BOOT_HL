package com.java_lesson2.lesson2.dependecy_injection;

public class DrawShape {
    private final Shape shape;  // Biến này có thể là final

    public DrawShape(Shape shape) {
        this.shape = shape;
    }

    public void Draw() {
        shape.draw();
    }
}