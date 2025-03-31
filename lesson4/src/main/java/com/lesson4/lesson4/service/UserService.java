package com.lesson4.lesson4.service;

import com.lesson4.lesson4.dto.UserDTO;
import com.lesson4.lesson4.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User(1L, "Nguyễn Ngọc Dũng", "12345", "Nguyễn Ngọc Dũng", LocalDate.parse("2003-01-23"), "dung@example.com", "1234567890", 22, true));
        userList.add(new User(2L, "user2", "pass2", "Jane Smith", LocalDate.parse("1992-05-15"), "jane@example.com", "0987654321", 32, false));
        userList.add(new User(3L, "user3", "pass3", "Alice Johnson", LocalDate.parse("1985-11-22"), "alice@example.com", "1122334455", 39, true));
        userList.add(new User(4L, "user4", "pass4", "Bob Brown", LocalDate.parse("1988-03-18"), "bob@example.com", "6677889900", 36, true));
        userList.add(new User(5L, "user5", "pass5", "Charlie White", LocalDate.parse("1995-09-30"), "charlie@example.com", "4433221100", 29, false));
    }

    public List<User> findAll() {
        return userList;
    }

    public void create(UserDTO usersDTO) {
        // Kiểm tra trùng lặp username và email
        if (userList.stream().anyMatch(user -> user.getUsername().equals(usersDTO.getUsername()))) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userList.stream().anyMatch(user -> user.getEmail().equals(usersDTO.getEmail()))) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User();
        user.setId(userList.stream().count() + 1);
        user.setUsername(usersDTO.getUsername());
        user.setPassword(usersDTO.getPassword());
        user.setEmail(usersDTO.getEmail());
        user.setFullName(usersDTO.getFullName());
        user.setPhone(usersDTO.getPhone());
        user.setAge(usersDTO.getAge());
        user.setBirthDate(usersDTO.getBirthday());
        user.setStatus(usersDTO.getStatus());
        userList.add(user);
    }
}