package com.nnd.lesson_11.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "nnd_account")
@Data
public class NND_Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nnd_user")
    private String user;

    @Column(name = "nnd_pass")
    private String pass;

    @Column(name = "nnd_name")
    private String name;

    @Column(name = "nnd_email")
    private String email;

    @Column(name = "nnd_phone")
    private String phone;

    @Column(name = "nnd_address")
    private String address;

    @Column(name = "nnd_status")
    private String status;
}