package com.example.labwork1.controller;


import com.example.labwork1.calculations.Parametres;
import com.example.labwork1.counter.RequestCounter;

import lombok.AllArgsConstructor;

import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import com.example.labwork1.customException.CustomException;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.labwork1.customException.CustomException;
import com.example.labwork1.Validation.Validation;
import com.example.labwork1.calculations.Solution;
import org.springframework.http.HttpStatus;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ControllerAdvice
@RestController
@AllArgsConstructor
public class MaximumController {
    private Solution solution;
    RequestCounter requestCounter = new RequestCounter();
    private static final Logger logger = LogManager.getLogger(MaximumController.class);

    @GetMapping("/maximum")
    public ResponseEntity<Object> maxIdentification(@RequestParam(value = "firstNumber", defaultValue = "0") String firstNumber,
                                                    @RequestParam(value = "secondNumber", defaultValue = "0") String secondNumber,
                                                    @RequestParam(value = "thirdNumber", defaultValue = "0") String thirdNumber) throws CustomException {

        Integer firstNumberInt = 0, secondNumberInt = 0, thirdNumberInt = 0;
        if (Validation.parsing(firstNumber, secondNumber, thirdNumber) == 3) {
            firstNumberInt = Integer.parseInt(firstNumber);
            secondNumberInt = Integer.parseInt(secondNumber);
            thirdNumberInt = Integer.parseInt(thirdNumber);
        }
        Parametres param = new Parametres(firstNumberInt, secondNumberInt, thirdNumberInt);
        //systemCalls.increasingCalls();
        requestCounter.increment();
        solution.calculateRoot(param);


        return new ResponseEntity<>(solution.getRoot(), HttpStatus.OK);
    }

    @PostMapping(value = "/input",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Object> calculateBulkParams(@RequestBody String[] str) {


        logger.info("Successfully postMapping");
        Operationable operation;
        operation = (x,y,z) -> x+y+z;
        int sum = operation.calculate(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        int maxResult = solution.findMaxOfResult(str);
        int minResult = solution.findMinOfResult(str);

        return new ResponseEntity<>("\nSum: " + sum + "\nMax result: " +
               maxResult + "\nMin result: " + minResult, HttpStatus.OK);



    }

    interface Operationable{
        int calculate(int x, int y, int z);
    }


}



