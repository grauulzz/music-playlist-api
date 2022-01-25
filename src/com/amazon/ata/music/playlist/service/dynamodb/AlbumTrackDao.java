package com.amazon.ata.music.playlist.service.dynamodb;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import javax.inject.Inject;

/**
 * Accesses data for an album using {@link AlbumTrack} to represent the model in DynamoDB.
 */
public class AlbumTrackDao {
    private final DynamoDBMapper dynamoDbMapper;

    /**
     * Instantiates an AlbumTrackDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the album_track table
     */
    @Inject
    public AlbumTrackDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    /**
     * @param asin the ASIN of the album
     * @param trackNumber the track number of the album
     * @return the {@link AlbumTrack} for the given ASIN and track number
     */
    public AlbumTrack getAlbumTrack(String asin, int trackNumber) {
        return dynamoDbMapper.load(AlbumTrack.class, asin, trackNumber);
    }

}

