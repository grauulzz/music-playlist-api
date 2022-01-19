package com.amazon.ata.music.playlist.service.exceptions;

public class InvalidAttributeChangeException extends PlaylistNotFoundException {


    private static final long serialVersionUID = 5853314973443303838L;

    public InvalidAttributeChangeException(final String message) {
        super(message);
    }

    public InvalidAttributeChangeException(final Throwable cause) {
        super(cause);
    }

    public InvalidAttributeChangeException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
