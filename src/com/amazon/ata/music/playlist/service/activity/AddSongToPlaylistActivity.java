package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.converters.ModelConverter;
import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.exceptions.AlbumTrackNotFoundException;
import com.amazon.ata.music.playlist.service.exceptions.PlaylistNotFoundException;
import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.models.SongModel;
import com.amazon.ata.music.playlist.service.models.requests.AddSongToPlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.AddSongToPlaylistResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/**
 * Implementation of the AddSongToPlaylistActivity for the MusicPlaylistService's AddSongToPlaylist API.
 * <p>
 * This API allows the customer to add a song to their existing playlist.
 */
public class AddSongToPlaylistActivity implements RequestHandler<AddSongToPlaylistRequest, AddSongToPlaylistResult> {
    private final Logger log = LogManager.getLogger();
    private final PlaylistDao playlistDao;
    private final AlbumTrackDao albumTrackDao;


    /**
     * Instantiates a new AddSongToPlaylistActivity object.
     *
     * @param playlistDao   PlaylistDao to access the playlist table.
     * @param albumTrackDao AlbumTrackDao to access the album_track table.
     */
    @Inject
    public AddSongToPlaylistActivity(PlaylistDao playlistDao, AlbumTrackDao albumTrackDao) {
        this.playlistDao = playlistDao;
        this.albumTrackDao = albumTrackDao;
    }

    /**
     * This method handles the incoming request by adding an additional song
     * to a playlist and persisting the updated playlist.
     * <p>
     * It then returns the updated song list of the playlist.
     * <p>
     * If the playlist does not exist, this should throw a PlaylistNotFoundException.
     * <p>
     * If the album track does not exist, this should throw an AlbumTrackNotFoundException.
     *
     * @param addSongToPlaylistRequest request object containing the playlist ID and an asin and track number
     *                                 to retrieve the song data
     * @return addSongToPlaylistResult result object containing the playlist's updated list of
     * API defined {@link SongModel}s
     */
    @Override
    public AddSongToPlaylistResult handleRequest(final AddSongToPlaylistRequest addSongToPlaylistRequest,
                                                 Context context) {
        log.info("Received AddSongToPlaylistRequest {} ", addSongToPlaylistRequest);
        String playlistId = addSongToPlaylistRequest.getId();
        String asin = addSongToPlaylistRequest.getAsin();
        int trackNumber = addSongToPlaylistRequest.getTrackNumber();

        Playlist playlist = playlistDao.getPlaylist(playlistId);
        AlbumTrack albumTrack = albumTrackDao.getAlbumTrack(asin, trackNumber);
        List<AlbumTrack> songList = playlist.getSongList();

        try {

            if (!addSongToPlaylistRequest.isQueueNext()) {
                songList.add(albumTrack);
            }

            if (addSongToPlaylistRequest.isQueueNext()) {
                songList.add(0, albumTrack);
            }

            playlist.setSongList(songList);
            playlist.setSongCount(songList.size());

            playlistDao.savePlaylist(playlist);

        } catch (PlaylistNotFoundException | AlbumTrackNotFoundException e) {
            log.error(e.getMessage());
            throw e;
        }

        log.info("Returning AddSongToPlaylistResult {} ", songList);

        return AddSongToPlaylistResult.builder()
                .withSongList(new ModelConverter().toSongModelList(songList))
                .build();
    }
}
