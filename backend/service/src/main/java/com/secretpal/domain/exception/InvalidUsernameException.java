package com.secretpal.domain.exception;

import javax.validation.ValidationException;

public class InvalidUsernameException extends ValidationException {
    public InvalidUsernameException(String value) {
        super("Invalid username: '" + value + "' . No more of 20 alphanumeric chars.");
    }
}
