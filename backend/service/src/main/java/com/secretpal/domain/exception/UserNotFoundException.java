package com.secretpal.domain.exception;

import javax.ws.rs.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String username) {
        super("The user with username '" + username + "' is NOT register in the system.");

    }
}
