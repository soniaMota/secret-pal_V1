package com.secretpal.domain.exception;

import javax.validation.ValidationException;

public class InvalidFullnameException extends ValidationException {
    public InvalidFullnameException(String fullname) {
        super("Invalid fullname: '" + fullname + "' until 200 chars and only letters and spaces");

    }
}
