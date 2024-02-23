package com.example.testmodule3.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private  String name;
    private String email;
    private LocalDate dates;
    private String address;
    private String phone;
    private int id_class;

    public Student() {
    }

    public Student(int id, String name, String email, LocalDate dates, String address, String phone, int id_class) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dates = dates;
        this.address = address;
        this.phone = phone;
        this.id_class = id_class;
    }

    public Student(String name, String email, LocalDate dates, String address, String phone, int id_class) {
        this.name = name;
        this.email = email;
        this.dates = dates;
        this.address = address;
        this.phone = phone;
        this.id_class = id_class;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDates() {
        return dates;
    }

    public void setDates(LocalDate dates) {
        this.dates = dates;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }
}
