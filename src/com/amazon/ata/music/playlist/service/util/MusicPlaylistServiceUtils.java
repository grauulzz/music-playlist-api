package com.amazon.ata.music.playlist.service.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * The type Music playlist service utils.
 */
public final class MusicPlaylistServiceUtils {
    /**
     * The constant PLAYLIST_ID_LENGTH.
     */
    static final int PLAYLIST_ID_LENGTH = 5;
    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\"'\\\\]");

    /**
     * Instantiates a new Music playlist service utils.
     */
    private MusicPlaylistServiceUtils() {
    }

    /**
     * Checks that the provided String contains only valid characters.
     *
     * @param stringToValidate the playlist name to be validated
     * @return true if the String is valid (contains only valid characters), false otherwise
     */
    public static boolean isValidString(final String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        }

        return !INVALID_CHARACTER_PATTERN.matcher(stringToValidate).find();
    }

    /**
     * Generate playlist id string.
     *
     * @return a random playlist ID
     */
    public static String generatePlaylistId() {
        return RandomStringUtils.randomAlphanumeric(PLAYLIST_ID_LENGTH);
    }
}

