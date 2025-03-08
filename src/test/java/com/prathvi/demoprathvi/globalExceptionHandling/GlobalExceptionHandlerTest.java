package com.prathvi.demoprathvi.globalExceptionHandling;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handleNullPointerException() {
        NullPointerException exception = new NullPointerException("Null value detected");
        String response = handler.handleNullPointerException(exception);
        assertEquals("Null Pointer Exception occurred: Null value detected", response);
    }

    @Test
    void handleIllegalArgumentException() {
        IllegalArgumentException exception = new IllegalArgumentException("Invalid argument");
        String response = handler.handleIllegalArgumentException(exception);
        assertEquals("Illegal Argument Exception occurred: Invalid argument", response);
    }

    @Test
    void handleArithmeticException() {
        ArithmeticException exception = new ArithmeticException("Division by zero");
        String response = handler.handleArithmeticException(exception);
        assertEquals("Arithmetic Exception occurred: Division by zero", response);
    }

    @Test
    void handleArrayIndexOutOfBoundsException() {
        ArrayIndexOutOfBoundsException exception = new ArrayIndexOutOfBoundsException("Index out of range");
        String response = handler.handleArrayIndexOutOfBoundsException(exception);
        assertEquals("Array Index Out Of Bounds Exception occurred: Index out of range", response);
    }

    @Test
    void handleIOException() {
        IOException exception = new IOException("File not found");
        String response = handler.handleIOException(exception);
        assertEquals("IO Exception occurred: File not found", response);
    }

    @Test
    void handleGeneralException() {
        Exception exception = new Exception("General error");
        String response = handler.handleGeneralException(exception);
        assertEquals("An unexpected error occurred: General error", response);
    }
}
