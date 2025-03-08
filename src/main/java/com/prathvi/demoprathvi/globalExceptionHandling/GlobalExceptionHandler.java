//package com.prathvi.demoprathvi.globalExceptionHandling;
//
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public String exceptionHandler(Exception e){
//        return "Hello , We are facing some issue." + e.getMessage();
//    }
//}

package com.prathvi.demoprathvi.globalExceptionHandling;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle NullPointerException
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNullPointerException(NullPointerException e){
        return "Null Pointer Exception occurred: " + e.getMessage();
    }

    // Handle IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException e) {
        return "Illegal Argument Exception occurred: " + e.getMessage();
    }

    // Handle ArithmeticException
    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleArithmeticException(ArithmeticException e) {
        return "Arithmetic Exception occurred: " + e.getMessage();
    }

    // Handle ArrayIndexOutOfBoundsException
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException e) {
        return "Array Index Out Of Bounds Exception occurred: " + e.getMessage();
    }

    // Handle IOException (example of a checked exception)
    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleIOException(IOException e) {
        return "IO Exception occurred: " + e.getMessage();
    }

    // Default handler for any other exceptions (optional)
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneralException(Exception e) {
        return "An unexpected error occurred: " + e.getMessage();
    }
}

