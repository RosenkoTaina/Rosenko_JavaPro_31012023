package com.hillel.rosenko.lessons.lesson14.phonebook;

public record Record(String name, String phoneNumber) {
    @Override
    public String toString() {
        return "Record {" + "name='" + name + '\'' + ", phoneNumber='" + phoneNumber + '\'' + '}' + "\n";
    }
}