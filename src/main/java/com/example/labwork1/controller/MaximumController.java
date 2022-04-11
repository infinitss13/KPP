package com.example.labwork1.controller;


import com.example.labwork1.calculations.Parametres;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.labwork1.customException.CustomException;
import com.example.labwork1.Validation.Validation;
import com.example.labwork1.calculations.Solution;
import org.springframework.http.HttpStatus;

@ControllerAdvice
@RestController
@AllArgsConstructor
public class MaximumController {
    private Solution solution;
    Counter systemCalls = new Counter();


    @GetMapping("/maximum")
    public ResponseEntity<Object> maxIdentification(@RequestParam(value = "firstNumber", defaultValue = "0")String firstNumber,
                                                     @RequestParam(value = "secondNumber", defaultValue = "0")String secondNumber,
                                                     @RequestParam(value = "thirdNumber", defaultValue = "0")String thirdNumber) throws CustomException{

        Integer firstNumberInt=0,secondNumberInt=0,thirdNumberInt=0;
        if (Validation.parsing(firstNumber, secondNumber, thirdNumber) == 3) {
            firstNumberInt = Integer.parseInt(firstNumber);
            secondNumberInt = Integer.parseInt(secondNumber);
            thirdNumberInt = Integer.parseInt(thirdNumber);
        }
        Parametres param = new Parametres(firstNumberInt, secondNumberInt, thirdNumberInt);
        systemCalls.increasingCalls();
        solution.calculateRoot(param);



        return new ResponseEntity<>(solution.getRoot(), HttpStatus.OK);
    }

}



