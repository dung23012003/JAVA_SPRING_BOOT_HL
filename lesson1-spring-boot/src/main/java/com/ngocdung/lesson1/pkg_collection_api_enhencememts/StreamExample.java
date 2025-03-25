package com.ngocdung.lesson1.pkg_collection_api_enhencememts;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class StreamExample {
    List<Integer> integerList = Arrays.asList(11, 22, 55, 33, 44, 66);

    // Đếm các số chẵn không dùng Stream
    public void withoutStream() {
        int count = 0;
        for (Integer integer : integerList) {
            if (integer % 2 == 0) count++;
        }
        System.out.println("WithoutStream -> Số phần tử chẵn: " + count);
    }

    // Đếm các số chẵn dùng Stream
    public void withStream() {
        long count = integerList.stream().filter(num -> num % 2 == 0).count();
        System.out.println("WithStream -> Số phần tử chẵn: " + count);
    }

    public static void main(String[] args) {
        StreamExample streamExample = new StreamExample();
        streamExample.withoutStream();
        streamExample.withStream();

        // Ví dụ sử dụng forEach() với List
        List<String> languages = Arrays.asList("Java Spring", "C#", "NetCore API", "PHP Laravel", "Javascript");
        System.out.println("Sử dụng biểu thức Lambda: ");
        languages.forEach(lang -> System.out.println(lang));

        System.out.println("Sử dụng method reference: ");
        languages.forEach(System.out::println);

        // Ví dụ sử dụng forEach() với Map
        Map<Integer, String> hmap = new HashMap<>();
        hmap.put(1, "Java Spring");
        hmap.put(2, "Javascript");
        hmap.put(3, "PHP Laravel");
        hmap.put(4, "C# NetCore");

        System.out.println("Hiển thị dữ liệu Map:");
        hmap.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
