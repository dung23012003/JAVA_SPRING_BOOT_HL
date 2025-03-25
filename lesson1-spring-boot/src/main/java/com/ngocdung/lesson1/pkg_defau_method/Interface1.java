package com.ngocdung.lesson1.pkg_defau_method;


interface Interface1 {
    default void method1() {
        System.out.println("Interface1.method1");
    }
}

interface Interface2 {
    default void method2() {
        System.out.println("Interface2.method2");
    }
}

class MultiInheritance implements Interface1, Interface2 {  // Bỏ "public"
    @Override
    public void method1() {
        Interface1.super.method1();
    }

    @Override
    public void method2() {
        System.out.println("MultiInheritance.method2");
    }

    public static void main(String[] args) {
        MultiInheritance mi = new MultiInheritance();
        mi.method1();
        mi.method2();
    }
}