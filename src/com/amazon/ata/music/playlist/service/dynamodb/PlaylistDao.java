package com.amazon.ata.music.playlist.service.dynamodb;

import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

import javax.inject.Inject;


/**
 * Accesses data for a playlist using {@link Playlist} to represent the model in DynamoDB.
 */
public class PlaylistDao {
    private final DynamoDBMapper dynamoDbMapper;
    private final DynamoDBMapperConfig configUpdate = new DynamoDBMapperConfig.Builder()
            .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
            .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE)
            .build();


    /**
     * Instantiates a PlaylistDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the playlists table
     */
    @Inject
    public PlaylistDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    /**
     * @param id the Playlist ID
     * @return the {@link Playlist}
     */
    public Playlist getPlaylist(String id) {
        return dynamoDbMapper.load(Playlist.class, id);
    }

    /**
     * @param playlist to save
     * @return the saved {@link Playlist}
     */
    public Playlist savePlaylist(Playlist playlist) {
        dynamoDbMapper.save(playlist, configUpdate);
        return getPlaylist(playlist.getCustomerId());
    }

}

