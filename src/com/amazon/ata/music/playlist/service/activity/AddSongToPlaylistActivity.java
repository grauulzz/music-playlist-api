package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.converters.AlbumTrackLinkedListConverter;
import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.exceptions.AlbumTrackNotFoundException;
import com.amazon.ata.music.playlist.service.exceptions.PlaylistNotFoundException;
import com.amazon.ata.music.playlist.service.models.requests.AddSongToPlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.AddSongToPlaylistResult;
import com.amazon.ata.music.playlist.service.models.SongModel;
import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.common.base.Equivalence;
import com.google.common.collect.Sets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.*;

/**
 * Implementation of the AddSongToPlaylistActivity for the MusicPlaylistService's AddSongToPlaylist API.
 *
 * This API allows the customer to add a song to their existing playlist.
 */
public class AddSongToPlaylistActivity implements RequestHandler<AddSongToPlaylistRequest, AddSongToPlaylistResult> {
    private final Logger log = LogManager.getLogger();
    private final PlaylistDao playlistDao;
    private final AlbumTrackDao albumTrackDao;
    SongModel songModel = new SongModel();



    /**
     * Instantiates a new AddSongToPlaylistActivity object.
     *
     * @param playlistDao PlaylistDao to access the playlist table.
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
     *                                 API defined {@link SongModel}s
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
        List<SongModel> songList = new ArrayList<>(playlist.getSongList().size());

        songModel = SongModel.builder()
                .withTrackNumber(trackNumber)
                .withAsin(asin)
                .withAlbum(albumTrack.getAlbumName())
                .withTitle(albumTrack.getSongTitle())
                .build();

        songList.add(songModel);

        try {
            playlist.getSongList().forEach(track -> {
                if (!track.equals(albumTrack)) {
                    songList.add(0, songModel);
                }
            });

            playlistDao.savePlaylist(playlist);

        } catch (PlaylistNotFoundException | AlbumTrackNotFoundException e) {
            log.error(e.getMessage());
            throw e;
        }

        log.info("Returning AddSongToPlaylistResult {} ", songList);

        return AddSongToPlaylistResult.builder()
                .withSongList(songList)
                .build();
    }
}
