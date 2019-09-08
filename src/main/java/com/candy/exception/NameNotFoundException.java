package com.candy.exception;

public class NameNotFoundException extends RuntimeException {

    private String name;

    public NameNotFoundException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getMessage() {
        return "name [" + name + "] not found.";
    }
}
