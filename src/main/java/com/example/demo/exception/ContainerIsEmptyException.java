package com.example.demo.exception;

public class ContainerIsEmptyException extends Exception {
    public ContainerIsEmptyException(String name) {
        super(name+" пустой");
    }
}
