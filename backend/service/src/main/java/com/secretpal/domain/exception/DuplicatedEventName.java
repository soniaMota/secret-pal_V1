package com.secretpal.domain.exception;

public class DuplicatedEventName extends RuntimeException {
    public DuplicatedEventName(String name){
        super("The name '" + name + "' is not available");
    }
}
