package com.hillel.rosenko.lessons.lesson3;

public class Employee {

    private String name;
    private String surname;
    private String middleName;
    private String position;
    private String email;
    private String phone;
    private int age;

    public Employee(String name, String surname, String middleName, String position, String email, String phone, int age) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public Employee() {
        this.name = null;
        this.surname = null;
        this.middleName = null;
        this.position = null;
        this.email = null;
        this.phone = null;
        this.age = 0;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Employee setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Employee setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public Employee setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    void displayInfo() {
        System.out.printf("""
                Name: %s
                Surname: %s
                MiddleName: %s
                position: %s
                email: %s
                phone: %s
                age: %d
                """, name, surname, middleName, position, email, phone, age);

    }
}
