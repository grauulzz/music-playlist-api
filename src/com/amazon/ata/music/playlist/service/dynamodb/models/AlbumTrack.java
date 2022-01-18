package com.amazon.ata.music.playlist.service.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Represents a record in the album_tracks table.
 */
@DynamoDBTable(tableName = "album_tracks")
public class AlbumTrack {
    private String asin;
    private Integer trackNumber;
    private String albumName;
    private String songTitle;

    @DynamoDBHashKey(attributeName = "asin")
    public String getAsin() {
        return asin;
    }

    @DynamoDBRangeKey(attributeName = "track_number")
    public Integer getTrackNumber() {
        return trackNumber;
    }

    @DynamoDBAttribute(attributeName = "album_name")
    public String getAlbumName() {
        return albumName;
    }

    @DynamoDBAttribute(attributeName = "song_title")
    public String getSongTitle() {
        return songTitle;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
}