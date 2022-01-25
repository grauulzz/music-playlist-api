package com.amazon.ata.music.playlist.service.exceptions;

public class InvalidAttributeChangeException extends PlaylistNotFoundException {

    private static final long serialVersionUID = 5853314973443303838L;

    /**
     * @param message the message to set
     */
    public InvalidAttributeChangeException(final String message) {
        super(message);
    }

    /**
     * @param cause the cause to set
     */
    public InvalidAttributeChangeException(final Throwable cause) {
        super(cause);
    }

    /**
     * @param message the message to set
     * @param cause the cause to set
     */
    public InvalidAttributeChangeException(final String message, final Throwable cause) {
        super(message, cause);
    }

}

