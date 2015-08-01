package com.thoughtworks.session.organizer.exceptions;

/**
 * The Class GenericException.
 */
public class GenericException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3524182600876303429L;

    /**
     * Instantiates a new generic exception.
     */
    public GenericException() {
        super();
    }

    /**
     * Instantiates a new generic exception.
     * 
     * @param message the message
     */
    public GenericException(String message) {
        super(message);
    }

    /**
     * Instantiates a new generic exception.
     * 
     * @param message the message
     * @param cause the cause
     */
    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new generic exception.
     * 
     * @param cause the cause
     */
    public GenericException(Throwable cause) {
        super(cause);
    }

}
