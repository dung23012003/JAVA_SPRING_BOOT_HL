package com.ngocdung.lesson1.pkg_defau_method;


interface Shape {  // Bỏ "public" để không bắt buộc phải đặt trong Shape.java
    void draw();

    default void setColor(String color) {
        System.out.println("Vẽ hình với màu: " + color);
    }
}

