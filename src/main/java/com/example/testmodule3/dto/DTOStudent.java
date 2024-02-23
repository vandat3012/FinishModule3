package com.example.testmodule3.dto;

import java.time.LocalDate;

public class DTOStudent {
    private int id;
    private  String name;
    private LocalDate dates;
    private String email;
    private String address;
    private String phone;
    private String nameC;

    public DTOStudent() {
    }

    public DTOStudent(int id, String name, LocalDate dates, String email, String address, String phone, String nameC) {
        this.id = id;
        this.name = name;
        this.dates = dates;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.nameC = nameC;
    }

    public DTOStudent(String name, LocalDate dates, String email, String address, String phone, String nameC) {
        this.name = name;
        this.dates = dates;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.nameC = nameC;
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

    public LocalDate getDates() {
        return dates;
    }

    public void setDates(LocalDate dates) {
        this.dates = dates;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }
}
