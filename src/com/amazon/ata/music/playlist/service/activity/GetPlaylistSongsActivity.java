package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.converters.ModelConverter;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.models.SongModel;
import com.amazon.ata.music.playlist.service.models.SongOrder;
import com.amazon.ata.music.playlist.service.models.requests.GetPlaylistSongsRequest;
import com.amazon.ata.music.playlist.service.models.results.GetPlaylistSongsResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.amazon.ata.music.playlist.service.models.SongOrder.getOrderedCollections;

/**
 * Implementation of the GetPlaylistSongsActivity for the MusicPlaylistService's GetPlaylistSongs API.
 * <p>
 * This API allows the customer to get the list of songs of a saved playlist.
 */
public class GetPlaylistSongsActivity implements RequestHandler<GetPlaylistSongsRequest, GetPlaylistSongsResult> {
    private final Logger log = LogManager.getLogger();
    private final PlaylistDao playlistDao;

    /**
     * Instantiates a new GetPlaylistSongsActivity object.
     *
     * @param playlistDao PlaylistDao to access the playlist table.
     */
    @Inject
    public GetPlaylistSongsActivity(PlaylistDao playlistDao) {
        this.playlistDao = playlistDao;
    }

    /**
     * This method handles the incoming request by retrieving the playlist from the database.
     * <p>
     * It then returns the playlist's song list.
     * <p>
     * If the playlist does not exist, this should throw a PlaylistNotFoundException.
     *
     * @param getPlaylistSongsRequest request object containing the playlist ID
     * @return getPlaylistSongsResult result object containing the playlist's list of API defined {@link SongModel}s
     */
    @Override
    public GetPlaylistSongsResult handleRequest(final GetPlaylistSongsRequest getPlaylistSongsRequest,
                                                Context context) {
        log.info("Received GetPlaylistSongsRequest {}", getPlaylistSongsRequest);

        String playlistId = getPlaylistSongsRequest.getId();
        Playlist playlist = playlistDao.getPlaylist(playlistId);
        SongOrder songOrder = getPlaylistSongsRequest.getOrder();
        List<SongModel> songModels = new ModelConverter().toSongModelList(playlist.getSongList());

        if (songOrder == null) {
            return GetPlaylistSongsResult.builder().withSongList(songModels).build();
        }

        if (songOrder != SongOrder.DEFAULT && songOrder != SongOrder.REVERSED && songOrder != SongOrder.SHUFFLED) {
            throw new NullPointerException("Invalid song order: " + songOrder);
        }

        return GetPlaylistSongsResult.builder()
                .withSongList(new ArrayList<>(getOrderedCollections(songOrder,
                        songModels)))
                .build();

    }

}

