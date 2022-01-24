package com.amazon.ata.music.playlist.service.models;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;


public enum SongOrder  {

    DEFAULT,
    REVERSED,
    SHUFFLED;

    // use enum to call corresponding sort methods of collections
    public static List<SongModel> getOrderedCollections(SongOrder order, List<SongModel> songs) {

        if (order == null) {
            order = DEFAULT;
        }

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

        }
        // condition is met when playlist exists (not null) but no songs are present
        return Collections.emptyList();
    }
}
