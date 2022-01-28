package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.converters.ModelConverter;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.exceptions.InvalidAttributeChangeException;
import com.amazon.ata.music.playlist.service.exceptions.InvalidAttributeValueException;
import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.models.requests.UpdatePlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.UpdatePlaylistResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import javax.inject.Inject;

import static com.amazon.ata.music.playlist.service.util.MusicPlaylistServiceUtils.isValidString;


/**
 * Implementation of the UpdatePlaylistActivity for the MusicPlaylistService's UpdatePlaylist API.
 * This API allows the customer to update their saved playlist's information.
 */
public class UpdatePlaylistActivity implements RequestHandler<UpdatePlaylistRequest, UpdatePlaylistResult> {
    private final Logger log = LogManager.getLogger();
    private final PlaylistDao playlistDao;

    /**
     * Instantiates a new UpdatePlaylistActivity object.
     *
     * @param playlistDao PlaylistDao to access the playlist table.
     */
    @Inject
    public UpdatePlaylistActivity(PlaylistDao playlistDao) {
        this.playlistDao = playlistDao;
    }

    /**
     * This method handles the incoming request by retrieving the playlist, updating it,
     * and persisting the playlist.
     * <p>
     * It then returns the updated playlist.
     * <p>
     * If the playlist does not exist, this should throw a PlaylistNotFoundException.
     * <p>
     * If the provided playlist name or customer ID has invalid characters, throws an
     * InvalidAttributeValueException
     * <p>
     * If the request tries to update the customer ID,
     * this should throw an InvalidAttributeChangeException
     *
     * @param updatePlaylistRequest request object containing the playlist ID, playlist name, and customer ID
     *                              associated with it
     * @return updatePlaylistResult result object containing the API defined {@link PlaylistModel}
     */
    @Override
    public UpdatePlaylistResult handleRequest(final UpdatePlaylistRequest updatePlaylistRequest, Context context) {
        log.info("Received UpdatePlaylistRequest {}", updatePlaylistRequest);

        String requestedId = updatePlaylistRequest.getId();
        String requestedName = updatePlaylistRequest.getName();
        String requestedCustomerId = updatePlaylistRequest.getCustomerId();
        Playlist playlist = playlistDao.getPlaylist(requestedId);
        boolean validated = isValidString(requestedName) &&
                isValidString(requestedCustomerId);

        try {

            if (!validated) {
                throw new InvalidAttributeValueException("Invalid characters entry in playlist name or customer ID");
            }

            if (!Objects.equals(playlist.getCustomerId(), requestedCustomerId)) {
                throw new InvalidAttributeChangeException("Cannot change customer ID");
            }

            playlist.setCustomerId(requestedCustomerId);
            playlist.setName(requestedName);

            if (playlist.getSongCount() == null) {
                playlist.setSongCount(0);
            }

            if (playlist.getSongList() == null) {
                playlist.setSongList(Collections.emptyList());
            }

            playlistDao.savePlaylist(playlist);


        } catch (InvalidAttributeChangeException | InvalidAttributeValueException e) {
            log.error(e.getMessage());
            throw e;
        }

        return UpdatePlaylistResult
                .builder()
                .withPlaylist(new ModelConverter().toPlaylistModel(playlist))
                .build();

    }

}

