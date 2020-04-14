package com.secretpal.domain.exception;

import javax.validation.ValidationException;

public class InvalidPasswordException extends ValidationException {
    public InvalidPasswordException() {
        super("Not valid password: At least 8 chars, one or more capital and digits");
    }
}
