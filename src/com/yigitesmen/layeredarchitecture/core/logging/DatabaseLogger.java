package com.yigitesmen.layeredarchitecture.core.logging;

public class DatabaseLogger implements Logger {

    @Override
    public void log(String msg) {
        System.out.printf("Logged to database: %s%n", msg);
    }
}
