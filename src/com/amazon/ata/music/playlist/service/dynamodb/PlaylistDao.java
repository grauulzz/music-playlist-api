package com.amazon.ata.music.playlist.service.dynamodb;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.exceptions.InvalidAttributeValueException;
import com.amazon.ata.music.playlist.service.exceptions.PlaylistNotFoundException;

import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.models.requests.CreatePlaylistRequest;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;

import static com.amazon.ata.music.playlist.service.util.MusicPlaylistServiceUtils.isValidString;

/**
 * Accesses data for a playlist using {@link Playlist} to represent the model in DynamoDB.
 */
public class PlaylistDao {
    private final DynamoDBMapper dynamoDbMapper;
    private final DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
            .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
            .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE)
            .build();

    /**
     * Instantiates a PlaylistDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the playlists table
     */
    public PlaylistDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    /**
     * Returns the {@link Playlist} corresponding to the specified id.
     *
     * @param id the Playlist ID
     * @return the stored Playlist, or null if none was found.
     */
    public Playlist getPlaylist(String id) {
        return dynamoDbMapper.load(Playlist.class, id);
    }

    /**
     * Returns the saved {@link Playlist}.
     *
     * @param playlist the Playlist to save
     */
    public Playlist savePlaylist(Playlist playlist) {
        // TODO: write unit test for save
        dynamoDbMapper.save(playlist, dynamoDBMapperConfig);
        return playlist;
    }

    public Playlist savePlaylistCustomerId(Playlist playlist) {

        dynamoDbMapper.save(playlist.getCustomerId(), dynamoDBMapperConfig);

        return playlist;
    }

//    public Playlist createPlaylist(CreatePlaylistRequest request, String id) {
//
//
//        request.setCustomerId(id);
//        request.setName(request.getName());
//        request.setTags(request.getTags());
//
//
//
//
//    }
}
