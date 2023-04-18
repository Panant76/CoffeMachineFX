package com.example.demo.exception;

public class ContainerIsFullException extends Exception {
    public ContainerIsFullException() {
        super("Мусорка полна");
    }
}
