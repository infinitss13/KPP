package com.example.labwork1.controller;

import com.example.labwork1.logger.ProgramLogger;
import org.apache.logging.log4j.Level;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Counter {
    static int calls = 0;

    synchronized void increasingCalls() {
        calls++;

        ProgramLogger.log(Level.INFO, "Counter has been increased.");
    }


    @GetMapping("/calls")
    synchronized String showCalls() {
        return Counter.calls + "  Calls have been done";
    }
}