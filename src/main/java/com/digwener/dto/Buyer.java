package com.digwener.dto;

/**
 * DTO for person
 * Created by aberezin on 24.04.2016.
 */
public class Buyer {

    private final String id;
    private final String name;
    private final String surname;

    public Buyer(String id, final String name, final String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
