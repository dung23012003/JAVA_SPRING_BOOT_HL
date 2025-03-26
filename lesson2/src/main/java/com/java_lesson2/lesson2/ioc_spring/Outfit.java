package com.java_lesson2.lesson2.ioc_spring;

public interface Outfit {
    void wear();
}
class Sport implements Outfit {
    public void wear() {
        System.out.println("Đã mặc kiểu thể thao");
    }
}

public class Girl {
    private Outfit outfit;

    public Girl(Outfit outfit) {
        this.outfit = outfit;
    }

    public void dressUp() {
        outfit.wear();
    }
}