package com.yigitesmen.layeredarchitecture.core.logging;

public class FileLogger implements Logger {

    @Override
    public void log(String msg) {
        System.out.printf("Logged to file: %s%n", msg);
    }
}
