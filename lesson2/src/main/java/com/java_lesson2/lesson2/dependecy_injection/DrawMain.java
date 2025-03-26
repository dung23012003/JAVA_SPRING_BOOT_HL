package com.java_lesson2.lesson2.dependecy_injection;


public class DrawMain {
    public static void main(String[] args) {
        DrawShape drawShape = new DrawShape(new CircleShape());
        drawShape.Draw();  // In ra: "CircleShape draw"

        drawShape = new DrawShape(new RectangleShape());
        drawShape.Draw();  // In ra: "RectangleShape draw"
    }
}