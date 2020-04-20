package com.secretpal.domain.exception;

public class DuplicatedGroupName extends RuntimeException {
    public DuplicatedGroupName(String name) {
        super("The name '" + name + "' is not available");
    }
}
