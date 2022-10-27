package com.yigitesmen.layeredarchitecture.core.logging;

public class MailLogger implements Logger {

    @Override
    public void log(String msg) {
        System.out.printf("Logged to mail: %s%n", msg);
    }
}
