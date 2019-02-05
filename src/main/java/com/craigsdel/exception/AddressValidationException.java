package com.craigsdel.exception;

/**
 * @author Craig Stroberg <strobergcd@gmail.com>
 */
public class AddressValidationException extends Exception {
    public AddressValidationException() {
    }

    public AddressValidationException(String message) {
        super(message);
    }

    public AddressValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressValidationException(Throwable cause) {
        super(cause);
    }

    public AddressValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
