package com.example.labwork1.counter;

import org.springframework.stereotype.Service;

@Service
public class RequestCounter {
    private static int counter = 0;

    public static void increment() {
        counter++;
    }

    public static Integer getCounter() {
        return counter;
    }
}
