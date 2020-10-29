package com.example.vetruongmanager.data;

public class Ticket {
    private int number;
    private String name;
    private String classNumber;
    private String phoneNumber;
    private boolean isPaid;

    public Ticket(int number, String name, String classNumber, String phoneNumber, boolean isPaid){
        this.number = number;
        this.name = name;
        this.classNumber = classNumber;
        this.phoneNumber = phoneNumber;
        this.isPaid = isPaid;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
