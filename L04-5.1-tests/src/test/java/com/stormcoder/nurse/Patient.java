package com.stormcoder.nurse;

public class Patient {
    @Injection
    private Glucose glucose;

    public Glucose getGlucose() {
        return glucose;
    }
}
