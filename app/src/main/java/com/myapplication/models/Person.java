package com.myapplication.models;

import android.support.annotation.NonNull;

/**
 * @author Abhishek Vadnerkar
 */

public class Person implements Comparable<Person> {
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int compareTo(@NonNull Person p) {
        return this.getName().compareTo(p.getName());
    }
}
