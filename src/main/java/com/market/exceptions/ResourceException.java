package com.market.exceptions;

/**
 * The parent for all exceptions, associated with resources, such as {@link com.market.user.User} etc.
 *
 * @author Ouharri Outman
 * @version 1.0
 */
public class ResourceException extends RuntimeException {
    public ResourceException() {}

    public ResourceException(String message) {
        super(message);
    }
}
