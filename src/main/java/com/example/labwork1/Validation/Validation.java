package com.example.labwork1.Validation;

import com.example.labwork1.customException.CustomException;

public class Validation {
    public static boolean isDigit(String s) throws CustomException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;

        }


    }
    public static Integer parsing(String firstNumber, String secondNumber, String thirdNumber) {
        String message = "";
        int flag = 0;
        if (Validation.isDigit(firstNumber)){
            flag += 1;
        } else {

            message += "error 400: BAD_REQUEST : invalid data, your first number is not Integer ; ";
        }

        if (Validation.isDigit(secondNumber)){
            flag += 1;

        } else {

            message += "error 400: BAD_REQUEST : invalid data, your second number is not Integer  ; ";
        }

        if (Validation.isDigit(thirdNumber)){
            flag += 1;

        } else {

            message += "error 400: BAD_REQUEST : invalid data, your third number is not Integer  ; ";
        }
        if (flag != 3) {
            throw new CustomException(message);
        }

        return flag;
    }
}
