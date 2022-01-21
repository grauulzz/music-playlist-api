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

    // TODO: Add methods to access data for an album  (this was one that was implemented in commented test)
    public AlbumTrack getAlbumTrack(String asin, int trackNumber) {
        return dynamoDbMapper.load(AlbumTrack.class, asin, trackNumber);
    }
}
