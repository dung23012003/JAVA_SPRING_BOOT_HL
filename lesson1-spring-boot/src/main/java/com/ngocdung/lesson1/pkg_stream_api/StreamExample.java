package com.ngocdung.lesson1.pkg_stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Book {
    int id;
    String name;
    float price;

    public Book(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class StreamExample {
    List<Integer> integerList = Arrays.asList(11, 22, 55, 33, 44, 66);
    List<Book> books = new ArrayList<>();

    public StreamExample() {
        books.add(new Book(1, "Lập trình Java", 9.95f));
        books.add(new Book(2, "Java SpringBoot", 19.95f));
        books.add(new Book(3, "PHP Laravel", 12.95f));
        books.add(new Book(4, "NetCore API", 29.95f));
        books.add(new Book(5, "Javascript", 19.95f));
    }

    // Đếm số phần tử chẵn không dùng Stream
    public void withoutStream() {
        int count = 0;
        for (Integer integer : integerList) {
            if (integer % 2 == 0) count++;
        }
        System.out.println("WithoutStream -> Số phần tử chẵn: " + count);
    }

    // Đếm số phần tử chẵn dùng Stream
    public void withStream() {
        long count = integerList.stream().filter(num -> num % 2 == 0).count();
        System.out.println("WithStream -> Số phần tử chẵn: " + count);
    }

    // Lọc sách có giá lớn hơn 15
    public void filterBooks() {
        Stream<Book> filter = books.stream().filter(b -> b.price > 15);
        filter.forEach(System.out::println);
    }

    public static void main(String[] args) {
        StreamExample streamExample = new StreamExample();
        streamExample.withoutStream();
        streamExample.withStream();
        streamExample.filterBooks();
    }
}