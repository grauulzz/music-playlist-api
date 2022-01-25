package com.amazon.ata.music.playlist.service.models;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * The enum Song order.
 */
public enum SongOrder {

    /**
     * Default song order.
     */
    DEFAULT,
    /**
     * Reversed song order.
     */
    REVERSED,
    /**
     * Shuffled song order.
     */
    SHUFFLED;

    /**
     * Gets ordered collections.
     *
     * @param order The order to sort the songs in.
     * @param songs The songs to sort.
     * @return The sorted list of songs.
     */
    public static List<SongModel> getOrderedCollections(SongOrder order, List<SongModel> songs) {

        switch (order) {
            case DEFAULT:
                return songs.stream().sorted(Comparator.comparingInt(SongModel::getTrackNumber))
                        .collect(Collectors.toList());

            case REVERSED:
                return songs.stream().sorted(Comparator.comparingInt(SongModel::getTrackNumber)
                        .reversed()).collect(Collectors.toList());

            case SHUFFLED:
                return songs.stream().sorted(Comparator.comparingInt(SongModel::getTrackNumber))
                        .unordered()
                        .collect(Collectors.toList());

            default:
                return Collections.emptyList();
        }

    }

}

