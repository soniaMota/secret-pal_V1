package com.secretpal.domain.exception;

public class DuplicatedUserMail extends RuntimeException {
    public DuplicatedUserMail(String username) {
        super("The username '" + username + "' is not available");
    }
}
