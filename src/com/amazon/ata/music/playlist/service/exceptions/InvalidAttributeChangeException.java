package com.amazon.ata.music.playlist.service.exceptions;

public class InvalidAttributeChangeException extends PlaylistNotFoundException {

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
